import c3a.*;
import nasm.*;
import ts.Ts;
import ts.TsItemFct;
import ts.TsItemVar;

public class C3a2nasm implements C3aVisitor<NasmOperand> {
    private Nasm nasm;
    private TsItemFct currentFct;

    public C3a2nasm(C3a c3a, Ts table) {
        nasm = new Nasm(table);
        nasm.setTempCounter(c3a.getTempCounter());
        NasmLabel labelMain = new NasmLabel("main");
        nasm.ajouteInst(new NasmCall(null, labelMain, ""));
        NasmRegister reg_eax = nasm.newRegister();
        reg_eax.colorRegister(Nasm.REG_EAX);
        NasmRegister reg_ebx = nasm.newRegister();
        reg_ebx.colorRegister(Nasm.REG_EBX);
        nasm.ajouteInst(new NasmMov(null, reg_ebx, new NasmConstant(0), " valeur de retour du programme"));
        nasm.ajouteInst(new NasmMov(null, reg_eax, new NasmConstant(1), ""));
        nasm.ajouteInst(new NasmInt(null, ""));
        for (C3aInst instruction : c3a.listeInst) {
            instruction.accept(this);
        }
    }

    public Nasm getNasm() {
        return nasm;
    }

    @Override
    public NasmOperand visit(C3aInstAdd inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand oper1 = inst.op1.accept(this);
        NasmOperand oper2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);
        nasm.ajouteInst(new NasmMov(label, dest, oper1, ""));
        nasm.ajouteInst(new NasmAdd(null, dest, oper2, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstCall inst) {
        NasmRegister reg_esp = new NasmRegister(Nasm.REG_ESP);
        reg_esp.colorRegister(Nasm.REG_ESP);
        NasmLabel functionName = new NasmLabel(inst.op1.toString());
        nasm.ajouteInst(new NasmSub(null, reg_esp, new NasmConstant(4), "allocation mémoire pour la valeur de retour"));
        nasm.ajouteInst(new NasmCall(null, functionName, ""));
        nasm.ajouteInst(new NasmPop(null, inst.result.accept(this), "récupération de la valeur de retour"));
        if (inst.op1.val.nbArgs > 0) {
            nasm.ajouteInst(new NasmAdd(null, reg_esp, new NasmConstant(inst.op1.val.nbArgs  * 4), "désallocation des arguments"));
        }
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstFBegin inst) {
        currentFct = inst.val;
        currentFct.nbArgs = inst.val.nbArgs;
        System.out.println(currentFct.getNbArgs());
        NasmRegister reg_ebp = new NasmRegister(Nasm.REG_EBP);
        reg_ebp.colorRegister(Nasm.REG_EBP);
        NasmRegister reg_esp = new NasmRegister(Nasm.REG_ESP);
        reg_esp.colorRegister(Nasm.REG_ESP);
        NasmLabel labelMain = new NasmLabel(currentFct.getIdentif());
        nasm.ajouteInst(new NasmPush(labelMain, reg_ebp, "sauvegarde la valeur de ebp"));
        nasm.ajouteInst(new NasmMov(null, reg_ebp, reg_esp, "nouvelle valeur de ebp"));
        nasm.ajouteInst(new NasmSub(null, reg_esp, new NasmConstant(currentFct.getTable().nbVar() * 4), "allocation des variables locales"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInst inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfLess inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand gotoLabel = inst.result.accept(this);
        nasm.ajouteInst(new NasmCmp(label, inst.op1.accept(this), inst.op2.accept(this), "JumpIfLess 1"));
        nasm.ajouteInst(new NasmJl(null, gotoLabel, "JumpIfLess 2"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstMult inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand result = inst.result.accept(this);
        nasm.ajouteInst(new NasmMov(label, result, inst.op1.accept(this), ""));
        nasm.ajouteInst(new NasmMul(null, result, inst.op2.accept(this), ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstRead inst) {
        //TODO
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstSub inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand result = inst.result.accept(this);
        nasm.ajouteInst(new NasmMov(label, result, inst.op1.accept(this), ""));
        nasm.ajouteInst(new NasmSub(null, result, inst.op2.accept(this), ""));
        return result;
    }

    @Override
    public NasmOperand visit(C3aInstAffect inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        nasm.ajouteInst(new NasmMov(label, inst.result.accept(this), inst.op1.accept(this), "Affect"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstDiv inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand result = inst.result.accept(this);
        NasmRegister reg_eax = nasm.newRegister();
        reg_eax.colorRegister(Nasm.REG_EAX);
        nasm.ajouteInst(new NasmMov(label, reg_eax, inst.op1.accept(this), ""));
        NasmRegister destination = nasm.newRegister();
        nasm.ajouteInst(new NasmMov(null, destination, inst.op2.accept(this), ""));
        nasm.ajouteInst(new NasmDiv(null, destination, ""));
        nasm.ajouteInst(new NasmMov(null, result, reg_eax, ""));
        return result;
    }

    @Override
    public NasmOperand visit(C3aInstFEnd inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmRegister reg_esp = new NasmRegister(Nasm.REG_ESP);
        reg_esp.colorRegister(Nasm.REG_ESP);
        NasmRegister reg_ebp = new NasmRegister(Nasm.REG_EBP);
        reg_ebp.colorRegister(Nasm.REG_EBP);
        nasm.ajouteInst(new NasmAdd(label, reg_esp, new NasmConstant(currentFct.getTable().nbVar() * 4), "désallocation des variables locales"));
        nasm.ajouteInst(new NasmPop(null, reg_ebp, "restaure la valeur de ebp"));
        nasm.ajouteInst(new NasmRet(null, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfEqual inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand gotoLabel = inst.result.accept(this);
        nasm.ajouteInst(new NasmCmp(label, inst.op1.accept(this), inst.op2.accept(this), "JumpIfEqual 1"));
        nasm.ajouteInst(new NasmJe(null, gotoLabel, "JumpIfEqual 2"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfNotEqual inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand gotoLabel = inst.result.accept(this);
        nasm.ajouteInst(new NasmCmp(label, inst.op1.accept(this), inst.op2.accept(this), "jumpIfNotEqual 1"));
        nasm.ajouteInst(new NasmJne(null, gotoLabel, "jumpIfNotEqual 2"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJump inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        nasm.ajouteInst(new NasmJmp(label, inst.result.accept(this), "Jump"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstParam inst) {
        nasm.ajouteInst(new NasmPush(null, inst.op1.accept(this), "Param"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstReturn inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmRegister reg_ebp = new NasmRegister(Nasm.REG_EBP);
        reg_ebp.colorRegister(Nasm.REG_EBP);
        NasmRegister reg_esp = new NasmRegister(Nasm.REG_ESP);
        reg_esp.colorRegister(Nasm.REG_ESP);
//        nasm.ajouteInst(new NasmRet(label, ""));
        nasm.ajouteInst(new NasmMov(label, new NasmAddress(reg_ebp, '+', new NasmConstant(2)), inst.op1.accept(this), "ecriture de la valeur de retour"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstWrite inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmRegister reg_eax = nasm.newRegister();
        reg_eax.colorRegister(Nasm.REG_EAX);
        NasmLabel labelIprintLF = new NasmLabel("iprintLF");
        nasm.ajouteInst(new NasmMov(label, reg_eax, inst.op1.accept(this), "Write 1"));
        nasm.ajouteInst(new NasmCall(null, labelIprintLF, "Write 2"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aConstant oper) {
        return new NasmConstant(oper.val);
    }

    @Override
    public NasmOperand visit(C3aLabel oper) {
        return new NasmLabel(oper.toString());
    }

    @Override
    public NasmOperand visit(C3aTemp oper) {
        return new NasmRegister(oper.num);
    }

    @Override
    public NasmOperand visit(C3aVar oper) {
        TsItemVar variable = oper.item;
        NasmRegister reg_ebp = new NasmRegister(Nasm.REG_EBP);
        reg_ebp.colorRegister(Nasm.REG_EBP);
        if (variable.isParam) {
            //argument
            return new NasmAddress(reg_ebp, '+', new NasmConstant(2 + variable.portee.nbArg() - variable.adresse));
        }
        if (oper.index != null) {
            //tableau
            return new NasmAddress(new NasmLabel(variable.getIdentif()), '+', oper.index.accept(this));
        }
        if (currentFct.getTable().variables.containsKey(variable.identif)) {
            //variable locale
            return new NasmAddress(reg_ebp, '-', new NasmConstant(1 + variable.adresse));
        }
        //identifiant
        return new NasmAddress(new NasmLabel(variable.identif));
    }

    @Override
    public NasmOperand visit(C3aFunction oper) {
        return null;
    }
}

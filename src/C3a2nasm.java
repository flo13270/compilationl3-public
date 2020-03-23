import c3a.*;
import nasm.*;
import ts.Ts;
import ts.TsItemFct;
import ts.TsItemVar;

public class C3a2nasm implements C3aVisitor<NasmOperand> {
    private C3a c3a;
    private Nasm nasm;
    private Ts tableGlobale;
    private TsItemFct currentFct;

    public C3a2nasm(C3a c3a, Ts table) {
        tableGlobale = table;
        nasm = new Nasm(table);
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
        //TODO ?
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstFBegin inst) {
        currentFct = inst.val;
        NasmRegister reg_ebp = nasm.newRegister();
        reg_ebp.colorRegister(Nasm.REG_EBP);
        NasmRegister reg_esp = nasm.newRegister();
        reg_esp.colorRegister(Nasm.REG_ESP);
        NasmLabel labelMain = new NasmLabel("main");
        nasm.ajouteInst(new NasmPush(labelMain,reg_ebp,"sauvegarde la valeur de ebp"));
        nasm.ajouteInst(new NasmMov(null,reg_ebp, reg_esp,"nouvelle valeur de ebp"));
        nasm.ajouteInst(new NasmSub(null,reg_esp,new NasmConstant(0),"allocation des variables locales"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInst inst) {
        //TODO ?
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfLess inst) {
        NasmRegister temp = nasm.newRegister();
        NasmOperand label = inst.result.accept(this);

        //TODO if reg temp ou pas
        /*nasm.ajouteInst(new NasmMov(null,temp,inst.op1.accept(this),"JumpIfLess 1"));
        nasm.ajouteInst(new NasmCmp(null,temp,inst.op2.accept(this),"on passe par un registre temporaire"));*/
        nasm.ajouteInst(new NasmCmp(null,temp,inst.op2.accept(this),"JumpIfLess 1")); //TODO remplacer temp par registre entrant

        nasm.ajouteInst(new NasmJl(null,label,"JumpIfLess 2"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstMult inst) {
        NasmOperand result = inst.result.accept(this);
        nasm.ajouteInst(new NasmMov(null,result,inst.op1.accept(this),""));
        nasm.ajouteInst(new NasmMul(null,result,inst.op2.accept(this),""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstRead inst) {
        //TODO ?
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstSub inst) {
        NasmOperand result = inst.result.accept(this);
        nasm.ajouteInst(new NasmMov(null,result,inst.op1.accept(this),""));
        nasm.ajouteInst(new NasmSub(null,result,inst.op2.accept(this),""));
        return result;
    }

    @Override
    public NasmOperand visit(C3aInstAffect inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmRegister reg_eax = nasm.newRegister();
        reg_eax.colorRegister(Nasm.REG_EAX);
        //TODO mettre if selon si addresse ou pas
        //nasm.ajouteInst(new NasmMov(label,new NasmAddress(inst.result.accept(this)),inst.op1.accept(this),"Affect"));
        nasm.ajouteInst(new NasmMov(label,inst.result.accept(this),inst.op1.accept(this),"Affect"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstDiv inst) {
        NasmOperand result = inst.result.accept(this);
        NasmRegister reg_eax = nasm.newRegister();
        reg_eax.colorRegister(Nasm.REG_EAX);
        nasm.ajouteInst(new NasmMov(null,reg_eax,inst.op1.accept(this),""));
        NasmRegister destination = nasm.newRegister();
        nasm.ajouteInst(new NasmMov(null, destination,inst.op2.accept(this),""));
        nasm.ajouteInst(new NasmDiv(null,destination,""));
        nasm.ajouteInst(new NasmMov(null,result,reg_eax,""));//TODO pas sur que ce mov doit être là
        return result;
    }

    @Override
    public NasmOperand visit(C3aInstFEnd inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmRegister reg_esp = nasm.newRegister();
        reg_esp.colorRegister(Nasm.REG_ESP);
        NasmRegister reg_ebp = nasm.newRegister();
        reg_ebp.colorRegister(Nasm.REG_EBP);
        nasm.ajouteInst(new NasmAdd(label,reg_esp,new NasmConstant(0),"désallocation des variables locales"));
        nasm.ajouteInst(new NasmPop(null,reg_ebp,"restaure la valeur de ebp"));
        nasm.ajouteInst(new NasmRet(null,""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfEqual inst) {
        NasmRegister temp = nasm.newRegister();
        NasmOperand label = inst.result.accept(this);
        nasm.ajouteInst(new NasmMov(null,temp,inst.op1.accept(this),"JumpIfEqual 1"));
        nasm.ajouteInst(new NasmCmp(null,temp,inst.op2.accept(this),"on passe par un registre temporaire"));
        nasm.ajouteInst(new NasmJe(null,label,"JumpIfEqual 2"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfNotEqual inst) {
        NasmRegister temp = nasm.newRegister();
        NasmOperand label = inst.result.accept(this);
        nasm.ajouteInst(new NasmMov(null,temp,inst.op1.accept(this),"jumpIfNotEqual 1"));
        nasm.ajouteInst(new NasmCmp(null,temp,inst.op2.accept(this),"on passe par un registre temporaire"));
        nasm.ajouteInst(new NasmJne(null,label,"jumpIfNotEqual 2"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJump inst) {
        nasm.ajouteInst(new NasmJmp(null,inst.result.accept(this),"Jump"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstParam inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstReturn inst) {
        nasm.ajouteInst(new NasmRet(null, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstWrite inst) {
        NasmOperand label = (inst.label != null) ? inst.label.accept(this) : null;
        NasmOperand param = nasm.newRegister();
        NasmRegister reg_eax = nasm.newRegister();
        reg_eax.colorRegister(Nasm.REG_EAX);
		NasmLabel labelIprintLF = new NasmLabel("iprintLF");
        nasm.ajouteInst(new NasmMov(label, reg_eax, inst.op1.accept(this), "Write 1"));
        nasm.ajouteInst(new NasmCall(null, labelIprintLF,"Write 2"));
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

/*    @Override
    public NasmOperand visit(C3aVar oper) {
        nasm.newRegister();
        nasm.ajouteInst(new NasmInt(oper.accept(this), ""));
        return oper.accept(this);
    }*/

    //TODO enlever cette fonction parce que c'est pas moi qui l'ai écrite
    @Override
    public NasmOperand visit(C3aVar oper) {
        TsItemVar variable = oper.item;
        NasmRegister reg_ebp = nasm.newRegister();
        reg_ebp.colorRegister(Nasm.REG_EBP);
        if (variable.isParam) {
            int argsCount = variable.portee.nbArg();
            int varIndex = variable.adresse;
            return new NasmAddress(reg_ebp, '+', new NasmConstant(2 + argsCount - varIndex));
        }
        if (oper.index != null) {
            NasmOperand indexOperand = oper.index.accept(this);
            return new NasmAddress(new NasmLabel(variable.getIdentif()), '+', indexOperand);
        }
        boolean isLocal = currentFct.getTable().variables.containsKey(variable.identif);
        if (isLocal)
            return new NasmAddress(reg_ebp, '-', new NasmConstant(1 + variable.adresse));
        return new NasmAddress(new NasmLabel(variable.identif));
    }

    @Override
    public NasmOperand visit(C3aFunction oper) {
        //TODO ?
        return null;
    }
}

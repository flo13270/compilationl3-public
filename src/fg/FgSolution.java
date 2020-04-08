package fg;

import util.graph.*;
import nasm.*;
import util.intset.*;

import java.io.*;
import java.util.*;

public class FgSolution {
    int iterNum = 0;
    public Nasm nasm;
    Fg fg;
    public Map<NasmInst, IntSet> use;
    public Map<NasmInst, IntSet> def;
    public Map<NasmInst, IntSet> in;
    public Map<NasmInst, IntSet> out;

    public FgSolution(Nasm nasm, Fg fg) {
        this.nasm = nasm;
        this.fg = fg;
        this.use = new HashMap<NasmInst, IntSet>();
        this.def = new HashMap<NasmInst, IntSet>();
        this.in = new HashMap<NasmInst, IntSet>();
        this.out = new HashMap<NasmInst, IntSet>();

        for (NasmInst inst : nasm.listeInst) {
            IntSet defSet = new IntSet(nasm.listeInst.size());
            IntSet useSet = new IntSet(nasm.listeInst.size());

            if (inst.srcDef && inst.source.isGeneralRegister()) {
                defSet.add(((NasmRegister) inst.source).val);
            }
            if (inst.destUse && inst.destination.isGeneralRegister()) {
                useSet.add(((NasmRegister) inst.destination).val);
            }
            if (inst.destDef && inst.destination.isGeneralRegister()) {
                defSet.add(((NasmRegister) inst.source).val);
            }
            if (inst.srcUse && inst.source.isGeneralRegister()) {
                useSet.add(((NasmRegister) inst.destination).val);
            }
            def.put(inst, defSet);
            use.put(inst, useSet);
        }
    }

    public void affiche(String baseFileName) {
        String fileName;
        PrintStream out = System.out;

        if (baseFileName != null) {
            try {
                baseFileName = baseFileName;
                fileName = baseFileName + ".fgs";
                out = new PrintStream(fileName);
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        out.println("iter num = " + iterNum);
        for (NasmInst nasmInst : this.nasm.listeInst) {
            out.println("use = " + this.use.get(nasmInst) + " def = " + this.def.get(nasmInst) + "\tin = " + this.in.get(nasmInst) + "\t \tout = " + this.out.get(nasmInst) + "\t \t" + nasmInst);
        }
    }
}

    

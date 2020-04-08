package fg;

import nasm.*;
import util.graph.*;

import java.util.*;
import java.io.*;

public class Fg implements NasmVisitor<Void> {
    //TODO div2.fg a un nom de pseudo-registre pour je ne sais quelle raison entre pre nasm et fg
    public Nasm nasm;
    public Graph graph;
    Map<NasmInst, Node> inst2Node;
    Map<Node, NasmInst> node2Inst;
    Map<String, NasmInst> label2Inst;

    public Fg(Nasm nasm) {
        this.nasm = nasm;
        this.inst2Node = new HashMap<NasmInst, Node>();
        this.node2Inst = new HashMap<Node, NasmInst>();
        this.label2Inst = new HashMap<String, NasmInst>();
        this.graph = new Graph();

        for (NasmInst inst : nasm.listeInst) {
            Node node = graph.newNode();
            inst2Node.put(inst, node);
            node2Inst.put(node, inst);
            if (inst.label != null) label2Inst.put(inst.label.toString(), inst);
        }

        for (NasmInst inst : nasm.listeInst) {
            inst.accept(this);
        }
    }

    public void affiche(String baseFileName) {
        String fileName;
        PrintStream out = System.out;

        if (baseFileName != null) {
            try {
                baseFileName = baseFileName;
                fileName = baseFileName + ".fg";
                out = new PrintStream(fileName);
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        for (NasmInst nasmInst : nasm.listeInst) {
            Node n = this.inst2Node.get(nasmInst);
            out.print(n + " : ( ");
            for (NodeList q = n.succ(); q != null; q = q.tail) {
                out.print(q.head.toString());
                out.print(" ");
            }
            out.println(")\t" + nasmInst);
        }
    }

    void linkNodeToNext(NasmInst inst) {
        Node from = this.inst2Node.get(inst);
        if (nasm.listeInst.indexOf(inst)+1 >= nasm.listeInst.size()) return;
        int nextInstIndex = nasm.listeInst.indexOf(inst) + 1;
        NasmInst nextInst = nasm.listeInst.get(nextInstIndex);
        Node to = this.inst2Node.get(nextInst);
        graph.addEdge(from, to);
    }

    void linkNodeToGoto(NasmInst inst){
        Node from = this.inst2Node.get(inst);
        String labelName = inst.address.toString();
        NasmInst nextInst = this.label2Inst.get(labelName);
        Node to = this.inst2Node.get(nextInst);
        if (to != null) {
            graph.addEdge(from, to);
        }
    }

    public Void visit(NasmAdd inst) {
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmCall inst) {
        linkNodeToGoto(inst);
        return null;
    }

    public Void visit(NasmDiv inst) {
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmJe inst) {
        linkNodeToGoto(inst);
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmJle inst) {
        linkNodeToGoto(inst);
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmJne inst) {
        linkNodeToGoto(inst);
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmMul inst) {
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmOr inst) {
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmCmp inst) {
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmInst inst) {
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmJge inst) {
        linkNodeToGoto(inst);
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmJl inst) {
        linkNodeToGoto(inst);
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmNot inst) {
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmPop inst) {
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmRet inst) {
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmXor inst) {
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmAnd inst) {
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmJg inst) {
        linkNodeToGoto(inst);
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmJmp inst) {
        linkNodeToGoto(inst);
        return null;
    }

    public Void visit(NasmMov inst) {
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmPush inst) {
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmSub inst) {
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmEmpty inst) {
        linkNodeToNext(inst);
        return null;
    }

    public Void visit(NasmAddress operand) {
        return null;
    }

    public Void visit(NasmConstant operand) {
        return null;
    }

    public Void visit(NasmLabel operand) {
        return null;
    }

    public Void visit(NasmRegister operand) {
        return null;
    }


}

# compilationl3-public

pour ajouter le package sc (ainsi que ses sous-packages analysis, lexer, node et parser),
aller dans src et exécuter la commande "java -jar ../sablecc.jar grammaireL.sablecc"

**Code repris ailleurs**

Repris, et inliné depuis le code de Nicolas Bourras
```java11
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
```
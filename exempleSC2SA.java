private <T extends SaNode> T retrieveNode(Node node) {
        if(node == null)
            return null;
        node.apply(this);
        return (T)returnValue;
    }

    private <T extends SaExp> T retrieveExp(Node node) {
        SaLExp saLExp = retrieveNode(node);
//        while (saLExp.getQueue() != null)
//            saLExp = saLExp.getQueue();
        return (T)saLExp.getTete();
    }

    @Override
    public void caseAProgramme(AProgramme node) {
        returnValue = new SaProg(
                retrieveNode(node.getOptdecvar()),
                retrieveNode(node.getListedecfonc())
        );
    }

    @Override
    public void caseAIntegerType(AIntegerType node) {
        returnValue = null;
    }

    @Override
    public void caseAVarSimpleDecVar(AVarSimpleDecVar node) {
        returnValue = new SaDecVar(node.getIdent().getText());
    }

    @Override
    public void caseAArrayVarDecVar(AArrayVarDecVar node) {
        returnValue = new SaDecTab(node.getIdent().getText(), Integer.parseInt(node.getNumber().getText()));
    }

    @Override
    public void caseADecVarDecArg(ADecVarDecArg node) {
        returnValue = new SaLDec(retrieveNode(node.getDecVar()), null);
    }

    @Override
    public void caseADecVarsDecArg(ADecVarsDecArg node) {
        returnValue = new SaLDec(retrieveNode(node.getDecVar()), retrieveNode(node.getDecArg()));
    }

    @Override
    public void caseAAffectationInstrSimple(AAffectationInstrSimple node) {
        returnValue = new SaInstAffect(retrieveNode(node.getVar()), retrieveExp(node.getExp()));
    }

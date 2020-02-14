package compiler;

import sa.*;
import sc.analysis.DepthFirstAdapter;
import sc.node.*;

public class Sc2sa extends DepthFirstAdapter {
	private SaNode returnValue;

	@SuppressWarnings("unchecked")
	private <T extends SaNode> T retrieveNode(Node node) {
		if (node == null)
			return null;
		node.apply(this);
		return (T) returnValue;
	}

	// TODO : faite ça pour les 50 autres fonctions
	// TODO : quand il n'y a qu'un seul fils, simplement appeler le super
	@Override
	public void caseAPlusExp3(APlusExp3 node) {
		SaExp op1 = retrieveNode(node.getExp3());
		SaExp op2 = retrieveNode(node.getExp4());
		this.returnValue = new SaExpAdd(op1, op2);
	}

	@Override
	public void caseAAppelfctExp6(AAppelfctExp6 node) {
		super.caseAAppelfctExp6(node);
	}

	@Override
	public void caseAAvecparamAppelfct(AAvecparamAppelfct node) {
		String fonction = node.getIdentif().getText();
		SaLExp args = retrieveNode(node.getListeexp());
		returnValue = new SaAppel(fonction, args);
	}

	@Override
	public void caseAAvecparamListeparam(AAvecparamListeparam node) {
		node.getListedecvar().apply(this);
	}

	@Override
	public void caseAAvecsinonInstrsi(AAvecsinonInstrsi node) {
		SaExp test = retrieveNode(node.getExp());
		SaInst alors = retrieveNode(node.getInstrbloc());
		SaInst sinon = retrieveNode(node.getInstrsinon());
		this.returnValue = new SaInstSi(test, alors, sinon);
	}

	@Override
	public void caseADecvarentierDecvar(ADecvarentierDecvar node) {
		String nom = node.getIdentif().getText();
		this.returnValue = new SaDecVar(nom);
	}

	@Override
	public void caseADecvarinstrDecfonc(ADecvarinstrDecfonc node) {
		super.caseADecvarinstrDecfonc(node);
		String nom = node.getIdentif().getText();
		SaLDec parametres =  retrieveNode(node.getListeparam());
		SaLDec variables = retrieveNode(node.getOptdecvar());
		SaInst corps = retrieveNode(node.getInstrbloc());
		
		this.returnValue = new SaDecFonc(nom, parametres, variables, corps);
	}

	@Override
	public void caseADecvarldecfoncProgramme(ADecvarldecfoncProgramme node) {
		SaLDec fonctions = retrieveNode(node.getListedecfonc());
		SaLDec variables = retrieveNode(node.getOptdecvar());
		this.returnValue = new SaProg(variables, fonctions);
	}

	@Override
	public void caseADecvarldecvarListedecvar(ADecvarldecvarListedecvar node) {
		SaDec tete = retrieveNode(node.getDecvar());
		SaLDec queue = retrieveNode(node.getListedecvarbis());
		this.returnValue = new SaLDec(tete, queue);
	}

	@Override
	public void caseADecvarldecvarListedecvarbis(ADecvarldecvarListedecvarbis node) {
		SaDec tete = retrieveNode(node.getDecvar());
		SaLDec queue = retrieveNode(node.getListedecvarbis());
		this.returnValue = new SaLDec(tete, queue);
	}

	@Override
	public void caseADecvarListedecvar(ADecvarListedecvar node) {
		SaDec tete = retrieveNode(node.getDecvar());
		this.returnValue = new SaLDec(tete, null);
	}

	@Override
	public void caseADecvarListedecvarbis(ADecvarListedecvarbis node) {
		SaDec tete = retrieveNode(node.getDecvar());
		this.returnValue = new SaLDec(tete, null);
	}

	@Override
	public void caseADecvartableauDecvar(ADecvartableauDecvar node) {
		String nom = node.getIdentif().getText();
		int taille = Integer.parseInt(node.getNombre().getText());
		this.returnValue = new SaDecTab(nom, taille);
	}

	@Override
	public void caseADiviseExp4(ADiviseExp4 node) {
		SaExp op1 = retrieveNode(node.getExp4());
		SaExp op2 = retrieveNode(node.getExp5());
		this.returnValue = new SaExpDiv(op1, op2);
	}

	@Override
	public void caseAEgalExp2(AEgalExp2 node) {
		// TODO Auto-generated method stub
		super.caseAEgalExp2(node);
	}

	@Override
	public void caseAEtExp1(AEtExp1 node) {
		node.getExp1().apply(this);
		SaExp op1 = (SaExp) this.returnValue;
		node.getExp2().apply(this);
		SaExp op2 = (SaExp) this.returnValue;
		this.returnValue = new SaExpAnd(op1, op2);
	}

	@Override
	public void caseAFinalListeexp(AFinalListeexp node) {
		// TODO Auto-generated method stub
		super.caseAFinalListeexp(node);
	}

	@Override
	public void caseAFinalListeexpbis(AFinalListeexpbis node) {
		// TODO Auto-generated method stub
		super.caseAFinalListeexpbis(node);
	}

	@Override
	public void caseAFoisExp4(AFoisExp4 node) {
		// TODO Auto-generated method stub
		super.caseAFoisExp4(node);
	}

	@Override
	public void caseAInfExp2(AInfExp2 node) {
		// TODO Auto-generated method stub
		super.caseAInfExp2(node);
	}

	@Override
	public void caseAInstraffect(AInstraffect node) {
		// TODO Auto-generated method stub
		super.caseAInstraffect(node);
	}

	@Override
	public void caseAInstraffectInstr(AInstraffectInstr node) {
		// TODO Auto-generated method stub
		super.caseAInstraffectInstr(node);
	}

	@Override
	public void caseAInstrappel(AInstrappel node) {
		// TODO Auto-generated method stub
		super.caseAInstrappel(node);
	}

	@Override
	public void caseAInstrappelInstr(AInstrappelInstr node) {
		// TODO Auto-generated method stub
		super.caseAInstrappelInstr(node);
	}

	@Override
	public void caseAInstrbloc(AInstrbloc node) {
		// TODO Auto-generated method stub
		super.caseAInstrbloc(node);
	}

	@Override
	public void caseAInstrblocInstr(AInstrblocInstr node) {
		// TODO Auto-generated method stub
		super.caseAInstrblocInstr(node);
	}

	@Override
	public void caseAInstrDecfonc(AInstrDecfonc node) {
		// TODO Auto-generated method stub
		super.caseAInstrDecfonc(node);
	}

	@Override
	public void caseAInstrecriture(AInstrecriture node) {
		// TODO Auto-generated method stub
		super.caseAInstrecriture(node);
	}

	@Override
	public void caseAInstrecritureInstr(AInstrecritureInstr node) {
		// TODO Auto-generated method stub
		super.caseAInstrecritureInstr(node);
	}

	@Override
	public void caseAInstrretour(AInstrretour node) {
		// TODO Auto-generated method stub
		super.caseAInstrretour(node);
	}

	@Override
	public void caseAInstrretourInstr(AInstrretourInstr node) {
		// TODO Auto-generated method stub
		super.caseAInstrretourInstr(node);
	}

	@Override
	public void caseAInstrsiInstr(AInstrsiInstr node) {
		// TODO Auto-generated method stub
		super.caseAInstrsiInstr(node);
	}

	@Override
	public void caseAInstrsinon(AInstrsinon node) {
		// TODO Auto-generated method stub
		super.caseAInstrsinon(node);
	}

	@Override
	public void caseAInstrtantque(AInstrtantque node) {
		// TODO Auto-generated method stub
		super.caseAInstrtantque(node);
	}

	@Override
	public void caseAInstrtantqueInstr(AInstrtantqueInstr node) {
		node.getInstrtantque().apply(this);
	}

	@Override
	public void caseAInstrvide(AInstrvide node) {
		// TODO Auto-generated method stub
		super.caseAInstrvide(node);
	}

	@Override
	public void caseAInstrvideInstr(AInstrvideInstr node) {
		// TODO Auto-generated method stub
		super.caseAInstrvideInstr(node);
	}

	@Override
	public void caseALdecfoncfinalListedecfonc(ALdecfoncfinalListedecfonc node) {
		// TODO Auto-generated method stub
		super.caseALdecfoncfinalListedecfonc(node);
	}

	@Override
	public void caseALdecfoncProgramme(ALdecfoncProgramme node) {
		// TODO Auto-generated method stub
		super.caseALdecfoncProgramme(node);
	}

	@Override
	public void caseALdecfoncrecListedecfonc(ALdecfoncrecListedecfonc node) {
		// TODO Auto-generated method stub
		super.caseALdecfoncrecListedecfonc(node);
	}

	@Override
	public void caseALinstfinalListeinst(ALinstfinalListeinst node) {
		// TODO Auto-generated method stub
		super.caseALinstfinalListeinst(node);
	}

	@Override
	public void caseALinstrecListeinst(ALinstrecListeinst node) {
		// TODO Auto-generated method stub
		super.caseALinstrecListeinst(node);
	}

	@Override
	public void caseALireExp6(ALireExp6 node) {
		// TODO Auto-generated method stub
		super.caseALireExp6(node);
	}

	@Override
	public void caseAMoinsExp3(AMoinsExp3 node) {
		// TODO Auto-generated method stub
		super.caseAMoinsExp3(node);
	}

	@Override
	public void caseANombreExp6(ANombreExp6 node) {
		// TODO Auto-generated method stub
		super.caseANombreExp6(node);
	}

	@Override
	public void caseANonExp5(ANonExp5 node) {
		// TODO Auto-generated method stub
		super.caseANonExp5(node);
	}

	@Override
	public void caseAOptdecvar(AOptdecvar node) {
		// TODO Auto-generated method stub
		super.caseAOptdecvar(node);
	}

	@Override
	public void caseAOuExp(AOuExp node) {
		// TODO Auto-generated method stub
		super.caseAOuExp(node);
	}

	@Override
	public void caseAParenthesesExp6(AParenthesesExp6 node) {
		// TODO Auto-generated method stub
		super.caseAParenthesesExp6(node);
	}

	@Override
	public void caseARecursifListeexp(ARecursifListeexp node) {
		// TODO Auto-generated method stub
		super.caseARecursifListeexp(node);
	}

	@Override
	public void caseARecursifListeexpbis(ARecursifListeexpbis node) {
		// TODO Auto-generated method stub
		super.caseARecursifListeexpbis(node);
	}

	@Override
	public void caseASansparamAppelfct(ASansparamAppelfct node) {
		// TODO Auto-generated method stub
		super.caseASansparamAppelfct(node);
	}

	@Override
	public void caseASansparamListeparam(ASansparamListeparam node) {
		// TODO Auto-generated method stub
		super.caseASansparamListeparam(node);
	}

	@Override
	public void caseASanssinonInstrsi(ASanssinonInstrsi node) {
		// TODO Auto-generated method stub
		super.caseASanssinonInstrsi(node);
	}

	@Override
	public void caseAVarExp6(AVarExp6 node) {
		// TODO Auto-generated method stub
		super.caseAVarExp6(node);
	}

	@Override
	public void caseAVarsimpleVar(AVarsimpleVar node) {
		// TODO Auto-generated method stub
		super.caseAVarsimpleVar(node);
	}

	@Override
	public void caseAVartabVar(AVartabVar node) {
		// TODO Auto-generated method stub
		super.caseAVartabVar(node);
	}

	public SaNode getRoot() {
		return returnValue;
	}
}
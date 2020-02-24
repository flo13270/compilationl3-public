
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

	@Override
	public void caseAPlusExp3(APlusExp3 node) {
		SaExp op1 = retrieveNode(node.getExp3());
		SaExp op2 = retrieveNode(node.getExp4());
		this.returnValue = new SaExpAdd(op1, op2);
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
		SaLDec parametres = retrieveNode(node.getListeparam());
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
		SaExp op1 = retrieveNode(node.getExp2());
		SaExp op2 = retrieveNode(node.getExp3());
		this.returnValue = new SaExpEqual(op1, op2);
	}

	@Override
	public void caseAEtExp1(AEtExp1 node) {
		SaExp op1 = retrieveNode(node.getExp1());
		SaExp op2 = retrieveNode(node.getExp2());
		this.returnValue = new SaExpAnd(op1, op2);
	}

	@Override
	public void caseAFinalListeexpbis(AFinalListeexpbis node) {
		returnValue = new SaLExp(retrieveNode(node.getExp()), null);
	}

	@Override
	public void caseAFoisExp4(AFoisExp4 node) {
		SaExp op1 = retrieveNode(node.getExp4());
		SaExp op2 = retrieveNode(node.getExp5());
		returnValue = new SaExpMult(op1, op2);
	}

	@Override
	public void caseAInfExp2(AInfExp2 node) {
		SaExp op1 = retrieveNode(node.getExp2());
		SaExp op2 = retrieveNode(node.getExp3());
		returnValue = new SaExpInf(op1, op2);
	}

	@Override
	public void caseAVarExp6(AVarExp6 node) {
		returnValue = new SaExpVar(retrieveNode(node.getVar()));
	}

	@Override
	public void caseAAppelfctExp6(AAppelfctExp6 node) {
		returnValue = new SaExpAppel(retrieveNode(node.getAppelfct()));
	}

	@Override
	public void caseAInstraffect(AInstraffect node) {
		SaVar lhs = retrieveNode(node.getVar());
		SaExp rhs = retrieveNode(node.getExp());
		returnValue = new SaInstAffect(lhs, rhs);
	}

	@Override
	public void caseAInstrappel(AInstrappel node) {
		node.getAppelfct().apply(this);
	}

	@Override
	public void caseAInstrbloc(AInstrbloc node) {
		returnValue = new SaInstBloc(retrieveNode(node.getListeinst()));
	}

	@Override
	public void caseAInstrDecfonc(AInstrDecfonc node) {
		String nom = node.getIdentif().getText();
		SaLDec parametres = retrieveNode(node.getListeparam());
		SaLDec variables = null;
		SaInst corps = retrieveNode(node.getInstrbloc());
		returnValue = new SaDecFonc(nom, parametres, variables, corps);
	}

	@Override
	public void caseAInstrecriture(AInstrecriture node) {
		returnValue = new SaInstEcriture(retrieveNode(node.getExp()));
	}

	@Override
	public void caseAInstrretour(AInstrretour node) {
		SaExp val = retrieveNode(node.getExp());
		returnValue = new SaInstRetour(val);
	}

	@Override
	public void caseAInstrsinon(AInstrsinon node) {
		node.getInstrbloc().apply(this);
	}

	@Override
	public void caseAInstrtantque(AInstrtantque node) {
		SaExp test = retrieveNode(node.getExp());
		SaInst faire = retrieveNode(node.getInstrbloc());
		returnValue = new SaInstTantQue(test, faire);
	}

	@Override
	public void caseAInstrvide(AInstrvide node) {
		returnValue = null;
	}

	@Override
	public void caseAInstrvideInstr(AInstrvideInstr node) {
		node.getInstrvide().apply(this);
	}

	@Override
	public void caseALdecfoncrecListedecfonc(ALdecfoncrecListedecfonc node) {
		SaDec tete = retrieveNode(node.getDecfonc());
		SaLDec queue = retrieveNode(node.getListedecfonc());
		returnValue = new SaLDec(tete, queue);
	}

	@Override
	public void caseALinstrecListeinst(ALinstrecListeinst node) {
		SaInst tete = retrieveNode(node.getInstr());
		SaLInst queue = retrieveNode(node.getListeinst());
		returnValue = new SaLInst(tete, queue);
	}

	@Override
	public void caseALireExp6(ALireExp6 node) {
		node.getLire().apply(this);
	}

	@Override
	public void caseAMoinsExp3(AMoinsExp3 node) {
		SaExp op1 = retrieveNode(node.getExp3());
		SaExp op2 = retrieveNode(node.getExp4());
		returnValue = new SaExpSub(op1, op2);
	}

	@Override
	public void caseANonExp5(ANonExp5 node) {
		SaExp op1 = retrieveNode(node.getExp5());
		returnValue = new SaExpNot(op1);
	}

	@Override
	public void caseAOptdecvar(AOptdecvar node) {
		node.getListedecvar().apply(this);
	}

	@Override
	public void caseAOuExp(AOuExp node) {
		SaExp op1 = retrieveNode(node.getExp());
		SaExp op2 = retrieveNode(node.getExp1());
		returnValue = new SaExpOr(op1, op2);
	}

	@Override
	public void caseAParenthesesExp6(AParenthesesExp6 node) {
		node.getExp().apply(this);
	}

	@Override
	public void caseARecursifListeexp(ARecursifListeexp node) {
		SaExp tete = retrieveNode(node.getExp());
		SaLExp queue = retrieveNode(node.getListeexpbis());
		returnValue = new SaLExp(tete, queue);
	}

	@Override
	public void caseARecursifListeexpbis(ARecursifListeexpbis node) {
		SaExp tete = retrieveNode(node.getExp());
		SaLExp queue = retrieveNode(node.getListeexpbis());
		returnValue = new SaLExp(tete, queue);
	}

	@Override
	public void caseASansparamAppelfct(ASansparamAppelfct node) {
		returnValue = new SaAppel(node.getIdentif().getText(), null);
	}

	@Override
	public void caseASansparamListeparam(ASansparamListeparam node) {
		returnValue = null;
	}

	@Override
	public void caseASanssinonInstrsi(ASanssinonInstrsi node) {
		SaExp test = retrieveNode(node.getExp());
		SaInst alors = retrieveNode(node.getInstrbloc());
		SaInst sinon = null;
		returnValue = new SaInstSi(test, alors, sinon);
	}

	@Override
	public void caseAVarsimpleVar(AVarsimpleVar node) {
		returnValue = new SaVarSimple(node.getIdentif().getText());
	}

	@Override
	public void caseAVartabVar(AVartabVar node) {
		String nom = node.getIdentif().getText();
		SaExp indice = retrieveNode(node.getExp());
		returnValue = new SaVarIndicee(nom, indice);
	}

	@Override
	public void caseANombreExp6(ANombreExp6 node) {
		returnValue = new SaExpInt(Integer.parseInt(node.getNombre().getText()));
	}

	@Override
	public void caseALdecfoncfinalListedecfonc(ALdecfoncfinalListedecfonc node) {
		returnValue = null;
	}

	@Override
	public void caseALinstfinalListeinst(ALinstfinalListeinst node) {
		returnValue = null;
	}

	@Override
	public void caseAFinalListeexp(AFinalListeexp node) {
		returnValue = new SaLExp(retrieveNode(node.getExp()), null);
	}

	@Override
	public void caseALdecfoncProgramme(ALdecfoncProgramme node) {
		returnValue = new SaProg(null, retrieveNode(node.getListedecfonc()));
	}

	public SaNode getRoot() {
		return returnValue;
	}
}
package compiler;

import sa.SaExp;
import sa.SaExpAdd;
import sa.SaNode;
import sc.analysis.DepthFirstAdapter;
import sc.node.AAppelfctExp6;
import sc.node.AAvecparamAppelfct;
import sc.node.AAvecparamListeparam;
import sc.node.AAvecsinonInstrsi;
import sc.node.ADecvarListedecvar;
import sc.node.ADecvarListedecvarbis;
import sc.node.ADecvarentierDecvar;
import sc.node.ADecvarinstrDecfonc;
import sc.node.ADecvarldecfoncProgramme;
import sc.node.ADecvarldecvarListedecvar;
import sc.node.ADecvarldecvarListedecvarbis;
import sc.node.ADecvartableauDecvar;
import sc.node.ADiviseExp4;
import sc.node.AEgalExp2;
import sc.node.AEtExp1;
import sc.node.AExp1Exp;
import sc.node.AExp2Exp1;
import sc.node.AExp3Exp2;
import sc.node.AExp4Exp3;
import sc.node.AExp5Exp4;
import sc.node.AExp6Exp5;
import sc.node.AFinalListeexp;
import sc.node.AFinalListeexpbis;
import sc.node.AFoisExp4;
import sc.node.AInfExp2;
import sc.node.AInstrDecfonc;
import sc.node.AInstraffect;
import sc.node.AInstraffectInstr;
import sc.node.AInstrappel;
import sc.node.AInstrappelInstr;
import sc.node.AInstrbloc;
import sc.node.AInstrblocInstr;
import sc.node.AInstrecriture;
import sc.node.AInstrecritureInstr;
import sc.node.AInstrretour;
import sc.node.AInstrretourInstr;
import sc.node.AInstrsiInstr;
import sc.node.AInstrsinon;
import sc.node.AInstrtantque;
import sc.node.AInstrtantqueInstr;
import sc.node.AInstrvide;
import sc.node.AInstrvideInstr;
import sc.node.ALdecfoncProgramme;
import sc.node.ALdecfoncfinalListedecfonc;
import sc.node.ALdecfoncrecListedecfonc;
import sc.node.ALinstfinalListeinst;
import sc.node.ALinstrecListeinst;
import sc.node.ALireExp6;
import sc.node.AMoinsExp3;
import sc.node.ANombreExp6;
import sc.node.ANonExp5;
import sc.node.AOptdecvar;
import sc.node.AOuExp;
import sc.node.AParenthesesExp6;
import sc.node.APlusExp3;
import sc.node.ARecursifListeexp;
import sc.node.ARecursifListeexpbis;
import sc.node.ASansparamAppelfct;
import sc.node.ASansparamListeparam;
import sc.node.ASanssinonInstrsi;
import sc.node.AVarExp6;
import sc.node.AVarsimpleVar;
import sc.node.AVartabVar;
import sc.node.EOF;
import sc.node.InvalidToken;
import sc.node.Start;
import sc.node.TAccoladeFermante;
import sc.node.TAccoladeOuvrante;
import sc.node.TAlors;
import sc.node.TCommentaire;
import sc.node.TCrochetFermant;
import sc.node.TCrochetOuvrant;
import sc.node.TDivise;
import sc.node.TEcrire;
import sc.node.TEgal;
import sc.node.TEntier;
import sc.node.TEspaces;
import sc.node.TEt;
import sc.node.TFaire;
import sc.node.TFois;
import sc.node.TIdentif;
import sc.node.TInferieur;
import sc.node.TLire;
import sc.node.TMoins;
import sc.node.TNombre;
import sc.node.TNon;
import sc.node.TOu;
import sc.node.TParentheseFermante;
import sc.node.TParentheseOuvrante;
import sc.node.TPlus;
import sc.node.TPointVirgule;
import sc.node.TRetour;
import sc.node.TSi;
import sc.node.TSinon;
import sc.node.TTantque;
import sc.node.TVirgule;

public class Sc2sa extends DepthFirstAdapter {
	private SaNode returnValue;

	// TODO : faite ça pour les 50 autres fonctions
	// TODO : quand il n'y a qu'un seul fils, simplement appeler le super
	@Override
	public void caseAPlusExp3(APlusExp3 node) {
		SaExp op1 = null;
		SaExp op2 = null;
		node.getExp3().apply(this);
		op1 = (SaExp) this.returnValue;
		node.getExp4().apply(this);
		op2 = (SaExp) this.returnValue;
		this.returnValue = new SaExpAdd(op1, op2);
	}

	@Override
	public void caseAAppelfctExp6(AAppelfctExp6 node) {
		// TODO Auto-generated method stub
		super.caseAAppelfctExp6(node);
	}

	@Override
	public void caseAAvecparamAppelfct(AAvecparamAppelfct node) {
		// TODO Auto-generated method stub
		super.caseAAvecparamAppelfct(node);
	}

	@Override
	public void caseAAvecparamListeparam(AAvecparamListeparam node) {
		// TODO Auto-generated method stub
		super.caseAAvecparamListeparam(node);
	}

	@Override
	public void caseAAvecsinonInstrsi(AAvecsinonInstrsi node) {
		// TODO Auto-generated method stub
		super.caseAAvecsinonInstrsi(node);
	}

	@Override
	public void caseADecvarentierDecvar(ADecvarentierDecvar node) {
		// TODO Auto-generated method stub
		super.caseADecvarentierDecvar(node);
	}

	@Override
	public void caseADecvarinstrDecfonc(ADecvarinstrDecfonc node) {
		// TODO Auto-generated method stub
		super.caseADecvarinstrDecfonc(node);
	}

	@Override
	public void caseADecvarldecfoncProgramme(ADecvarldecfoncProgramme node) {
		// TODO Auto-generated method stub
		super.caseADecvarldecfoncProgramme(node);
	}

	@Override
	public void caseADecvarldecvarListedecvar(ADecvarldecvarListedecvar node) {
		// TODO Auto-generated method stub
		super.caseADecvarldecvarListedecvar(node);
	}

	@Override
	public void caseADecvarldecvarListedecvarbis(ADecvarldecvarListedecvarbis node) {
		// TODO Auto-generated method stub
		super.caseADecvarldecvarListedecvarbis(node);
	}

	@Override
	public void caseADecvarListedecvar(ADecvarListedecvar node) {
		// TODO Auto-generated method stub
		super.caseADecvarListedecvar(node);
	}

	@Override
	public void caseADecvarListedecvarbis(ADecvarListedecvarbis node) {
		// TODO Auto-generated method stub
		super.caseADecvarListedecvarbis(node);
	}

	@Override
	public void caseADecvartableauDecvar(ADecvartableauDecvar node) {
		// TODO Auto-generated method stub
		super.caseADecvartableauDecvar(node);
	}

	@Override
	public void caseADiviseExp4(ADiviseExp4 node) {
		// TODO Auto-generated method stub
		super.caseADiviseExp4(node);
	}

	@Override
	public void caseAEgalExp2(AEgalExp2 node) {
		// TODO Auto-generated method stub
		super.caseAEgalExp2(node);
	}

	@Override
	public void caseAEtExp1(AEtExp1 node) {
		// TODO Auto-generated method stub
		super.caseAEtExp1(node);
	}

	@Override
	public void caseAExp1Exp(AExp1Exp node) {
		// TODO Auto-generated method stub
		super.caseAExp1Exp(node);
	}

	@Override
	public void caseAExp2Exp1(AExp2Exp1 node) {
		// TODO Auto-generated method stub
		super.caseAExp2Exp1(node);
	}

	@Override
	public void caseAExp3Exp2(AExp3Exp2 node) {
		// TODO Auto-generated method stub
		super.caseAExp3Exp2(node);
	}

	@Override
	public void caseAExp4Exp3(AExp4Exp3 node) {
		// TODO Auto-generated method stub
		super.caseAExp4Exp3(node);
	}

	@Override
	public void caseAExp5Exp4(AExp5Exp4 node) {
		// TODO Auto-generated method stub
		super.caseAExp5Exp4(node);
	}

	@Override
	public void caseAExp6Exp5(AExp6Exp5 node) {
		// TODO Auto-generated method stub
		super.caseAExp6Exp5(node);
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
		// TODO Auto-generated method stub
		super.caseAInstrtantqueInstr(node);
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

	@Override
	public void caseEOF(EOF node) {
		// TODO Auto-generated method stub
		super.caseEOF(node);
	}

	@Override
	public void caseInvalidToken(InvalidToken node) {
		// TODO Auto-generated method stub
		super.caseInvalidToken(node);
	}

	@Override
	public void caseStart(Start node) {
		// TODO Auto-generated method stub
		super.caseStart(node);
	}

	@Override
	public void caseTAccoladeFermante(TAccoladeFermante node) {
		// TODO Auto-generated method stub
		super.caseTAccoladeFermante(node);
	}

	@Override
	public void caseTAccoladeOuvrante(TAccoladeOuvrante node) {
		// TODO Auto-generated method stub
		super.caseTAccoladeOuvrante(node);
	}

	@Override
	public void caseTEspaces(TEspaces node) {
		// TODO Auto-generated method stub
		super.caseTEspaces(node);
	}

	@Override
	public void caseTCommentaire(TCommentaire node) {
		// TODO Auto-generated method stub
		super.caseTCommentaire(node);
	}

	@Override
	public void caseTVirgule(TVirgule node) {
		// TODO Auto-generated method stub
		super.caseTVirgule(node);
	}

	@Override
	public void caseTDivise(TDivise node) {
		// TODO Auto-generated method stub
		super.caseTDivise(node);
	}

	@Override
	public void caseTPointVirgule(TPointVirgule node) {
		// TODO Auto-generated method stub
		super.caseTPointVirgule(node);
	}

	@Override
	public void caseTFois(TFois node) {
		// TODO Auto-generated method stub
		super.caseTFois(node);
	}

	@Override
	public void caseTMoins(TMoins node) {
		// TODO Auto-generated method stub
		super.caseTMoins(node);
	}

	@Override
	public void caseTParentheseOuvrante(TParentheseOuvrante node) {
		// TODO Auto-generated method stub
		super.caseTParentheseOuvrante(node);
	}

	@Override
	public void caseTParentheseFermante(TParentheseFermante node) {
		// TODO Auto-generated method stub
		super.caseTParentheseFermante(node);
	}

	@Override
	public void caseTCrochetOuvrant(TCrochetOuvrant node) {
		// TODO Auto-generated method stub
		super.caseTCrochetOuvrant(node);
	}

	@Override
	public void caseTCrochetFermant(TCrochetFermant node) {
		// TODO Auto-generated method stub
		super.caseTCrochetFermant(node);
	}

	@Override
	public void caseTEgal(TEgal node) {
		// TODO Auto-generated method stub
		super.caseTEgal(node);
	}

	@Override
	public void caseTInferieur(TInferieur node) {
		// TODO Auto-generated method stub
		super.caseTInferieur(node);
	}

	@Override
	public void caseTEt(TEt node) {
		// TODO Auto-generated method stub
		super.caseTEt(node);
	}

	@Override
	public void caseTOu(TOu node) {
		// TODO Auto-generated method stub
		super.caseTOu(node);
	}

	@Override
	public void caseTNon(TNon node) {
		// TODO Auto-generated method stub
		super.caseTNon(node);
	}

	@Override
	public void caseTPlus(TPlus node) {
		// TODO Auto-generated method stub
		super.caseTPlus(node);
	}

	@Override
	public void caseTSi(TSi node) {
		// TODO Auto-generated method stub
		super.caseTSi(node);
	}

	@Override
	public void caseTAlors(TAlors node) {
		// TODO Auto-generated method stub
		super.caseTAlors(node);
	}

	@Override
	public void caseTSinon(TSinon node) {
		// TODO Auto-generated method stub
		super.caseTSinon(node);
	}

	@Override
	public void caseTTantque(TTantque node) {
		// TODO Auto-generated method stub
		super.caseTTantque(node);
	}

	@Override
	public void caseTFaire(TFaire node) {
		// TODO Auto-generated method stub
		super.caseTFaire(node);
	}

	@Override
	public void caseTEntier(TEntier node) {
		// TODO Auto-generated method stub
		super.caseTEntier(node);
	}

	@Override
	public void caseTRetour(TRetour node) {
		// TODO Auto-generated method stub
		super.caseTRetour(node);
	}

	@Override
	public void caseTLire(TLire node) {
		// TODO Auto-generated method stub
		super.caseTLire(node);
	}

	@Override
	public void caseTEcrire(TEcrire node) {
		// TODO Auto-generated method stub
		super.caseTEcrire(node);
	}

	@Override
	public void caseTNombre(TNombre node) {
		// TODO Auto-generated method stub
		super.caseTNombre(node);
	}

	@Override
	public void caseTIdentif(TIdentif node) {
		// TODO Auto-generated method stub
		super.caseTIdentif(node);
	}

	public SaNode getRoot() {
		return returnValue;
	}
}
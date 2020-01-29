/* This file was generated by SableCC (http://www.sablecc.org/). */

package analysis;

import java.util.*;
import node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    @Override
    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    @Override
    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    @Override
    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    @Override
    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    @Override
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADecvarldecfoncProgramme(ADecvarldecfoncProgramme node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALdecfoncProgramme(ALdecfoncProgramme node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAOptdecvar(AOptdecvar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADecvarldecvarListedecvar(ADecvarldecvarListedecvar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADecvarListedecvar(ADecvarListedecvar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADecvarldecvarListedecvarbis(ADecvarldecvarListedecvarbis node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADecvarListedecvarbis(ADecvarListedecvarbis node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADecvarentierDecvar(ADecvarentierDecvar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADecvartableauDecvar(ADecvartableauDecvar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALdecfoncrecListedecfonc(ALdecfoncrecListedecfonc node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALdecfoncfinalListedecfonc(ALdecfoncfinalListedecfonc node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADecvarinstrDecfonc(ADecvarinstrDecfonc node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstrDecfonc(AInstrDecfonc node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASansparamListeparam(ASansparamListeparam node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAvecparamListeparam(AAvecparamListeparam node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstraffectInstr(AInstraffectInstr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstrblocInstr(AInstrblocInstr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstrsiInstr(AInstrsiInstr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstrtantqueInstr(AInstrtantqueInstr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstrappelInstr(AInstrappelInstr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstrretourInstr(AInstrretourInstr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstrecritureInstr(AInstrecritureInstr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstrvideInstr(AInstrvideInstr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstraffect(AInstraffect node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstrbloc(AInstrbloc node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALinstrecListeinst(ALinstrecListeinst node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALinstfinalListeinst(ALinstfinalListeinst node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAvecsinonInstrsi(AAvecsinonInstrsi node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASanssinonInstrsi(ASanssinonInstrsi node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstrsinon(AInstrsinon node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstrtantque(AInstrtantque node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstrappel(AInstrappel node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstrretour(AInstrretour node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstrecriture(AInstrecriture node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstrvide(AInstrvide node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAOuExp(AOuExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExp1Exp(AExp1Exp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEtExp1(AEtExp1 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExp2Exp1(AExp2Exp1 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInfExp2(AInfExp2 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEgalExp2(AEgalExp2 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExp3Exp2(AExp3Exp2 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPlusExp3(APlusExp3 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMoinsExp3(AMoinsExp3 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExp4Exp3(AExp4Exp3 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFoisExp4(AFoisExp4 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADiviseExp4(ADiviseExp4 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExp5Exp4(AExp5Exp4 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANonExp5(ANonExp5 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExp6Exp5(AExp6Exp5 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANombreExp6(ANombreExp6 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAppelfctExp6(AAppelfctExp6 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVarExp6(AVarExp6 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAParenthesesExp6(AParenthesesExp6 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALireExp6(ALireExp6 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVartabVar(AVartabVar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVarsimpleVar(AVarsimpleVar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARecursifListeexp(ARecursifListeexp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFinalListeexp(AFinalListeexp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFinalListeexpbis(AFinalListeexpbis node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARecursifListeexpbis(ARecursifListeexpbis node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAvecparamAppelfct(AAvecparamAppelfct node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASansparamAppelfct(ASansparamAppelfct node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEspaces(TEspaces node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCommentaire(TCommentaire node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTVirgule(TVirgule node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDivise(TDivise node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPointVirgule(TPointVirgule node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFois(TFois node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMoins(TMoins node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTParentheseOuvrante(TParentheseOuvrante node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTParentheseFermante(TParentheseFermante node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCrochetOuvrant(TCrochetOuvrant node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCrochetFermant(TCrochetFermant node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAccoladeOuvrante(TAccoladeOuvrante node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAccoladeFermante(TAccoladeFermante node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEgal(TEgal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTInferieur(TInferieur node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEt(TEt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTOu(TOu node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNon(TNon node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPlus(TPlus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSi(TSi node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAlors(TAlors node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSinon(TSinon node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTantque(TTantque node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFaire(TFaire node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEntier(TEntier node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRetour(TRetour node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLire(TLire node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEcrire(TEcrire node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNombre(TNombre node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIdentif(TIdentif node)
    {
        defaultCase(node);
    }

    @Override
    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}

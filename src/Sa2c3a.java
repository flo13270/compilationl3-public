import c3a.*;
import sa.*;
import ts.Ts;
import ts.TsItemFct;
import ts.TsItemVar;

public class Sa2c3a extends SaDepthFirstVisitor<C3aOperand> {
	private final C3a c3a;
	private final Ts table;
	private Ts tableLocale;

	private TsItemFct getFonction(String identif) {
		TsItemFct fonction;
		if (tableLocale != null && (fonction = tableLocale.getFct(identif)) != null) {
			return fonction;
		}
		return table.getFct(identif);
	}

	private TsItemVar getVar(String identif) {
		TsItemVar fonction;
		if (tableLocale != null && (fonction = tableLocale.getVar(identif)) != null) {
			return fonction;
		}
		return table.getVar(identif);
	}

	public Sa2c3a(SaNode saRoot, Ts table) {
		c3a = new C3a();
		this.table = table;
		saRoot.accept(this);
	}

	public C3a getC3a() {
		return c3a;
	}

	@Override
	public C3aOperand visit(SaDecFonc node) {
		tableLocale = table.getTableLocale(node.getNom());
//		node.getVariable().accept(this);
		c3a.ajouteInst(new C3aInstFBegin(table.getFct(node.getNom()), "entree fonction"));
		super.visit(node);
		c3a.ajouteInst(new C3aInstFEnd(null));
		tableLocale = null;
		return null;
	}

	@Override
	public C3aOperand visit(SaExpInt node) {
		return new C3aConstant(node.getVal());
	}

	@Override
	public C3aOperand visit(SaExpVar node) {
		return node.getVar().accept(this);
	}

	@Override
	public C3aOperand visit(SaExp node) {
		return node.accept(this);
	}

	@Override
	public C3aOperand visit(SaInstEcriture node) {
		c3a.ajouteInst(new C3aInstWrite(node.getArg().accept(this), ""));
		return null;
	}

	@Override
	public C3aOperand visit(SaInstTantQue node) {
		C3aLabel testLabel = c3a.newAutoLabel();
        C3aLabel endLabel = c3a.newAutoLabel();

        c3a.addLabelToNextInst(testLabel);
        c3a.ajouteInst(new C3aInstJumpIfEqual(node.getTest().accept(this), c3a.False,endLabel,""));
        node.getFaire().accept(this);
        c3a.ajouteInst(new C3aInstJump(testLabel,""));
        c3a.addLabelToNextInst(endLabel);
        return null;
	}


	@Override
	public C3aOperand visit(SaLInst node) {
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaInstAffect node) {
		c3a.ajouteInst(new C3aInstAffect(node.getRhs().accept(this), node.getLhs().accept(this), ""));
		return null;
	}

	@Override
	public C3aOperand visit(SaVarSimple node) {
		return new C3aVar(getVar(node.getNom()), null);
	}

	@Override
	public C3aOperand visit(SaAppel node) {
		C3aTemp tmp = c3a.newTemp();
		SaLExp tail = node.getArguments();
		while(tail != null){
			c3a.ajouteInst(new C3aInstParam(tail.getTete().accept(this),""));
			tail = tail.getQueue();
		}
		c3a.ajouteInst(new C3aInstCall(new C3aFunction(table.getFct(node.getNom())),tmp,""));
		return tmp;
	}

	@Override
	public C3aOperand visit(SaExpAppel node) {
		return node.getVal().accept(this);
	}

	@Override
	public C3aOperand visit(SaExpAdd node) {
		C3aTemp tmp;
		c3a.ajouteInst(new C3aInstAdd(node.getOp1().accept(this), node.getOp2().accept(this), tmp = c3a.newTemp(), ""));
		return tmp;
	}

	@Override
	public C3aOperand visit(SaExpSub node) {
		C3aTemp tmp;
		c3a.ajouteInst(new C3aInstSub(node.getOp1().accept(this), node.getOp2().accept(this), tmp = c3a.newTemp(), ""));
		return tmp;
	}

	@Override
	public C3aOperand visit(SaExpMult node) {
		C3aTemp tmp;
		c3a.ajouteInst(new C3aInstMult(node.getOp1().accept(this), node.getOp2().accept(this), tmp = c3a.newTemp(), ""));
		return tmp;
	}

	@Override
	public C3aOperand visit(SaExpDiv node) {
		C3aTemp tmp;
		c3a.ajouteInst(new C3aInstDiv(node.getOp1().accept(this), node.getOp2().accept(this), tmp = c3a.newTemp(), ""));
		return tmp;
	}

	@Override
	public C3aOperand visit(SaExpInf node) {
		C3aLabel testValue;
		C3aTemp retour = c3a.newTemp();
		C3aOperand op1 = node.getOp1().accept(this);
		C3aOperand op2 = node.getOp2().accept(this);
		c3a.ajouteInst(new C3aInstAffect(c3a.True, retour , ""));
		c3a.ajouteInst(new C3aInstJumpIfLess(op1, op2, testValue = c3a.newAutoLabel(), ""));
		c3a.ajouteInst(new C3aInstAffect(c3a.False, retour, ""));
		c3a.addLabelToNextInst(testValue);
		return retour;
	}

	@Override
	public C3aOperand visit(SaExpEqual node) {
		//TODO "ici l'égalité est vérifiée à la compilation (et non à l'exécution), donc si on veut vérifier que
		// l'utilisateur entre le chiffre 3 par exemple, ça mettra toujours false je pense qu'il faut faire un
		// jump if equals avec un tmp qui prendra 1 ou 0 suivant si il va dans le jump (comme on a vu en TD)"
		return c3a.getConstant(node.getOp1().accept(this).equals(node.getOp2().accept(this)));
	}

	@Override
	public C3aOperand visit(SaExpAnd node) {
		C3aLabel non = c3a.newAutoLabel();
		C3aLabel oui = c3a.newAutoLabel();
		C3aTemp retour = c3a.newTemp();
		C3aOperand op1 = node.getOp1().accept(this);
		C3aOperand op2 = node.getOp2().accept(this);
		c3a.ajouteInst(new C3aInstJumpIfEqual(op1, c3a.False, oui, ""));
		c3a.ajouteInst(new C3aInstJumpIfEqual(op2, c3a.False, oui, ""));
		c3a.ajouteInst(new C3aInstAffect(c3a.True, retour, ""));
		c3a.ajouteInst(new C3aInstJump(non, ""));
		c3a.addLabelToNextInst(oui);
		c3a.ajouteInst(new C3aInstAffect(c3a.False, retour, ""));
		c3a.addLabelToNextInst(non);

		return retour;
	}

	@Override
	public C3aOperand visit(SaExpOr node) {
		C3aLabel non = c3a.newAutoLabel();
		C3aLabel oui = c3a.newAutoLabel();
		C3aTemp retour = c3a.newTemp();

		c3a.ajouteInst(new C3aInstJumpIfNotEqual(node.getOp1().accept(this), c3a.False, oui, ""));
		c3a.ajouteInst(new C3aInstJumpIfNotEqual(node.getOp2().accept(this), c3a.False, oui, ""));
		c3a.ajouteInst(new C3aInstAffect(c3a.False, retour, ""));
		c3a.ajouteInst(new C3aInstJump(non, ""));
		c3a.addLabelToNextInst(oui);
		c3a.ajouteInst(new C3aInstAffect(c3a.True, retour, ""));
		c3a.addLabelToNextInst(non);

		return retour;
	}

	@Override
	public C3aOperand visit(SaExpNot node) {
		return c3a.getConstant(!c3a.getBool(node.getOp1().accept(this)));
	}

	@Override
	public C3aOperand visit(SaExpLire node) {
		var tmp = c3a.newTemp();
		c3a.ajouteInst(new C3aInstRead(tmp, ""));
		return tmp;
	}

	@Override
	public C3aOperand visit(SaInstBloc node) {
		return super.visit(node);
	}

	// si c'est moche c'et par ce que Renaud ne veut qu'on perde du temps pour
	// réusiner le code
	@Override
	public C3aOperand visit(SaInstSi node) {
		C3aLabel sinon = c3a.newAutoLabel();
		C3aLabel fin = c3a.newAutoLabel();

		SaInst instSinon = node.getSinon();
		if (instSinon == null) {
			c3a.ajouteInst(new C3aInstJumpIfEqual(node.getTest().accept(this), c3a.False, fin, ""));
			node.getAlors().accept(this);
		} else {
			c3a.ajouteInst(new C3aInstJumpIfEqual(node.getTest().accept(this), c3a.False, sinon, ""));
			node.getAlors().accept(this);
			c3a.ajouteInst(new C3aInstJump(fin, ""));
			c3a.addLabelToNextInst(sinon);
			instSinon.accept(this);
		}

		c3a.addLabelToNextInst(fin);
		return null;
	}

	@Override
	public C3aOperand visit(SaInstRetour node) {
		c3a.ajouteInst(new C3aInstReturn(node.getVal().accept(this),""));
		return null;
	}

	@Override
	public C3aOperand visit(SaLExp node) {
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaVarIndicee node) {
		return new C3aVar(getVar(node.getNom()), node.getIndice().accept(this));
	}
}
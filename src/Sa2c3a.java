import c3a.*;
import sa.*;
import ts.Ts;

public class Sa2c3a extends SaDepthFirstVisitor<C3aOperand> {

	private final C3a c3a;
	private final Ts table;

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
		c3a.ajouteInst(new C3aInstFBegin(table.getFct(node.getNom()), "entree fonction"));
		C3aOperand tmp = super.visit(node);
		c3a.ajouteInst(new C3aInstFEnd(null));
		return tmp;
	}

	@Override
	public C3aOperand visit(SaExp node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaExpInt node) {
		return new C3aConstant(node.getVal());
	}

	@Override
	public C3aOperand visit(SaExpVar node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaInstEcriture node) {
		c3a.ajouteInst(new C3aInstWrite(node.getArg().accept(this), ""));
		return null;
	}

	@Override
	public C3aOperand visit(SaInstTantQue node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaLInst node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaInstAffect node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaVarSimple node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaAppel node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaExpAppel node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaExpAdd node) {
		C3aTemp tmp = c3a.newTemp();
		c3a.ajouteInst(new C3aInstAdd(node.getOp1().accept(this), node.getOp2().accept(this), tmp, ""));
		return tmp;
	}

	@Override
	public C3aOperand visit(SaExpSub node) {
		C3aTemp tmp = c3a.newTemp();
		c3a.ajouteInst(new C3aInstSub(node.getOp1().accept(this), node.getOp2().accept(this), tmp, ""));
		return tmp;
	}

	@Override
	public C3aOperand visit(SaExpMult node) {
		C3aTemp tmp = c3a.newTemp();
		c3a.ajouteInst(new C3aInstMult(node.getOp1().accept(this), node.getOp2().accept(this), tmp, ""));
		return tmp;
	}

	@Override
	public C3aOperand visit(SaExpDiv node) {
		C3aTemp tmp = c3a.newTemp();
		c3a.ajouteInst(new C3aInstDiv(node.getOp1().accept(this), node.getOp2().accept(this), tmp, ""));
		return tmp;
	}

	@Override
	public C3aOperand visit(SaExpInf node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaExpEqual node) {
		return c3a.getConstant(node.getOp1().accept(this).equals(node.getOp2().accept(this)));
	}

	@Override
	public C3aOperand visit(SaExpAnd node) {
		return c3a.getConstant(c3a.getBool(node.getOp1().accept(this)) && c3a.getBool(node.getOp2().accept(this)));
	}

	@Override
	public C3aOperand visit(SaExpOr node) {
		// TODO Auto-generated method stub
		return super.visit(node);
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
		// TODO Auto-generated method stub
		return super.visit(node);
	}

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
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaLExp node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaVarIndicee node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}
}
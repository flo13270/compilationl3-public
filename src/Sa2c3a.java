import c3a.*;
import sa.*;
import ts.Ts;

public class Sa2c3a extends SaDepthFirstVisitor<C3aOperand>{

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
	public C3aOperand visit(SaProg node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}
	
	@Override
	public C3aOperand visit(SaExp node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaExpInt node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaExpVar node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaInstEcriture node) {
		// TODO Auto-generated method stub
		return super.visit(node);
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
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaExpSub node) {
		C3aTemp tmp = c3a.newTemp();
		c3a.ajouteInst(new C3aInstSub(node.getOp1().accept(this), node.getOp2().accept(this), tmp, null));
		return tmp;
	}

	@Override
	public C3aOperand visit(SaExpMult node) {
		
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaExpDiv node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaExpInf node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaExpEqual node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaExpAnd node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaExpOr node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaExpNot node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaExpLire node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaInstBloc node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public C3aOperand visit(SaInstSi node) {
		// TODO Auto-generated method stub
		return super.visit(node);
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
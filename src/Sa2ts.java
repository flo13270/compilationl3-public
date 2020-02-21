import sa.SaAppel;
import sa.SaDecFonc;
import sa.SaDecTab;
import sa.SaDecVar;
import sa.SaDepthFirstVisitor;
import sa.SaInstRetour;
import sa.SaNode;
import sa.SaVarIndicee;
import sa.SaVarSimple;
import ts.Ts;

public class Sa2ts extends SaDepthFirstVisitor<Void>{
	
	public Sa2ts(SaNode saRoot) {
		// TODO Auto-generated constructor stub
	}

	public Ts getTableGlobale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(SaDecTab node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public Void visit(SaDecFonc node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public Void visit(SaDecVar node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public Void visit(SaVarSimple node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public Void visit(SaAppel node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public Void visit(SaInstRetour node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}

	@Override
	public Void visit(SaVarIndicee node) {
		// TODO Auto-generated method stub
		return super.visit(node);
	}
}
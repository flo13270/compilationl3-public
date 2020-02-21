import sa.SaAppel;
import sa.SaDecFonc;
import sa.SaDecTab;
import sa.SaDecVar;
import sa.SaDepthFirstVisitor;
import sa.SaNode;
import sa.SaVarIndicee;
import sa.SaVarSimple;
import ts.Ts;

public class Sa2ts extends SaDepthFirstVisitor<Void> {

	private final Ts tableGlobale;
	private Ts tableLocale;

	public Sa2ts(SaNode saRoot) {
		tableGlobale = new Ts();
		saRoot.accept(this);
	}

	public Ts getTableGlobale() {
		return tableGlobale;
	}
	
	// TODO vérifier qu'on ne définisse pas une variable par dessus un argument

	@Override
	public Void visit(SaDecTab node) {
		String identif = node.getNom();
		if (tableLocale != null) {
			throw new RuntimeException("On ne peut pas déclarer un tableau dans une fonction");
		}
		if (tableGlobale.containsVar(identif)) {
			throw new RuntimeException("Le tableau " + identif + " a déjà été défini");
		}
		return super.visit(node);
	}

	@Override
	public Void visit(SaDecFonc node) {
		String identif = node.getNom();
		tableLocale = new Ts();
		if (tableGlobale.containsFonc(identif)) {
			throw new RuntimeException("La fontion " + identif + " a déjà été définie");
		}
		tableGlobale.addFct(node.getNom(), node.getParametres() == null ? 0 : node.getParametres().length(), tableLocale, node);
		super.visit(node);

		tableLocale = null;

		return null;
	}

	@Override
	public Void visit(SaDecVar node) {
		String identif = node.getNom();
		Ts table = tableLocale == null ? tableGlobale : tableLocale;
		if (table.containsVar(identif)) {
			throw new RuntimeException("La variable " + identif + " a déjà été définie");
		}
		table.addVar(node.getNom(), 1);
		return super.visit(node);
	}

	@Override
	public Void visit(SaVarSimple node) {
		String identif = node.getNom();
		if (!(tableLocale != null && tableLocale.containsVar(identif))) {
			if (!tableGlobale.containsFonc(identif)) {
				throw new RuntimeException("La variable simple " + node.getNom() + "n'a pas été définie");
			}
		}
		return super.visit(node);
	}

	@Override
	public Void visit(SaAppel node) {
		if (!tableGlobale.containsFonc(node.getNom())) {
			throw new RuntimeException("La fonction simple " + node.getNom() + "n'a pas été définie");
		}
		return super.visit(node);
	}

	@Override
	public Void visit(SaVarIndicee node) {
		if (!tableGlobale.containsVar(node.getNom())) {
			throw new RuntimeException("La variable indicee " + node.getNom() + "n'a pas été définie");
		}
		return super.visit(node);
	}
}
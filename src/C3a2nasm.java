import c3a.*;
import nasm.Nasm;
import ts.Ts;

//TODO remplacer le T par une nasmOperand i guess ?
public class C3a2nasm<T> implements C3aVisitor<T>{

	public C3a2nasm(C3a c3a, Ts table) {
		// TODO Auto-generated constructor stub
	}

	public Nasm getNasm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visit(C3aInstAdd inst) {
		return null;
	}

	@Override
	public T visit(C3aInstCall inst) {
		return null;
	}

	@Override
	public T visit(C3aInstFBegin inst) {
		return null;
	}

	@Override
	public T visit(C3aInst inst) {
		return null;
	}

	@Override
	public T visit(C3aInstJumpIfLess inst) {
		return null;
	}

	@Override
	public T visit(C3aInstMult inst) {
		return null;
	}

	@Override
	public T visit(C3aInstRead inst) {
		return null;
	}

	@Override
	public T visit(C3aInstSub inst) {
		return null;
	}

	@Override
	public T visit(C3aInstAffect inst) {
		return null;
	}

	@Override
	public T visit(C3aInstDiv inst) {
		return null;
	}

	@Override
	public T visit(C3aInstFEnd inst) {
		return null;
	}

	@Override
	public T visit(C3aInstJumpIfEqual inst) {
		return null;
	}

	@Override
	public T visit(C3aInstJumpIfNotEqual inst) {
		return null;
	}

	@Override
	public T visit(C3aInstJump inst) {
		return null;
	}

	@Override
	public T visit(C3aInstParam inst) {
		return null;
	}

	@Override
	public T visit(C3aInstReturn inst) {
		return null;
	}

	@Override
	public T visit(C3aInstWrite inst) {
		return null;
	}

	@Override
	public T visit(C3aConstant oper) {
		return null;
	}

	@Override
	public T visit(C3aLabel oper) {
		return null;
	}

	@Override
	public T visit(C3aTemp oper) {
		return null;
	}

	@Override
	public T visit(C3aVar oper) {
		return null;
	}

	@Override
	public T visit(C3aFunction oper) {
		return null;
	}
}

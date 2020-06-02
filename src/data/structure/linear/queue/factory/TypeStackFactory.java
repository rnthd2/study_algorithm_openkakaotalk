package data.structure.linear.factory;

/**
 * 문제에 따른 stack 생성
 * 팩토리 메서드로 생성해본다.
 */
public class TypeStackFactory extends StackFactory {

	@Override
	public Stack createStack(Class<? extends Stack> type) {
		Stack stack = null;
		if (type.equals(StackTypeA.class)) {
			stack = new StackTypeA();
		}
		return stack;
	}
}

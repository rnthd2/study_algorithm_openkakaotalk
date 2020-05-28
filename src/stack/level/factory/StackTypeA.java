package stack.level.factory;

import java.util.ArrayList;

public class StackTypeA extends Stack<ArrayList<Integer>> implements StackMode {

	private static ArrayList stack;
	private static int pointer;

	public StackTypeA() {
		this.stack = new ArrayList<>();
		this.pointer = -1;
	}

	@Override
	public ArrayList getStack() {
		return stack;
	}

	@Override
	public int getPointer() {
		return pointer;
	}

	public void setOrderSize(int stackSize) {
		this.stack = new ArrayList<>(stackSize);
	}

	public void setPointer(int pointer) {
		StackTypeA.pointer = pointer;
	}

	// push X: 정수 X를 스택에 넣는 연산이다.
	@Override
	public void push(Object x) {
		this.stack.add(x);
		setPointer(++pointer);
	}

	//pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	@Override
	public void pop() {
		stack.remove(pointer--);
	}

	//size: 스택에 들어있는 정수의 개수를 출력한다.
	@Override
	public int size() {
		return stack.size();
	}

	//empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
	@Override
	public Object empty() {
		return stack.isEmpty() ? 1 : 0;
	}

	//top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	@Override
	public Object top() {
		return stack.size() < 1 ? -1 : stack.get(pointer);
	}
}

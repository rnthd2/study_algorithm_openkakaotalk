package data.structure.linear.factory;

public interface StackMode {
	void push(Object x);

	void pop();

	int size();

	Object empty();

	Object top();
}

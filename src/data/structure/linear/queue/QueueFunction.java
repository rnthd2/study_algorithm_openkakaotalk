package data.structure.linear.queue;

public interface QueueFunction<T> {
	void push(T x);

	void pop();

	int size();

	Object empty();

	Object front();

	Object back();
}

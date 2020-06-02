package data.structure.linear;

public class BasicQueueFunction extends Queue implements QueueFunction {

	public BasicQueueFunction() {
		super(new Builder());
	}

	public BasicQueueFunction(int size) {
		super(new Builder(size));
	}

	@Override
	//* push X: 정수 X를 큐에 넣는 연산이다.
	public void push(Object x) {
		queue.add(x);
		rearPointer++;
	}

	@Override
	//* pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public void pop() {
		queue.remove(0);
		rearPointer--;
	}

	@Override
	//* size: 큐에 들어있는 정수의 개수를 출력한다.
	public int size() {
		return queue.size();
	}

	@Override
	//* empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
	public Object empty() {
		return queue.isEmpty() ? 1 : 0;
	}

	@Override
	//* front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public Object front() {
		return queue.size() < 1 ? -1 : queue.get(0);
	}

	@Override
	//* back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public Object back() {
		return queue.size() < 1 ? -1 : queue.get(rearPointer);
	}

}

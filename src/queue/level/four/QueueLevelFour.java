package queue.level.four;

import java.util.ArrayList;

public class QueueLevelFour {
	ArrayList<Integer> tempQueue;
	ArrayList<Integer> queue;
	int queuePoint;

	public static void main(String[] args) {
		QueueLevelFour stack = new QueueLevelFour();

		stack.push(1);
		stack.push(2);
		System.out.println(stack.top());   // returns 2
		System.out.println(stack.pop());   // returns 2
		System.out.println(stack.empty()); // returns false
	}

	/** Initialize your data structure here. */
	public QueueLevelFour() {
		tempQueue = new ArrayList();
		queue = new ArrayList();
		queuePoint = -1;
	}

	//todo 마무리 지어야함
	/** Push element x onto stack. */
	public void push(int x) {
		tempQueue.add(x);
		queuePoint++;
		for (int i = 0; i < tempQueue.size(); i++) {
			queue.add(tempQueue.get(queuePoint--));
		}
		queuePoint = tempQueue.size()-1;
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return queue.remove(queuePoint);
	}

	/** Get the top element. */
	public int top() {
		return queue.get(queuePoint);
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queue.isEmpty();
	}
}

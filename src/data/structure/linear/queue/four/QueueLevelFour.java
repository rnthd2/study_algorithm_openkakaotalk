package data.structure.linear.queue.four;

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
		System.out.println(stack.pop());   // returns 1
		System.out.println(stack.empty()); // returns false
	}

	/** Initialize your data structure here. */
	public QueueLevelFour() {
		tempQueue = new ArrayList();
		queue = new ArrayList();
		queuePoint = -1;
	}

	/** Push element x onto stack. */
	public void push(int x) {
		tempQueue.add(x);
		queuePoint++;
		queue = new ArrayList<>(tempQueue.size());
		for (int i = 0; i < tempQueue.size(); i++) {
			queue.add(tempQueue.get(queuePoint--));
		}
		queuePoint = tempQueue.size()-1;
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		queuePoint--;
		//Shifts any subsequent elements to the left
		return queue.remove(0);
	}

	/** Get the top element. */
	public int top() {
		return queue.get(0);
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queue.isEmpty();
	}
}

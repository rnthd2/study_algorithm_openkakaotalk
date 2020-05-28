package queue.level.three;

import java.util.ArrayList;

public class QueueLevelThree {

	ArrayList<Integer> tempStack;
	int stackPoint = -1;

	ArrayList<Integer> stack;

	public static void main(String[] args) {
		QueueLevelThree queue = new QueueLevelThree();

		queue.push(1);
		queue.push(2);
		System.out.println(queue.peek());  // returns 1
		System.out.println(queue.pop());   // returns 1
		System.out.println(queue.empty()); // returns false
	}

	/**
	 * Initialize your data structure here.
	 */
	public QueueLevelThree() {
		tempStack = new ArrayList();
		stack = new ArrayList();
	}

	/**
	 * Push element x to the back of queue.
	 */
	public void push(int x) {
		tempStack.add(x);
		++stackPoint;
		stack = new ArrayList<>(tempStack.size());
		for (int i = 0; i < tempStack.size(); i++) {
			stack.add(tempStack.get(stackPoint--));
		}
		stackPoint = tempStack.size()-1;
	}

	/**
	 * Removes the element from in front of queue and returns that element.
	 */
	public int pop() {
		return stack.remove(stackPoint);
	}

	/**
	 * Get the front element.
	 */
	public int peek() {
		return stack.get(stackPoint);
	}

	/**
	 * Returns whether the queue is empty.
	 */
	public boolean empty() {
		return stack.isEmpty();
	}
}

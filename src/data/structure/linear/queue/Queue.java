package data.structure.linear;

import java.util.ArrayList;

/*
규칙 2. 생성자 인자가 많을 때는 Builder 패턴 적용을 고려하라 (2판)
아이템 2. 생성자에 매개변수가 많다면 빌더를 고려하라 (3판)
 */
public class Queue {

	protected ArrayList queue;
	protected int frontPointer;
	protected int rearPointer;

	//빌더패턴
	public static class Builder {
		//필수 인자
		private final ArrayList queue;

		//선택적 인자
		private int frontPointer = -1;
		private int rearPointer = -1;

		public Builder() {
			this.queue = new ArrayList();
		}

		public Builder(int size) {
			this.queue = new ArrayList(size);
		}

		public Builder frontPointer(int frontPointer) {
			this.frontPointer = frontPointer;
			return this;
		}

		public Builder rearPointer(int rearPointer) {
			this.rearPointer = rearPointer;
			return this;
		}

		public Queue build() {
			return new Queue(this);
		}
	}

	public Queue(Builder builder) {
		queue = builder.queue;
		frontPointer = builder.frontPointer;
		rearPointer = builder.rearPointer;
	}

	//점층적 생성자 패턴 코드
	/*public Queue() {
	}

	public Queue(ArrayList queue) {
	}

	public Queue(int fointPointer, int rearPointer) {
	}

	public Queue(int frontPointer, int rearPointer) {
	}

	public Queue(ArrayList queue, int frontPointer, int rearPointer) {
	}*/

	//자바빈 패턴
	/*
	public void setFrontPointer(int frontPointer) {
		this.frontPointer = frontPointer;
	}

	public void setRearPointer(int rearPointer) {
		this.rearPointer = rearPointer;
	}
	*/
	//cc. https://johngrib.github.io/wiki/builder-pattern/

}


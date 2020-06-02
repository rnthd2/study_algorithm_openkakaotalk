package data.structure.linear.queue.factory;

/**
 * 언바운드 와일드카드 타입(Unbounded wildcard type)
 * <p>
 * List<?>와 같은 타입을 언바운드 와일드카드 타입이라고 한다. 우선 Unbounded라는 단어를 알면 이해하는 데 도움이 된다.
 * Unbounded : 한이 없는, 무한한
 * 대충 해석해보면 어떤 타입이 오든 관계가 없다는 것이다.
 */
public abstract class StackFactory {
	public abstract Stack createStack(Class<? extends Stack> type);
}

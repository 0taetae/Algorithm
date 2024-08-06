package p0806;

public interface IStack<E> {
	
	void push(E e);
	E pop();
	E peeek();
	boolean isEmpty();
	int size();
	
}

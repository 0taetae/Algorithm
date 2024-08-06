package p0806;

import java.util.EmptyStackException;

public class LinkedStack<E> implements IStack<E> {
	
	private Node<E> top;  // top은 마지막 노드를 나타냄(head로 사용) 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void push(E e) {  // 첫 노드로 삽입
		top = new Node<>(e,top);
		
	}

	@Override
	public E pop() {  // 첫 노드 삭제
		if(isEmpty()) throw new EmptyStackException();
		Node<E> node = top;
		top = node.link;  // 삭제된 노드의 링크를 top에 
		node.link = null;
		
		return node.data;
	}

	@Override
	public E peeek() {
		if(isEmpty()) throw new EmptyStackException();
		return top.data;
	}

	@Override
	public boolean isEmpty() {

		return top==null;
	}

	@Override
	public int size() {  // 연결리스트 전체 탐색하는 버전
		int size=0;
		for(Node<E> temp = top; temp !=null; temp = temp.link) {
			size++;
		}
		
		return size;
	}

}

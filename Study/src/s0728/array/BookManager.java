package s0728.array;

import java.util.Arrays;

public class BookManager {
	private int MAX_SIZE=100;
	private Book[] books = new Book[MAX_SIZE];  // 배열 타입
	private int size;
	
	public void add(Book book) {
		if(size<MAX_SIZE) {
			books[size++]=book;  // MAX_SIZE를 넘지 않으면 배열인 books에 book을 넣음
		}
		
	}
	
	public void remove(String isbn) {
		System.out.println("*****도서삭제:"+isbn+"*****");
		for(int i=0;i<size;i++) {
			if(books[i].getIsbn().equals(isbn)) { // isbn이 일치한 도서 찾기
				books[i] = books[size-1];  // 해당 도서 위치에 배열의 제일 마지막 도서를 복사 -> 삭제하면 생기는 빈공간 채우기 
				books[size-1] = null;  // 해당 도서 null 처리
				size--;  // 등록된 도서 수 감소
				break;
			}
		}	
		
	}
	
	public Book[] getList() {
		System.out.println("*****도서목록*****");
		return Arrays.copyOfRange(books, 0, size);  // 배열 복사
		
	}
	
	public Book searchByIsbn(String isbn) {
		System.out.println("*****도서조회:"+isbn+"*****");
		for(int i=0;i<size;i++) {
			if(books[i].getIsbn().equals(isbn))
				return books[i];
		}
		
		return null;
		
	}
}

package s0728.array2;

import java.util.Arrays;

public class BookManager {
	private static int MAX_SIZE=100;
	private Book[] books;
	private int size;
	
	public void add(Book book) {
		if(size<MAX_SIZE) books[size++] = book;
	}
	public void remove(String isbn) {
		for(int i=0;i<size;i++) {
			if(books[i].getIsbn().equals(isbn)) {
				books[i]=books[size-1];
				books[size-1]=null;
				size--;
				break;
			}
		}
	}
	public Book[] getList() {
		return Arrays.copyOfRange(books, 0, size);
	}
	public Book searchByIsbn(String isbn) {
		for(int i=0;i<size;i++) {
			if(books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}

}

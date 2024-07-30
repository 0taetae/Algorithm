package s0728.inheritance;

import java.util.Arrays;

public class BookManager {
	private int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size;
	
	public void add(Book book) {
		if(size<MAX_SIZE) {
			books[size++]=book;
		}
	}
	
	public void remove(String isbn) {
		for(int i=0;i<size;i++) {
			if(books[i].getIsbn().equals(isbn)) {
				books[i] = books[size-1];
				books[size-1] = null;
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
	public Book[] searchByTitle(String title) {
		int count=0;
		for(int i=0;i<size;i++) {  // 도서 제목을 포함하는 도서의 개수 카운트 
			if(books[i].getTitle().contains(title)) ++count;
		}
		Book[] result = new Book[count];  // 해당 도서의 개수 만큼 배열 생성 
		int idx=0;
		for(int i=0;i<size;i++) {
			if(books[i].getTitle().contains(title)) {  // 도서 제목을 포함하는 도서만 배열에 넣기 
				result[idx++]=books[i];
			}
		}
		
		return result;
	}
	
	public Magazine[] getMagazines() {
		int count = 0;
		for(int i=0;i<size;i++) {
			if(books[i] instanceof Magazine) ++count;  // Magazine타입이면 count증가
		}
		int idx=0;
		Magazine[] result = new Magazine[count];
		for(int i=0;i<size;i++) {
			if(books[i] instanceof Magazine) {
				result[idx] = (Magazine)books[i];
			}
		}
		return result;
		
	}
	public Book[] getBooks() {
		int count =0;
		for(int i=0;i<size;i++) {
			if(!(books[i] instanceof Magazine)) ++count;
		}
		int idx=0;
		Book[] result = new Book[count];
		for(int i=0;i<size;i++) {
			if(!(books[i] instanceof Magazine)) {
				result[idx++] = books[i];
			}
		}
		return result;
	}
	public int getTotalPrice() {
		int total=0;
		for(int i=0;i<size;i++) {
			total+=books[i].getPrice();
		}
		return total;
	}
	public double getPriceAvg() {
		return (double)getTotalPrice()/size;
	}
	
}

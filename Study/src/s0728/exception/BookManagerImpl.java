package s0728.exception;

import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements IBookManager {
	private List<Book> books = new ArrayList<Book>();
	private static IBookManager instance = new BookManagerImpl();
	
	private BookManagerImpl() {
		
	}
	public static IBookManager getInstance() {
		return instance;
	}
	public void add(Book book) {
		books.add(book);
	}
	public void remove(String isbn) {
		int size = books.size();
		for(int i=0;i<size;i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
				books.remove(i);
				break;
			}
		}
	}
	public Book[] getList() {
		Book[] result = new Book[books.size()];
		return books.toArray(result);
	}
	public Book searchByIsbn(String isbn) {
		for(Book book:books) {
			if(book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		return null;
	}
	public Book[] searchByTitle(String title) {
		ArrayList<Book> temp = new ArrayList<Book>();
		for(Book book:books) {
			if(book.getTitle().contains(title)) {
				temp.add(book);
			}
		}
		Book[] result = new Book[temp.size()];
		return temp.toArray(result);
	}
	public Magazine[] getMagazines() {
		ArrayList<Magazine> temp = new ArrayList<Magazine>();
		for(Book book:books) {
			if(book instanceof Magazine) {
				temp.add((Magazine)book);
			}
		}
		Magazine[] result = new Magazine[temp.size()];
		return temp.toArray(result);
	}
	public Book[] getBooks() {
		ArrayList<Book> temp = new ArrayList<Book>();
		for(Book book:books) {
			if(!(book instanceof Magazine)) {
				temp.add(book);
			}
		}
		Book[] result = new Book[temp.size()];
		return temp.toArray(result);
	}
	public int getTotalPrice() {
		int total=0;
		for(Book book:books) {
			total+=book.getPrice();
		}
		return total;
	}
	public double getPriceAvg() {
		return (double)getTotalPrice()/books.size();
	}
	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException{
		Book book = searchByIsbn(isbn);
		if(book == null) {
			throw new ISBNNotFoundException(isbn);
		}
		
		int q = book.getQuantity() - quantity;
		if(q<0) {
			throw new QuantityException();
		}
		book.setQuantity(q);
	}
	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException{
		Book book = searchByIsbn(isbn);
		if(book == null) {
			throw new ISBNNotFoundException(isbn);
		}
		book.setQuantity(book.getQuantity()+quantity);
	}
}

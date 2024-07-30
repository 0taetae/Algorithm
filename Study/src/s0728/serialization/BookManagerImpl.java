package s0728.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements IBookManager{
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
		int total =0;
		for(Book book:books) {
			total+=book.getPrice();
		}
		return total;
	}
	public double getPriceAvg() {
		return (double)getTotalPrice()/books.size();
	}
	public void sell(String isbn, int quantity) throws ISBNNotFoundException,QuantityException {
		Book book = searchByIsbn(isbn);
		if(book==null) {
			throw new ISBNNotFoundException(isbn);
		}
		int q = book.getQuantity()-quantity;
		if(q<0) {
			throw new QuantityException();
		}
		book.setQuantity(q);
	}
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		Book book = searchByIsbn(isbn);
		if(book==null) {
			throw new ISBNNotFoundException(isbn);
		}
		book.setQuantity(book.getQuantity()+quantity);
	}
	private void loadData()  {
		File f = new File("book.dat");
		if(f.exists()) {
			try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))){
				books = (ArrayList<Book>) in.readObject();
			}catch (Exception e) {
				System.out.println("파일 읽기에 실패");
				e.printStackTrace();
			}
		}else {
			books = new ArrayList<Book>();
		}
	}
	public void saveData() {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("book.dat"))){
			out.writeObject(books);
		}catch(Exception e) {
			System.out.println("파일 쓰기 실패");
			e.printStackTrace();
		}
	}

}

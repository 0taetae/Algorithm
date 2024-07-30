package s0728.object;

public class Book {
	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc;
	
	
	public Book() {
		//super();
	}

	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		//super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return isbn+"\t|"+title+"\t|"+author+"\t|"+publisher+"\t|"+price+"\t|"+desc;
	}

	

}

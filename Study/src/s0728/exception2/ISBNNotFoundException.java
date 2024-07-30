package s0728.exception2;

public class ISBNNotFoundException extends Exception{
	private String isbn;
	public ISBNNotFoundException(String isbn) {
		super(isbn+"없음");
		this.isbn=isbn;
		
	}
	public String getIsbn() {
		return isbn;
	}

}

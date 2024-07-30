package s0728.exception;

public class ISBNNotFoundException extends Exception{
	private String isbn;
	public ISBNNotFoundException(String isbn) {
		super(isbn+"고유번호는 존재하지 않습니다");
		this.isbn = isbn;
	}
	public String getIsbn() {
		return isbn;
	}

}

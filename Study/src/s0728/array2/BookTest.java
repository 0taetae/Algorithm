package s0728.array2;


public class BookTest {

	public static void main(String[] args) {
		BookManager bm = new BookManager();
		
		bm.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
		bm.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
		bm.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링"));
		
		for(Book book:bm.getList()) {
			System.out.println(book);
		}
		System.out.println(bm.searchByIsbn("21424"));

	}

}

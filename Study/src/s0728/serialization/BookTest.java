package s0728.serialization;


public class BookTest {

	public static void main(String[] args) {
		IBookManager bookManager = BookManagerImpl.getInstance();
		
		System.out.println("***불러온 도서 전체 목록***");
		Book[] books = bookManager.getList();
		if(books==null || books.length==0) {
			System.out.println("등록된 도서 없음");
		}else {
			for(Book b:books) {
				System.out.println(b);
			}
		}
		bookManager.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법",10));
		bookManager.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용",20));
		bookManager.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링",30));
		bookManager.add(new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1,40));

		bookManager.saveData();

	}

}

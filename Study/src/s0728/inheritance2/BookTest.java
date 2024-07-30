package s0728.inheritance2;


public class BookTest {

	public static void main(String[] args) {
		BookManager bm = new BookManager();
		
		Book book1 = new Book("21424","Java Pro","김하나","jaen.kr",15000,"Java 기본 문법"); 
		Book book2 = new Book("21425","Java Pro2","김하나","jaen.kr",25000,"Java 응용"); 
		Book book3 = new Book("35355","분석설계","소나무","jaen.kr",30000,"SW 모델링");
		Magazine magazine = new Magazine("45678","월간 알고리즘","홍길동","jaen.kr",10000,"1월 알고리즘",2021,1);
		
		bm.add(book1);
		bm.add(book2);
		bm.add(book3);
		bm.add(magazine);
		
		System.out.println("*****도서 전체 목록*****");
		for(Book book:bm.getList()) {
			System.out.println(book);
		}
		
		System.out.println("*****일반 도서 목록*****");
		for(Book book:bm.getBooks()) {
			System.out.println(book);
		}
		
		System.out.println("*****잡지 목록*****");
		for(Magazine m:bm.getMagazines()) {
			System.out.println(m);
		}
		
		System.out.println("*****도서 제목 포함 검색:Java");
		for(Book book:bm.searchByTitle("Java")) {
			System.out.println(book);
		}
		System.out.println(bm.getTotalPrice());
		System.out.println(bm.getPriceAvg());
	}

}

package ch07;

public class Book {
	private String bookName;
	private String author;
	private String press;
	private int year;
	private int price;
	private int amount;
	private int money;
//	public void input(String bookName, String author, String press, int year, int price, int amount) {
//		this.bookName = bookName;
//		this.author = author;
//		this.press = press;
//		this.year = year;
//		this.price = price;
//		this.amount = amount;
//		money = price*amount; //금액 계산
//		
//	}
	public Book(){
		this("자바","김철수","한빛",2016,20000,10);
		// this() 다른 생성자를 호출함
		// 생성자는 첫라인에 작성해야 함
		System.out.println("기본 생성자 호출");
	} //기본 생성자
	//매개변수가 있는 생성자
	public Book(String bookName, String author, String press, int year, int price, int amount) {
		System.out.println("매개변수가 있는 생성자 호출");
		this.bookName = bookName;
		this.author = author;
		this.press = press;
		this.year = year;
		this.price = price;
		this.amount = amount;
		money = price*amount; //금액 계산
	}
	
	public void print(){
		System.out.println("도서명\t저자\t출판사\t출판연도\t가격\t판매수량\t판매금액");
		System.out.println(bookName+"\t"+author+"\t"+press+"\t"+year+"\t"+price+"\t"
				+amount+"\t"+money);
	}
}

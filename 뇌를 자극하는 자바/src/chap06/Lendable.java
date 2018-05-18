package chap06;

public interface Lendable {
	
	//상수 필드
	final static byte STATE_BORROWED = 1; //대출중
	             byte STATE_NOMAL = 0; // 대출되지 않은 상태
	             
	
	//추상메소드
	abstract void checkOut(String borrower, String date) throws Exception; //대출하는 기능
	void checkIn();   //반납하는 기능
	
}



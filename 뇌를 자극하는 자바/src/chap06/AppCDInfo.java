package chap06;

public class AppCDInfo extends CDInfo implements Lendable {
	
	String borrower;
	String checkOutDate;
	byte state;
	
	AppCDInfo(String registerNo, String title){
		super(registerNo, title);
		
		//=========
		//System.out.println("=========AppCDInfo(String registerNo, String title)");
	}
	
	@Override
	public void checkOut(String borrower, String date) {
		
		
		if(state != 0) //state 0 이 아닐때
			return;  //종료
		
		this.borrower = borrower;
		this.checkOutDate = date;
		this.state = 1; // 대출시 1로 셋팅
		System.out.println("*" + title + " CD가 대출되었습니다.");
		System.out.println("대출인:" + borrower);
		System.out.println("대출일:" + date  + "\n");
		
	}
	@Override
	public void checkIn() { //반납한다
		this.borrower = null;
		this.checkOutDate = null;
		this.state = 0;
		System.out.println("*" + title + " CD가 반납되었습니다.\n");
		
	}
	

}

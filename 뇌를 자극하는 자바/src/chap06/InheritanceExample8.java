/**
 * 2018. 5. 17. Dev By Lee.M.H
   뇌를 자극하는 자바
   InheritanceExample7.java
 */
package chap06;

public class InheritanceExample8 {

	
	public static void main(String[] args) {
		
		EMailSender emailsender = new EMailSender("생일을 축하합니다", " 고객센터", "admin@dukeeshop.co.kr",
				"10% 할인쿠폰이 발행되었습니다.");
		SMSSender emailsender2 = new SMSSender("생일을 축하합니다", "고객센터", "02-000-0000",
				"10% 할인쿠폰이 발행되었습니다.");
		send(emailsender, "hatman@yeyeye.com");
		send(emailsender,"stickman@hahaha.com");
		send(emailsender2,"010-000-0000");

	}
	static void send (MessageSender emailsender, String recipient) {
		emailsender.sendMessage(recipient);
	}

}

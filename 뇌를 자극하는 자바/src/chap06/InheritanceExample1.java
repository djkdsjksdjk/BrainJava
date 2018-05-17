package chap06;

 class Account { //부모클래스
	String accountNo;
	String ownerName;
	int balance;
			
	   public Account() {
		System.out.println("Account() 기본 생성자");
		}
		public Account(String accountNo, String ownerName, int balance) {
		    this.accountNo = accountNo;
			this.ownerName = ownerName;
			this.balance = balance; //슈퍼클래스로 부터 상속받음 필드들을 초기화
			//this.cardNo = cardNo;
			System.out.println("Account(String accountNo, String ownerName, int balance)");
		}
		public int displayBalance() {
			return balance;
		}
			
		void deposit(int amount) {
	    balance += amount;
	}
		int withdraw(int amount) throws Exception{
		    if (balance < amount)
				throw new Exception("잔액이 부족합니다.");
			balance -= amount;
			return amount;
			}
		}

		class CheckingAccount extends Account{
			String cardNo;  //직불카드 번호에 해당하는 필드 선언
			
			/*public CheckingAccount() {
				System.out.println("CheckingAccount() 기본생성자 호출");
			}*/
			
			public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
				//부모클래스에 public Account(String accountNo, String ownerName, int balance) 호출
				super(accountNo, ownerName, balance); //부모클래스의 생성자 호출
				this.cardNo = cardNo; 
				System.out.println("CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) 생성자");
				
			}
			
			int pay(String cardNo, int amount) throws Exception{
				if(!cardNo.equals(this.cardNo)) //(balance < amount))
					throw new Exception("계좌번호가 틀립니다.");
				if(balance < amount)
					throw new Exception("pay(String cardNo, int amount) 잔액이 부족합니다.");
				return withdraw(amount);
			}
		}

		   public class InheritanceExample1{
			   
			public static void main(String args[]) {
				
				
				CheckingAccount obj = new CheckingAccount("111-22-33333333", "홍길동", 0, "5555-6666-7777-8888");
				//Account 클래스로부터 상속받은 필드 사용
				
				//CheckingAccount obj = new CheckingAccount(); //기본 생성자
				
				/*obj.accountNo = "111-22-33333333";
				obj.ownerName = "홍길동";
				obj.cardNo = "5555-6666-7777-8888";*/
				
				obj.deposit(100000);//입금 /Account 클래스로 부터 상속받은 메소드 호출
				
				try {
					int paidAmount = obj.pay("5555-6666-7777-8888", 47000);//출금 
					//CheckingAccount클래스의 생성자 호출
					System.out.println("지불액:" + paidAmount);
					System.out.println("잔액:" + obj.balance);
				}
				catch (Exception e) {
					String msg = e.getMessage();
					System.out.println("예외메세지:" + msg);
				}
			}
		}



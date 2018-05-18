package chap06;

public class InterfaceExample1 {

	public static void main(String[] args) {
		//SeparateVolume obj1 = new SeparateVolume("863?774개", "개미", "베르베르");
		//객체생성시 멤버필드(변수) 값을 셋팅
		//Lendable obj1 = new SeparateVolume("863?774개", "개미", "베르베르");
		
		Lendable obj = new SeparateVolume("863?774개", "개미", "베르베르");
		
		//AppCDInfo obj2 = new AppCDInfo("2005-7001", "Redhat Fedora");
		//Lendable obj2 = new AppCDInfo("2005-7001", "Redhat Fedora");
		
		try {
		obj.checkOut("김영숙", "20060315");
		//System.out.println("=========checkOut(String borrower, String date)");
		//obj2.checkOut("박희경", "20060317");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		obj.checkIn();
		//obj2.checkIn();
		
		obj = new AppCDInfo("2005-7001", "Redhat Fedora");
		try {
			obj.checkOut("박희경", "20060317");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		obj.checkIn();
				
				

	}

}

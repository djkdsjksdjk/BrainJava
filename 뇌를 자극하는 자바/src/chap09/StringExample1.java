package chap09;

public class StringExample1 {

	public static void main(String[] args) {
		
		String str = "자바 커피";
		int len = str.length();
				for(int cnt = 0; cnt < len; cnt++) {
					char ch = str.charAt(cnt);//0,1,2,3,4
					System.out.println(ch);
				}
				
				
				String str1 = new String("Hello Java1");
				String str2 = new String("Hello Java2");
				String str3 = new String("Hello Java3");
				
				
				/*String str1 = "Hello Java";
				String str2 = "Hello Java";*/
				
				
				if(str1.equals(str2))
					System.out.println("같다");
				else 
					System.out.println("다르다");
				
//				System.out.println(str1);
//				System.out.println(str2);
//				System.out.println(str3);
				

	}

}

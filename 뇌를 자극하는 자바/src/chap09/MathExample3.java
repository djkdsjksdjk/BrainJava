package chap09;

public class MathExample3 {

	public static void main(String[] args) {
		
		for(int i= 1; i <= 7; i++) {
			
		double randomvalue = Math.random();
		int value = (int) (randomvalue * 45)+1;
		System.out.println(i + "번째 난수 :" + value);
		}
		/*System.out.println(Math.random());
		System.out.println(Math.random());
		System.out.println(Math.random());*/

	}

}

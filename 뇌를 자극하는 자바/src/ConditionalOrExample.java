/**
 * 2018. 5. 1. Dev By Lee.M.H
   뇌를 자극하는 자바
   ConditionalOrExample.java
 */

/**
 * @author kosea102
 *
 */
public class ConditionalOrExample {

	public static void main(String[] args) {
		int num1 = 0, num2= 0;
		if (++num1 > 0 || ++num2 > 0)
			System.out.println("num1이  0보다 크거나 num2가 0보다 큽니다.");
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		

	}

}

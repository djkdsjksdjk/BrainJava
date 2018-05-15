/**
 * 2018. 5. 15. Dev By Lee.M.H
   뇌를 자극하는 자바
   FiveNumbers.java
 */
package chap09;

import java.util.Random;



/**
 * @author kosea102
 *
 */
public class FiveNumbers {


	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5};
		Random random = new Random();
		int index = random.nextInt(5);
		System.out.println(arr[index]);
		

	}

}

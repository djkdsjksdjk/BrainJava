/**
 * 2018. 5. 15. Dev By Lee.M.H
   뇌를 자극하는 자바
   RandomExample1.java
 */
package chap09;

import java.util.Random;

/**
 * @author kosea102
 *
 */
public class RandomExample1 {

	
	public static void main(String[] args) {
		
		Random random = new Random();
		System.out.println(random.nextInt(100));
		System.out.println(random.nextInt(100));
		System.out.println(random.nextInt(100));

	}

}

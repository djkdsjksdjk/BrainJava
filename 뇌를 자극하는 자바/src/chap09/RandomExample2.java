/**
 * 2018. 5. 15. Dev By Lee.M.H
   뇌를 자극하는 자바
   RandomExample2.java
 */
package chap09;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * @author kosea102
 *
 */
public class RandomExample2 {

	
	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println(date.getTime());
		
		GregorianCalendar gcalendar = new GregorianCalendar();
		System.out.println(gcalendar.getTimeInMillis());
		
		Random random = new Random(date.getTime());
		System.out.println(random.nextInt(100));
		System.out.println(random.nextInt(100));
		System.out.println(random.nextInt(100));

	}

}

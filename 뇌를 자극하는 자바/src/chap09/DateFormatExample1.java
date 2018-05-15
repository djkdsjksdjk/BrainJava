/**
 * 2018. 5. 14. Dev By Lee.M.H
   뇌를 자극하는 자바
   DateFormatExample1.java
 */
package chap09;

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat; 

/**
 * @author kosea102
 *
 */
public class DateFormatExample1 {

	
	public static void main(String[] args) {
		GregorianCalendar calendar = new GregorianCalendar();
		//SimpleDateFormat dateFormat =
				//new SimpleDateFormat("yyyy년 MM월 dd일 EEEE aa hh시 mm분 ss초");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		String str = dateFormat.format(calendar.getTime());
		System.out.println(str);
				
		

	}

}

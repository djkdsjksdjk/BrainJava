import java.util.*;

/**
* 2018. 5. 10. Dev By Lee.M.H
   뇌를 자극하는 자바
   PrintExample1.java
 */

/**
 * @author kosea102
 *
 */
public class PrintExample1 {

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.printf("%+d%n", 10);
		System.out.printf("%+d%n", -10);
		System.out.printf("가격:%,d원%n", 10000000);
		Calendar now = new GregorianCalendar();
		System.out.printf(
				"%1$tY/%1$tm/%1$td %1$tH:%1$tM:%1$tS %n", now);
		System.out.printf(
				"%1$tY년%1$tm월%1$td일 %1$tp %1$tH시%1$tM분%1$tS초 %n", now);
		System.out.printf(Locale.US, "%tc %n", now);
		

	}

}

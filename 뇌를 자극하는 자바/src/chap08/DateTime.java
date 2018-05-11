package chap08;

import java.util.*;

public class DateTime {

	public static void main(String[] args) {
		
		/*Calendar rightNow = Calendar.getInstance();
		Calendar rightNow2 = new GregorianCalendar();
		GregorianCalendar rightNow3 = new GregorianCalendar();
		
		System.out.println("오늘은 " + rightNow.get(Calendar.YEAR)+"년"
				+ (rightNow2.get(Calendar.MONTH) - Calendar.JANUARY + 1) + "월"
				+ rightNow3.get(Calendar.DATE) + "일 입니다." );
		*/
		
		GregorianCalendar obj  = new GregorianCalendar();
		int year = obj.get(GregorianCalendar.YEAR);
		int month = obj.get(GregorianCalendar.MONTH) +1;
		int day = obj.get(GregorianCalendar.DATE);
		System.out.println("오늘은" + year + "년" + month + "월" + day + "일 입니다.");
		
	}

}

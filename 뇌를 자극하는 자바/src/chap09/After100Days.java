package chap09;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;




/**
 * 
 * cal.setTime
 * cal.add(calendar.DATE, 2)
 * cal.add(calendar.MONTH, 2)
 *
 */

public class After100Days {

	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());//현재시간 설정
		calendar.add(Calendar.DATE, 100);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		String date = dateFormat.format(calendar.getTime());
		System.out.println(date);
		
		
		
		
		
		/*Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, 100);
		Date date = cal.getTime();
		System.out.println(date.getYear() + 1900 + "-" + (date.getMonth()+1) +"-" + date.getDate());*/
		
		
		//GregorianCalendar 날짜 구하기 
		
		/*GregorianCalendar gcalendar = new GregorianCalendar();
		gcalendar.add(gcalendar, 5);
		System.out.println(gcalendar.getTime());*/

	}

}

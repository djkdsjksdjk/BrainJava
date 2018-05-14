/**
 * 2018. 5. 14. Dev By Lee.M.H
   뇌를 자극하는 자바
   TimezoneXE1.java
 */
package chap09;

import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * @author kosea102
 *
 */
public class TimezoneXE1 {
	public static void main(String[] args) {
	String[] ids = TimeZone.getAvailableIDs();
	for (String id : ids) {
		System.out.println(displayTimeZone(TimeZone.getTimeZone(id)));
		
	}
	System.out.println("\nTotal TimeZone ID" + ids.length);
	
	}
    private static String displayTimeZone(TimeZone tz) {
    	long hours = TimeUnit.MICROSECONDS.toHours(tz.getRawOffset());
    	long minutes = TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset()) 
                - TimeUnit.HOURS.toMinutes(hours);
// avoid -4:-30 issue
minutes = Math.abs(minutes);

String result = "";
if (hours > 0) {
result = String.format("(GMT+%d:%02d) %s", hours, minutes, tz.getID());
} else {
result = String.format("(GMT%d:%02d) %s", hours, minutes, tz.getID());
}

return result;

	
	


	}

}

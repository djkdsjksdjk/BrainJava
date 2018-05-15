/**
 * 2018. 5. 15. Dev By Lee.M.H
   뇌를 자극하는 자바
   LongLongString.java
 */
package chap09;

/**
 * @author kosea102
 *
 */
public class LongLongString {
	public static void main(String[] args) {
		
	StringBuilder stringbuider = new StringBuilder();
	
	for(String str : args) {
		
		
	stringbuider.append(str);
	stringbuider.append("   ");
	}
	
		System.out.println(stringbuider);

	}

}

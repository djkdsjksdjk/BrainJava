/**
 * 2018. 5. 23. Dev By Lee.M.H
   뇌를 자극하는 자바
   ObjectExample1.java
 */
package chap11;
import java.io.File;
/**
 * @author kosea102
 *
 */
public class ObjectExample1 {

	
	public static void main(String[] args) {
		File file = new File("C:\\뻐꾸기");
		String str = file.toString();
		
		System.out.println(file);

	}

}

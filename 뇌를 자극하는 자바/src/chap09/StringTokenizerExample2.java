/**
 * 2018. 5. 14. Dev By Lee.M.H
   뇌를 자극하는 자바
   StringTokenizerExample2.java
 */
package chap09;

import java.util.StringTokenizer;

/**
 * @author kosea102
 *
 */
public class StringTokenizerExample2 {

	
	public static void main(String[] args) {
		StringTokenizer token = new StringTokenizer("고슴도치,앵무새 | 토끼", ",|" );
				while(token.hasMoreTokens()) {
					String str = token.nextToken();
					System.out.println(str);
				}
		

	}

}

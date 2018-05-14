/**
 * 2018. 5. 14. Dev By Lee.M.H
   뇌를 자극하는 자바
   StringTokenizerEx3.java
 */
package chap09;

import java.util.StringTokenizer;

/**
 * @author kosea102
 *
 */
public class StringTokenizerEx3 {

	
	public static void main(String[] args) {
		
		StringTokenizer stok  = new StringTokenizer("사과=10|초콜릿=3|샴페인=1","=|", true);
		while (stok.hasMoreTokens()) {
			String token = stok.nextToken();
			//System.out.println(token);
			
			if(token.equals("="))
				System.out.print("\t");
			else if (token.equals("|"))
				System.out.print("\n");
			else
				System.out.print(token);
		}
		

	}

}

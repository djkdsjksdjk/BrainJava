/**
 * 2018. 5. 14. Dev By Lee.M.H
   뇌를 자극하는 자바
   StringTokenizerExample1.java
 */
package chap09;

import java.util.StringTokenizer;

/**
 * @author kosea102
 *
 */
public class StringTokenizerExample1 {

	
	public static void main(String[] args) {
		StringTokenizer token = new StringTokenizer("사과	,배?,복숭아", ",?");
		
		//String str1="", str2="", str3="";
		
		while(token.hasMoreTokens()) {
		String str = token.nextToken();
		System.out.println(str);
		}
		
		/*if(token.hasMoreTokens())
		str1 = token.nextToken();
		
		if(token.hasMoreTokens())
		str2 = token.nextToken();
		
		if(token.hasMoreTokens())
	    str3 = token.nextToken();*/
		
		/*System.out.println("str1:" + str1);
		System.out.println("str1:" + str2);
		System.out.println("str1:" + str3);*/
		
		

	}

}

/**
 * 2018. 5. 1. Dev By Lee.M.H
   ³ú¸¦ ÀÚ±ØÇÏ´Â ÀÚ¹Ù
   ConditionalOpExample.java
 */

/**
 * @author kosea102
 *
 */
public class ConditionalOpExample {


	public static void main(String[] args) {
		int a = 20, b = 30, max;
		max = a < b ? ++a : ++b;
		System.out.println(max);
		System.out.println(a);
		System.out.println(b);
	}

}

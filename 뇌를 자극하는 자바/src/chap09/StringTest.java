/**
 * 2018. 5. 15. Dev By Lee.M.H
   뇌를 자극하는 자바
   StringTest.java
 */
package chap09;

/**
 * long start = System.currentTimeMillions();//시작하는 시점 계산
 * 
 * 실행시간을 측정하고 싶은 코드
 * long end = System.currentTimeMillis();//프로그램이 끝나는 시점 계산
		System.out.println("실행 시간 :" + (end - start )/1000.0 + "초");//실행시간 계산 및 출력
*
*/




/**
 * @author kosea102
 *
 */
public class StringTest {

	public static void main(String[] args) {
		long start = System.currentTimeMillis(); //시작하는 시점 계산
		
		for(int i = 1; i < 1000000; i++) {
		}
		//실행시간을 측정하고 싶은 코드 시작
		//실행 시간  : 0.05
		/*String str = "산과 골짜기 위를";
		str += "둥실 떠가는 ";
		str += "구름처럼";*/
		
		//실행시간 : 0.0001
		String str = "산과 골짜기 위를" + "둥실 떠가는" + "구름처럼";
		//실행시간 측정하고 싶은 코드 종료
		System.out.println(str);
		
		/*String str = "";
		str += "동해물과 백두산이 마르고 닳도록"    ;
		str += "하느님이 보우하사 우리나라 만세"    ;
		str += "무궁화 삼천리 화려 강산"            ;
		str += "대한 사람 대한으로 길이 보전하세"   ;
		str += "남산 위에 저 소나무 철갑을 두른 듯" ;
		str += "바람 서리 불변함은 우리 기상일세";
		str += "무궁화 삼천리 화려 강산"             ;
		str += "대한 사람 대한으로 길이 보전하세"    ;
		str += "가을 하늘 공활한데 높고 구름 없이"   ;
		str += "밝은 달은 우리 가슴 일편단심일세"    ;
		str += "무궁화 삼천리 화려 강산"             ;
		str += "대한 사람 대한으로 길이 보전하세"    ;
		str += "이 기상과 이 맘으로 충성을 다하여"   ;
		str += "괴로우나 즐거우나 나라 사랑하세";
		str += "무궁화 삼천리 화려 강산";
		str += "대한 사람 대한으로 길이 보전하세";*/
		
		for(int i = 1; i < 1000000; i++) {
			
		}
		long end = System.currentTimeMillis();
		System.out.println("실행 시간 :" + (end - start )/1000.0 + "초");//실행시간 계산 및 출력
		

	}

}

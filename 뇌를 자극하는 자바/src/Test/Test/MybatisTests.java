package Test.Test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kosea.kmove30.Member;

public class MybatisTests {

public static void main(String[] args) {
		
		String resource = "mybatis-configs.xml"; //src경로
		try {
			
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			
		 // Blog blog = session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 201);
			//Ost ost = new Ost();
			
			////조회 시작////
			
		/*Member member = session.selectOne("org.mybatis.example.SelectMapper.selectOst", 204);
		
		System.out.println("회원 이름: " + ost.getOName());
		System.out.println("회원 전화번호: " + ost.getOPnum());
		System.out.println("회원 성별: " + ost.getGender());
		System.out.println("회원 번호: " + member.getMno());*/
			
			////조회종료////
		
		///////추가시작///////
		
		//Ost newOst = new Ost(205, "김현아", "01053728657");
		//Ost newOst = new Ost();
		
		//newOst.setMno(205);
		//newOst.getOName("김현아");
		//newOst.getOPnum("01053728657");
			
		
		//int insertCount = session.insert("org.mybatis.example.SelectMapper.insertOst", newOst);
		
		//System.out.println("추가 건수: " + insertCount);
		
			///////추가종료///////
			
		///////////수정시작//////////
			
			String queryMapping = "org.mybatis.example.SelectMapper.updateMember";
			Member member = new Member();
			member.setMno(105);
			member.setId("aLEEM");
			member.setPass("bba6268");
			
			//Member member = new Member(105, "LEEID", "123456pw");
			int updateCount = session.update(queryMapping, member);
			System.out.println("수정 건수: " + updateCount);
			
			
			
	///////////수정종료//////////
		
		
		
		
		/////////////////////////////삭제////////////////////////////////
		
		//"org.mybatis.example.SelectMapper.deletMember", 101
		
		//int deleteCount = session.delete("org.mybatis.example.SelectMapper.deleteMember", 101);				
		//System.out.println("삭제건수: " + deleteCount);
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			session.commit();
		  session.close();
		}
		
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}



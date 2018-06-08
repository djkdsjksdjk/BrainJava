package com.kosea.kmove30;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTest {

	public static void main(String[] args) {
		
		String resource = "mybatis-config.xml"; //src경로
		try {
			
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			
		 // Blog blog = session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
			//Member member = new Member();
			
			////조회 시작////
			
		/*Member member = session.selectOne("org.mybatis.example.SelectMapper.selectMember", 105);
		
		System.out.println("회원 아이디: " + member.getId());
		System.out.println("회원 비밀번호: " + member.getPass());
		System.out.println("회원 번호: " + member.getMno());*/
			
			////조회종료////
		
		///////추가시작///////
		
		//Member newMember = new Member(102, "kosea2", "12345");
		//Member newMember = new Member();
		
		//newMember.setMno(105);
		//newMember.setId("TestID5");
		//newMember.setPass("123456");
		
			///////추가종료///////
		
		//int insertCount = session.insert("org.mybatis.example.SelectMapper.insertMember", newMember);
		
		//System.out.println("추가 건수: " + insertCount);
		
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

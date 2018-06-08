package com.kosea.kmove30;
//DataAccess

import org.apache.log4j.Logger;

public class Member {
	private final Logger logger = Logger.getLogger(LogTest1.class);
	
	int mno;
	String id;
	String pass;
	
	public Member() {
	//기본생성자
}

	public Member(int mno, String id, String pass) {
		super();
		this.mno = mno;
		this.id = id;
		this.pass = pass;
	}
	public void printLog(String logMessage) {
		
		logger.info(logMessage);
	}
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
		
		
	}
	



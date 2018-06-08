package Test.Test;

public class Ost {
	int mno;
	String OName;
	String OPnum;
	
	public Ost() {
		//기본 생성자
	}

	public Ost(int mno, String oName, String oPnum) {
		super();
		this.mno = mno;
		this.OName = oName;
		this.OPnum = oPnum;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getOName() {
		return OName;
	}

	public void setOName(String oName) {
		OName = oName;
	}

	public String getOPnum() {
		return OPnum;
	}

	public void setOPnum(String oPnum) {
		OPnum = oPnum;
	}
	

	
	}



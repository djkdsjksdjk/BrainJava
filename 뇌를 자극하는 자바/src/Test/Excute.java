package Test;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Excute extends Frame implements ActionListener {
	// JDBC 설정
	private String url = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=utf8";// user 수정하면
	private String strUser = "root"; // 계정 id
	private String strPassword = "12345"; // 계정 패스워드
	private String strMySQLDriver = "com.mysql.jdbc.Driver";
	Connection con;
	Statement stmt;
	ResultSet rs;
	String sql;

	String id;
	String pass;
	String mname;

	// 로그인과 멤버 클래스를 가져온다
	Member sumit = new Member(); // false
	Login log = new Login(); // true
	LoginSub logSub = new LoginSub(); // false
	Data d = new Data();

	// 다이얼로그, 버튼, 라벨
	Button ok;
	Label msg;
	Dialog info;

	Excute() {

		try {
			// 로그인 버튼이 클릭 되었을시에 jdbc드라이버를 등록한다.
			Class.forName(strMySQLDriver);
			// DriverManager로 부터 커넥션을 얻어오는데 mysql서버 . id, pw 등을 얻어온다
			con = (Connection) DriverManager.getConnection(url, strUser, strPassword);
			// 커넥션으로부터 실제로 sql쿼리를 실행시키기 위한 statement 객체를 얻어온다.
			stmt = (Statement) con.createStatement();

			System.out.println("db연결 성공");

		} catch (Exception b) {
			System.out.println("db연결 실패");
		}

		// 회원가입 등록버튼 리스너
		sumit.btn2.addActionListener(this);//버튼에 리스너를 단다.
		// 회원가입 취 소버튼
		sumit.btn3.addActionListener(this);
		// 회원가입 버튼
		log.button3.addActionListener(this);
		// 로그인 버튼
		log.button1.addActionListener(this);
		// LoginSub의 수정버튼
		// logSub.button1.addActionListener(this);
		// LoginSub 탈퇴버튼
		// logSub.button2.addActionListener(this);
		// LoginSub의 로그아웃 버튼
		logSub.button3.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 해당하는 버튼값 가져오기
		Object obj = e.getSource();
		if (obj.equals(log.button3)) {
			// 로그인 창의 회원가입 버튼
			// member클래스를 띄운다.
			sumit.setVisible(true);
		} else if (obj.equals(log.button2)) {
			//log.setVisible(false);
			log.dispose();
		} else if (obj.equals(log.button1)) {
			// 로그인 창의 로그인 버튼
			loginCheck();

			// 해당 접속자 환영 메세지
			logSub.label1.setText(mname + "님 로그인 되었습니다.");
			// title 변경
			logSub.setTitle(mname + "님 접속창");
			// 로그인 창은 잠시 안보이도록한다.
			log.setVisible(false);

		} else if (obj.equals(logSub.button3)) {
			// logSub 화면을 감춘다.
			logSub.setVisible(false);
			// 로그인창을 띄운다.
			log.setVisible(true);

			// 클리어
			clearText();
			// 로그인 창의 텍스트를 초기화

		} else if (obj.equals(sumit.btn2)) {
			// 회원가입 창의 버튼 라벨이 등록 일 경우, 수정일 경우 각 해당하는 메소드를 실행 해준다.
			if (sumit.btn2.getLabel().equals("Sign Up")) {
				// 삽입
				selectInsert();
				sumit.setVisible(false);
			} else if (sumit.btn2.getLabel().equals("Cancel")) {
				// 수정
				selectUpdate();
			}
		} else if (obj.equals(sumit.btn3)) {
			sumit.setVisible(false);

		}
	}

	private void clearText() {
		log.tex1.setText("");
		log.tex2.setText("");
		sumit.tf_id.setText("");
		sumit.tf_pass.setText("");
		sumit.tf_name.setText("");
		logSub.tex1.setText("");
	}

	// 수정
	private void selectUpdate() {

		Data d = new Data();
		d.id = sumit.tf_id.getText().trim();
		d.pw = sumit.tf_pass.getText().trim();
		d.mname = sumit.tf_name.getText().trim();

		String sql = "update users set id='" + d.id + "',pw='" + d.pw + "' where mname='" + d.mname + "'";
		try {
			int rss = stmt.executeUpdate(sql);
			System.out.println(rss + "업데이트");

			logSub.tex1.setText("업데이트 완료");

			sumit.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	// ?쎌엯
	private void selectInsert() {
		Data d = new Data();
		d.id = sumit.tf_id.getText().trim();
		d.pw = sumit.tf_pass.getText().trim();
		d.mname = sumit.tf_name.getText().trim();
		String sql = "insert into users value('" + d.id + "','" + d.pw + "','" + d.mname + "')";

		try {

			int rss = stmt.executeUpdate(sql);

			System.out.println(rss + "삽입");
			logSub.tex1.setText("삽입 완료");
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	// 로그인 체크
	void loginCheck() {
		// 로그인 창의 텍스트 필드에 쓴값을 가져오기
		id = log.tex1.getText().trim();
		pass = log.tex2.getText().trim();

		// SELECT 쿼리를 작성한다. 해당하는 아이디값의 패스워드를 검색한다.
		String query = "SELECT pw,mname FROM users where id='" + id + "'";

		System.out.println(query);
		try {
			// executeQuery() 메소드로 SELECT문의 실행시키고 결과로 ResultSet 객체를 받는다.
			ResultSet rs = stmt.executeQuery(query);

			// 레코드가 있는지 검사
			if (rs.next()) {
				//
				mname = rs.getString("mname");

				// 텍스트필드에 쓴값과 데이터베이스에 있는 패스원드 값을 비교한다.
				if (pass.equals(rs.getString("pw"))) {

					System.out.println("로그인 되었습니다.");
					JOptionPane.showMessageDialog(null, "로그인 되었습니다.");
					// 맞으면 로그인 서브를 띄워준다
					logSub.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(null, "패스워드를 틀렸습니다.");
				}

			}

		} catch (Exception b) {
			b.printStackTrace();
		}
	}

	// 실행
	public static void main(String[] args) {
		new Excute();

	}
}

package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kosea.kmove30.JDBC_Manager;

public class SelectActionListener implements ActionListener {
	
	//속성
	JTable table;
	JDBC_Manager jdbcManager;
	ResultSet rs;
	
	//생성자
	public SelectActionListener(JDBC_Manager jdbcManager, JTable table) {
		super();
		this.table = table;
		this.jdbcManager = jdbcManager;
	}
	
	//메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("조회버튼");
		
		String query = "select Pname, age, Gender from Person";
		String arr[] = new String[3];
		
//		arr[0] = text1.getText();
//		arr[1] = text2.getText();
//		arr[2] = text3.getText();
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		try {
		rs = jdbcManager.selectTable(query);
		model.setNumRows(0);
		
		ResultSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount();
		System.out.println("컬럼갯수: " + columnCount);
		
		rs.last();
		
		int rowCount = rs.getRow();
		
		rs.beforeFirst();
		System.out.println("레코드 갯수: " + rowCount);
		
		//조회된 결과가 1건이상 있다면
		if(rowCount >= 1 ) {
			while(rs.next()) {
				arr[0] = rs.getString("Pname");
				arr[1] = rs.getString("age");
				arr[2] = rs.getString("Gender");
				//성별을 남.여 구분값으로 변경
				//arr[2] = rs.getString("gender").equals("m") ? "남":"여";
				System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
				model.addRow(arr);//데이터를 테이블에 추가
		}
			
		}else {
		//조회된 결과가 없을때
			JOptionPane.showMessageDialog(null, "조회된 결과가 없습니다.", "경고메세지", JOptionPane.WARNING_MESSAGE);
			System.out.println("조회된 결과가 없습니다.");
		}
	}catch (Exception ex) {
		ex.getMessage();
	}
//		int row = table.getSelectedRow();
//		int col = table.getSelectedColumn();
//		object value = table.getValueAt(row, col);
//		Object value = table.getValueAt(0, 1);
//		System.out.println((String)value);
		
		System.out.println("메소드 종료");
	
	
}
}

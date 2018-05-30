package chap19;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kosea.kmove30.JDBC_Manager;



public class RemoveActionListener implements ActionListener {
	JTable table;
    JDBC_Manager jdbcManager;
    
    
	public RemoveActionListener(JDBC_Manager jdbcManager, JTable table ) {
		super();
		this.table = table;
		this.jdbcManager = jdbcManager;
	}
	RemoveActionListener(JTable table){
		this.table = table;
	}
	public void actionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		
		if(row == -1)
			return;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		//삭제될 이름
		Object name = table.getValueAt(row, 0);
		String deleteName = name.toString();
		System.out.println(deleteName);
				model.removeRow(row);//선택된 행을 삭제
		
		try {		
	//DB테이블 레코드(데이터) 삭제
	jdbcManager.deleteTable(deleteName);			
	}catch (Exception ex) {
		ex.getMessage();
	}

	}
}

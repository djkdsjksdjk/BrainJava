package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class PrintActionListener implements ActionListener {
	JTable table;
	
	public PrintActionListener(JTable table){
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		TableModel model = table.getModel();
		int rowNum = model.getRowCount();
		int colNum = model.getColumnCount();
		
		for(int row = 0; row < rowNum; row++) {
			for(int col = 0; col < colNum; col++) {
				Object obj  = model.getValueAt(row, col);
				System.out.print(obj + "\t");
			}
			System.out.println();
		}
		System.out.println("---------------------");
		
	}

}

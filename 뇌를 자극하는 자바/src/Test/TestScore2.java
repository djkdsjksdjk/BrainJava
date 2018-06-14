package Test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Test.TestScore_Listener;

public class TestScore2 {

	public static void main(String[] args) {
		
		new TestScore_Listener();
		
		JFrame frame = new JFrame("학점 평균 계산 프로그램");
		frame.setPreferredSize(new Dimension(320, 250));
		frame.setLocation(350, 200);
		
		Container contentPane = frame.getContentPane();
		String colName[] = {"과목", "학점", "평점"};
		String colName2[] = {"총 학점", "평점"};
		String score[] = {"선택", "A+", "A0", "B+", "B0",
		          "C+", "C0", "D+","D0","F"};
		
		DefaultTableModel model = new DefaultTableModel(colName, 0);
		new DefaultTableModel(colName2, 0);
		new JTable(model);
		
		GridLayout layout = new GridLayout();
		contentPane.setLayout(layout);
		//contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		JPanel panel = new JPanel();
		
		
		
		JTextField text1 =  new  JTextField(8);
		JTextField text2 =  new  JTextField(2);
		JComboBox<String>scoreCombox = new JComboBox<String>(score);
		
		JTextField text3 =  new  JTextField(8);
		JTextField text4 =  new  JTextField(2);
		JComboBox<String>scoreCombox2 = new JComboBox<String>(score);
		
		JTextField text5 =  new  JTextField(8);
		JTextField text6 =  new  JTextField(2);
		JComboBox<String>scoreCombox3 = new JComboBox<String>(score);
		
		JTextField text7 =  new  JTextField(8);
		JTextField text8 =  new  JTextField(2);
		JComboBox<String>scoreCombox4 = new JComboBox<String>(score);
		
		JTextField text9 =  new  JTextField(8);
		JTextField text10 =  new  JTextField(2);
		JComboBox<String>scoreCombox5 = new JComboBox<String>(score);
		
		JTextField text11 =  new  JTextField(5);
		JTextField text12 =  new  JTextField(3);
		
		panel.add(new JLabel("1.과목"));
		panel.add (text1);
		
		panel.add(new JLabel("학점"));
		panel.add (text2);
		
		panel.add(new JLabel("평점"));
		 panel.add(scoreCombox);
		 
		panel.add(new JLabel("2.과목"));
		panel.add (text3);
		
		panel.add(new JLabel("학점"));
		panel.add (text4);
		
		panel.add(new JLabel("평점"));
		panel.add(scoreCombox2);
		 
		panel.add(new JLabel("3.과목"));
		panel.add (text5);
		
		panel.add(new JLabel("학점"));
		panel.add (text6);
		
		panel.add(new JLabel("평점"));
		panel.add(scoreCombox3);
		 
		panel.add(new JLabel("4.과목"));
		panel.add (text7);
		
		panel.add(new JLabel("학점"));
		panel.add (text8);
		
		panel.add(new JLabel("평점"));
		panel.add(scoreCombox4);
		 
		panel.add(new JLabel("5.과목"));
		panel.add (text9);
		
		panel.add(new JLabel("학점"));
		panel.add (text10);
		
		panel.add(new JLabel("평점"));
		panel.add(scoreCombox5);
		
		contentPane.add(panel, BorderLayout.CENTER);
		
		panel.add(new JLabel("총 학점"));
		panel.add (text11);
		
		panel.add(new JLabel("평점"));
		panel.add (text12);
	
	
		
		 JButton okBtn      =  new  JButton ("계산");
		 panel.add(okBtn);
			okBtn.addActionListener( new TestScore_Listener 
					(text2, text4, text6, text8, text10, text11));
			
			contentPane.add(panel, BorderLayout.SOUTH);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);//화면 전중앙 배치
			
	}

}

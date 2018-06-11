package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class TestScore_Listener implements ActionListener {
	
	JTextField text1;
	JTextField text2;
	
	

	public TestScore_Listener(JTextField text1, JTextField text2) {
		super();
		this.text1 = text1;
		this.text2 = text2;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton b= (JButton)e.getSource();
		if(b.getText().equals("계산")) {
			
			//계산
			
			String strNum1 = text1.getText();
			String strNum2 = text2.getText();
			
			int num1 = Integer.parseInt(strNum1);
			int num2 = Integer.parseInt(strNum2);
			int total = num1 + num2;
			
			System.out.println(total);
			
			
		}
		public void insertTable(String[] arr) throws Exception {
			
			String name = arr[0]; //과목 이름
			String credit = arr[1]; //학점
			String Score = arr[2]; // 평점
			
		}
		Score = Score.equals("A+", "A", "B+", "B", "C+", "C", "D+", "D", "F");
		

	}



	public void insertTable(String[] arr) {
		// TODO Auto-generated method stub
		
	}

}
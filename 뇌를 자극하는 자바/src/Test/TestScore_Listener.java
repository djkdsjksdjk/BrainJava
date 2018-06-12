package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TestScore_Listener implements ActionListener {
	
	JTextField text1, text2, text3, text4, text5, text6, text7,
	           text8, text9, text10, text11, text12;
	
	
	

	public TestScore_Listener(JTextField text2, JTextField text4, JTextField text6, 
			JTextField text8, JTextField text10, JTextField text11) {
		super();
		this.text2 = text2;
		this.text4 = text4;
		this.text6 = text6;
		this.text8 = text8;
		this.text10 = text10;
		this.text11 = text11;
	}



	public TestScore_Listener() {
		System.out.println("TestScore_Listener() 기본 생성자 호출");
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton b= (JButton)e.getSource();
		if(b.getText().equals("계산")) {
			
			//과목 학점 합산
			
			String strNum1 = text2.getText();
			String strNum2 = text4.getText();
			String strNum3 = text6.getText();
			String strNum4 = text8.getText();
			String strNum5 = text10.getText();
			
			int num1 = Integer.parseInt(strNum1);
			int num2 = Integer.parseInt(strNum2);
			int num3 = Integer.parseInt(strNum3);
			int num4 = Integer.parseInt(strNum4);
			int num5 = Integer.parseInt(strNum5);
			
			int total = num1 + num2 + num3 + num4 + num5;
			
			if(strNum1.equals("")) {
				JOptionPane.showMessageDialog(null, "학점을 입력해 주세요.", "경고 메세지", 
						JOptionPane.WARNING_MESSAGE);
				
			System.out.println(total);
			
			text11.setText(String.valueOf(total));
			
			
							
	}else {
			//초기화
			text1.setText("");
			text2.setText("");
			text3.setText("");
			text4.setText("");
			text5.setText("");
			text6.setText("");
			text7.setText("");
			text8.setText("");
			text9.setText("");
			text10.setText("");
			text11.setText("");
			text12.setText("");
		}
	}

}
}
			
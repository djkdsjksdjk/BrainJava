package chap19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JLabel;
import javax.swing.JTextField;
													
public class ConfirButtonActionListener implements ActionListener {
	
	JTextField text;
	JLabel label;
	
	public ConfirButtonActionListener(JTextField text, JLabel label){
		this.text = text;
		this.label = label;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//버튼이 클릭되었을 때 발생
		String name = text.getText();
		
		if(!name.equals("이름을 입력하세요"))
		label.setText("HAHA! " + name);
		else
			label.setText("HAHA! ");
		
	}
	
	

}

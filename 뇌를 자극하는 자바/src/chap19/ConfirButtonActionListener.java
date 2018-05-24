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
		
		String name = text.getText();
		label.setText("HAHA! " + name);
		
	}
	
	

}

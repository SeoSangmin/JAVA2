import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * 10-1
 * 독립클래스로 Action 이벤트 리스너 작성 
 */

public class MyFrame extends JFrame {
	MyFrame(){
		setTitle("GUI 10-1");
		setSize(350,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		
		//make "Action" button.
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionLi()); //ActionListener 달기(등록) 
		cp.add(btn);
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame();
	}
}

class MyActionLi implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if(b.getText().equals("Action")) {
			b.setText("액션");
		} else {
			b.setText("Action");
		}
	}
}



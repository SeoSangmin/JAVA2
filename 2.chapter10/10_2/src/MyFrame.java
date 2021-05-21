import javax.swing.*;
import java.awt.*;
/*
 * 10-2
 * 내부 클래스로 Action 이벤트 리스너 만들기 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
	MyFrame(){
		setTitle("10-2");
		setSize(350,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionLi());
		cp.add(btn);
		
		setVisible(true);
	}
	
	private class MyActionLi implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Action")) {
				b.setText("액션");
			} else {
				b.setText("Action");
			}
			MyFrame.this.setTitle(b.getText()); //change JFrame title
		}
	}

	public static void main(String[] args) {
		new MyFrame();
	}

}

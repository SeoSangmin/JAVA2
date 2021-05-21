import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * 10-5
 * MouseAdapter를 이용하여 예제 10-4를 수정하라. 
 */

public class MyFrame extends JFrame {
	private JLabel la = new JLabel("Hello");
	MyFrame(){
		setTitle("10-5");
		setSize(350,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.addMouseListener(new myMouseLi());
		cp.setLayout(null);
		
		la.setSize(50,20);
		la.setLocation(20,20);
		cp.add(la);
		
		
		setVisible(true);
	}
	
	class myMouseLi extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x, y);
			MyFrame.this.setTitle(String.valueOf(x)+", "+String.valueOf(y));
		}
	}

	public static void main(String[] args) {
		new MyFrame();
	}

}

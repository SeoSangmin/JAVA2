import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * 11-8
 */

public class myframe extends JFrame {
	String[] label_text = {"이름", "학과", "주소"};
	JLabel[] la = new JLabel[3];
	myframe(){
		setTitle("11-8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new GridLayout(3,2,10,10));
		
		for(int i=0;i<la.length; i++) {
			la[i] = new JLabel(label_text[i], SwingConstants.CENTER);
			//텍스트필드 만들기 
			JTextField te = new JTextField(30);
			c.add(la[i]);
			c.add(te);
		}
		
		setSize(200,150);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myframe();
	}

}

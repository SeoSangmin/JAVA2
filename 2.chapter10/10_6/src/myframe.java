import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * 10-6
 * 다양한 keyEvent와 keyListener 활용 
 */

public class myframe extends JFrame {
	private JLabel[] keyMessage;
	myframe(){
		setTitle("10-6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.addKeyListener(new myKeyLi());
		
		keyMessage = new JLabel[3];
		keyMessage[0] = new JLabel(" getKeyCode() ");
		keyMessage[1] = new JLabel(" getKeyChar() ");
		keyMessage[2] = new JLabel(" getKeyText() ");
		
		for(int i=0; i<keyMessage.length; i++) {
			keyMessage[i].setOpaque(true); //component 색을 나타내기위해, 불투명지정해줌.
			keyMessage[i].setBackground(Color.orange);
			c.add(keyMessage[i]);
		}
		
		setSize(350,150);
		setVisible(true);
		c.setFocusable(true); //component가 포커스를 받을 수 있도록 설정 
		c.requestFocus(); //component에 포커스 강제 지정 
	}
	
	class myKeyLi extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			keyMessage[0].setText(Integer.toString(e.getKeyCode()));
			keyMessage[1].setText(Character.toString(e.getKeyChar()));
			keyMessage[2].setText(e.getKeyText(e.getKeyCode()));
		}
	}

	public static void main(String[] args) {
		new myframe();
	}

}

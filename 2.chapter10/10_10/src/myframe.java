import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * 10-10
 * 더블클릭시 컨텐트팬의 배경색 변경 
 * 더블클릭할 때마다 컨텐트팬의 배경색을 랜덤하게 변경한다. 
 * ******************* :~( 왜 안 되는지 모르겠다!!!!!!!! *********************
 */

public class myframe extends JFrame {
	myframe(){
		setTitle("10-10");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton b = new JButton("Click two times.");
		b.addMouseListener(new mouseLi());
		c.add(b);
		
		//c.addMouseListener(new mouseLi());
		
		setSize(350,150);
		setVisible(true);
	}
	
	class mouseLi extends MouseAdapter {
		public void mouseCicked(MouseEvent e) {
			if(e.getClickCount() == 2) {
				System.out.println("you clicked the button two times.");
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				Component c = (Component)e.getSource();
				c.setBackground(new Color(r,g,b));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myframe();
	}

}

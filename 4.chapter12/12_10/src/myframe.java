import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/*
 * 12-10
 */

public class myframe extends JFrame {
	Panel panel = new Panel();
	myframe(){
		setTitle("12-10");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		Button b = new Button("New Button Type");
		b.setOpaque(true);
		b.setBackground(Color.orange);
		c.add(b);
		
		setSize(300,300);
		setVisible(true);
	}
	
	class Button extends JButton{
		Button(String s){
			super(s);
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.red);
			g.drawOval(0, 0, this.getWidth()-1, 
							 this.getHeight()-1);
		}
	}

	public static void main(String[] args) {
		new myframe();
	}

}

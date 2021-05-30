import javax.swing.*;
import java.awt.*;

public class myframe extends JFrame{
	private myPanel panel = new myPanel();
	public myframe() {
		setTitle("12-1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(250,250);
		setVisible(true);
		
	}
	
	class myPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.blue);
			g.drawRect(10, 10, 50, 50);
			g.drawRect(50, 50, 50, 50);
			
			g.setColor(Color.magenta);
			g.drawRect(90, 90, 50, 50);
		}
	}
	
	public static void main(String [] args) {
		new myframe();
	}
}

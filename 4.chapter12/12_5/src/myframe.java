import javax.swing.*;
import java.awt.*;
/*
 * 12-5
 */
public class myframe extends JFrame{
	private myPanel panel = new myPanel();
	public myframe() {
		setTitle("12-5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(170,400);
		setVisible(true);
	}
	
	class myPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(new Color(0x00FF0000));
			g.fillRect(50, 10, 50, 50);
			
			g.setColor(new Color(0x000000FF));
			g.fillOval(50, 70, 50, 50);
			
			g.setColor(new Color(0x0000FF00));
			g.fillRoundRect(50, 130, 50, 50, 30, 30);
			
			g.setColor(new Color(255,50,220));
			g.fillArc(50, 190, 50, 50, 0, 270);
			
			int[] x = {80, 60, 80, 100};
			int[] y = {250, 280, 300, 280};
			g.setColor(Color.orange);
			g.fillPolygon(x, y, 4);
		}
	}
	
	public static void main(String[] args) {
		new myframe();
	}
}
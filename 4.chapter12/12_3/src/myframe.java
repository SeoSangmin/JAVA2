import javax.swing.*;
import java.awt.*;
/*
 * 12-3
 */
public class myframe extends JFrame{
	private Panel panel = new Panel();
	myframe(){
		setTitle("12-3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(350,470);
		setVisible(true);
	}
	
	class Panel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.blue);
			g.setFont(new Font("고딕", Font.PLAIN, 10));
			g.drawString("I Love Java. ~~", 30, 30);
			
			g.setColor(new Color(0x00FF0000));
			g.setFont(new Font("고딕", Font.ITALIC, 30));
			g.drawString("How much?", 30, 60);
			
			for(int i=1; i<=5; i++) {
				g.setColor(new Color(0x00FF00FF));
				g.setFont(new Font("고딕", Font.PLAIN, 10*i));
				g.drawString("This much!", 30, 100+60*i);
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myframe();
	}

}

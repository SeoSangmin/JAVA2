import javax.swing.*;
import java.awt.*;
/*
 * 12-4
 */
public class myframe extends JFrame{
	panel panel = new panel();
	myframe(){
		setTitle("12-4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(200,200);
		setVisible(true);
		
	}
	
	class panel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawLine(20, 20, 100, 100);
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myframe();
	}

}

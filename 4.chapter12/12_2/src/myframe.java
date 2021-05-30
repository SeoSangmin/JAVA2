import javax.swing.*;
import java.awt.*;
/*
 * 12-2
 */
public class myframe extends JFrame {
	private Panel panel1 = new Panel();
	myframe(){
		setTitle("12-2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel1);
		setSize(300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myframe();
	}
	
	class Panel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString("자바는 재밌다.~~", 30, 30);
			g.drawString("얼마나? 하늘만큼 땅만큼 !!!!", 60, 60);
		}
	}

}

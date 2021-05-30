import javax.swing.*;
import java.awt.*;
/*
 * 12-7
 */
public class myframe extends JFrame{
	ImageIcon icon = new ImageIcon("/Users/seosangmin/Pictures/justinbieber.jpg");
	Image img = icon.getImage();
	
	Panel panel = new Panel();
	
	public myframe() {
		setTitle("12-7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(500,500);
		setVisible(true);
	}
	
	class Panel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//1. 화면에 꽉 차게 그리기 
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			
			//2. 일부를 그리기 - (100,100) - (300,300)에 있는 이미지를 (0,0) - (500,500)에 그리기 
			//g.drawImage(img, 0, 0, 500, 500, 100, 100, 300, 300, this);
			
		}
	}

	public static void main(String[] args) {
		new myframe();
	}

}

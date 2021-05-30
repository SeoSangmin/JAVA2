import javax.swing.*;
import java.awt.*;
/*
 * 12-6
 */
public class myframe extends JFrame{
	ImageIcon icon = new ImageIcon("/Users/seosangmin/Pictures/kiwi_500*500.png");
	Image img = icon.getImage();
	Panel panel = new Panel();
	public myframe() {
		setTitle("12-6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(520,560);
		setVisible(true);
	}
	
	class Panel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 20, 20, this);
		}
	}

	public static void main(String[] args) {
		new myframe();
	}

}

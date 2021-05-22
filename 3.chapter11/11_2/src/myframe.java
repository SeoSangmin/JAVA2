import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * 11-2
 */
public class myframe extends JFrame{
	public myframe() {
		setTitle("11-2 : 사랑합니다. ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("사랑합니다."));
		
		ImageIcon heart_image = new ImageIcon("/Users/seosangmin/Pictures/heart.png");
		JLabel imageLabel1 = new JLabel(heart_image,SwingConstants.CENTER);
		c.add(imageLabel1);
		
		ImageIcon call_image = new ImageIcon("/Users/seosangmin/Pictures/normal.png");
		JLabel imageLabel2 = new JLabel("보고싶으면 전화하세요.",call_image, SwingConstants.CENTER);
		c.add(imageLabel2);
		
		setSize(350, 600);
		c.setBackground(new Color(255,255,255));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setVisible(true);
	}
	public static void main(String[] args) {
		new myframe();
	}
}

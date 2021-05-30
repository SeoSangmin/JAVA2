import javax.swing.*;
import java.awt.*;
/*
 * 12-8
 */
public class myframe extends JFrame{
	Panel panel = new Panel();
	public myframe() {
		setTitle("12-8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(300,400);
		setVisible(true);
	}
	
	class Panel extends JPanel{
		ImageIcon icon = new ImageIcon("/Users/seosangmin/Pictures/justinbieber.jpg");
		Image img = icon.getImage();
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setClip(100,20,150,150); //그래픽 대상 컴포넌트의 (x,y) 위치에서 w*h의 사각형 영역을 클리핑 영역으로 지정 
			g.drawImage(img,0,0,this);
			g.setColor(new Color(0x00FF482F));
			g.setFont(new Font("Arial", Font.ITALIC, 40));
			g.drawString("JUSTIN BIEBER", 10, 150);
			
		}
	}

	public static void main(String[] args) {
		new myframe();
	}

}

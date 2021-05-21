import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * 10-9
 * 마우스와 마우스 모션 이벤트 활용 
 */

public class myframe extends JFrame {
	private JLabel la = new JLabel("입력된 값 없음.");
	myframe(){
		setTitle("10-9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		myMouseLi listener = new myMouseLi();
		c.addMouseListener(listener);
		c.addMouseMotionListener(listener);
		
		c.add(la);
		
		setSize(350,150);
		setLocation(100,50);
		setVisible(true);
	}
	
	class myMouseLi implements MouseListener, MouseMotionListener {
		public void mouseEntered(MouseEvent e) {
			//배경 색을 파란 색으로
			Component c = (Component)e.getSource();
			c.setBackground(Color.cyan);
		}
		
		public void mousePressed(MouseEvent e) {
			la.setText("mousePressed("+e.getX()+","+e.getY()+")");
		}

		public void mouseReleased(MouseEvent e) {
			la.setText("mouseReleased("+e.getX()+","+e.getY()+")");
		}
		
		public void mouseMoved(MouseEvent e) {
			la.setText("mouseMoved("+e.getX()+","+e.getY()+")");
		}
		
		public void mouseDragged(MouseEvent e) {
			la.setText("mouseDragged("+e.getX()+","+e.getY()+")");
		}

		public void mouseExited(MouseEvent e) {
			//배경 색을 노란 색으로 
			Component c = (Component)e.getSource();
			c.setBackground(Color.yellow);
		}
		
		public void mouseClicked(MouseEvent e) {}
		
	}
	
	public static void main(String[] args) {
		new myframe();
	}

}

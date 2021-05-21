import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/*
 * 10-4
 * 마우스로 문자열 이동시키기 - 마우스 이벤트 연습 
 * : 컨텐트팬의 아무 위치에 마우스 버튼을 누르면 마우스 포인트가 있는 위치로
 * "hello" 문자열을 옮기는 스윙 응용프로그램을 작성하라. 
 */
import java.awt.event.MouseListener;

public class MyFrame extends JFrame {
	private JLabel la = new JLabel("hello");
	MyFrame(){
		setTitle("10-4");
		setSize(350,150);
		setLocation(200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.addMouseListener(new myMouseListener());
		cp.setLayout(null);
		
		la.setSize(50,20);
		la.setLocation(30,30);
		cp.add(la);
		
		
		setVisible(true);
	}
	
	class myMouseListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x, y);
		}
		
		public void mousePressed(java.awt.event.MouseEvent e) {}
		public void mouseReleased(java.awt.event.MouseEvent e) {}
		public void mouseEntered(java.awt.event.MouseEvent e) {}
		public void mouseExited(java.awt.event.MouseEvent e) {}
	}

	public static void main(String[] args) {
		new MyFrame();
	}

}

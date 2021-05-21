import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * 10-8
 * 상(UP), 하(DOWN), 좌(LEFT), 우(RIGHT) 키로 
 * "HELLO" 문자열을 마음대로 움직이기 
 * "HELLO" 문자열은 JLabel 컴포넌트로 만들어 컨텐트팬에 부착하고 
 * 상, 하, 좌, 우 키를 움직이면 키 방향으로 한 번에 10픽셀씩 움직인다.
 * 이를 위해 컨텐트팬의 배치관리자를 삭제하여야 한다. 
 * "HELLO"문자열을 초기에 (50,50) 위치에 출력하라. 
 */

public class myframe extends JFrame {
	JLabel hello = new JLabel("HELLO");
	private int FLYING_UNIT = 10;
	myframe(){
		setTitle("10-8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		c.addKeyListener(new keyLi());
		
		hello.setSize(60,10);
		hello.setLocation(50,50);
		c.add(hello);
		
		setSize(300,300);
		setVisible(true);
		c.setFocusable(true); //component가 포커스를 받을 수 있도록 설정 
		c.requestFocus(); //component에 포커스 강제 지정 
	}
	
	class keyLi extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int code = e.getKeyCode();
			int x = hello.getX(), y = hello.getY();
			switch(code) {
			case 37: //left 
				x -= FLYING_UNIT; break;
			case 38: //up 
				y -= FLYING_UNIT; break;
			case 39: //right 
				x += FLYING_UNIT; break;
			case 40: //down
				y += FLYING_UNIT; break;
			}
			hello.setLocation(x,y);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myframe();
	}

}

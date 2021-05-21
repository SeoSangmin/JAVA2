import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * 10-7
 * <F1> 키를 입력받으면 컨텐트팬의 배경을 초록색으로, %키를 입력받으면 노란색으로 변경 
 */

public class myframe extends JFrame {
	JLabel la = new JLabel("waiting for push...");
	myframe(){
		setTitle("10-7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.addKeyListener(new keyLi());
		
		c.add(la);
		
		setSize(350,150);
		setVisible(true);
		c.setFocusable(true); //component가 포커스를 받을 수 있도록 설정 
		c.requestFocus(); //component에 포커스 강제 지정 
	}
	
	class keyLi extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int code = e.getKeyCode();
			if(code == 112) { //<F1> 입력
				la.setText("F1키가 입력되었음");
				getContentPane().setBackground(Color.green);
			} else if(code == 53){
				la.setText("5키가 입력되었음");
				getContentPane().setBackground(Color.yellow);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myframe();
	}

}

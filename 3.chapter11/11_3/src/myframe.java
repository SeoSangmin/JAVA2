import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * 11-3
 */

public class myframe extends JFrame {
	myframe(){
		setTitle("11-3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.setBackground(Color.white);
		
		//calling / waiting_call / call_pressed 세 개 그림 '그림'폴더에 있음. 
		
		//이미지 객체
		ImageIcon normal = new ImageIcon("/Users/seosangmin/Pictures/normal.png");
		ImageIcon rollover = new ImageIcon("/Users/seosangmin/Pictures/rollover.png");
		ImageIcon pressed = new ImageIcon("/Users/seosangmin/Pictures/pressed.png");
		
		//버튼
		JButton call_btn = new JButton("call", normal);
		call_btn.setRolloverIcon(rollover);
		call_btn.setPressedIcon(pressed);
		call_btn.setFont(new Font("Arial", Font.BOLD, 70));
		c.add(call_btn);
		
		setSize(500,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myframe();
	}

}

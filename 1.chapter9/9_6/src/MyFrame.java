import javax.swing.*;
import java.awt.*;
/*
 * 9-6
 * 배치관리자 없는 컨테이너에 컴포넌트를 절대 위치와 크기로 지정 
 */

public class MyFrame extends JFrame {
	MyFrame(){
		setTitle("GUI starts. (9-6)");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setLayout(null);
		
		//create 1 label
		JLabel label = new JLabel("Hello, Press Buttons!");
		label.setSize(200, 20);
		label.setLocation(130, 50);
		cp.add(label);
		
		
		//create 10 buttons. 
		for(int i=1; i<=10; i++) {
			JButton btn = new JButton(String.valueOf(i));
			btn.setSize(30, 20);
			btn.setLocation(i*15, i*15);
			cp.add(btn);
		}
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame();
	}

}

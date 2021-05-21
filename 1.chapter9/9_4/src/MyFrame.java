import javax.swing.*;
import java.awt.*;
/*
 * 9-4
 * BorderLayout 배치관리자를 사용하여 컨텐트팬에 다음과 같이 5개의 버튼 컴포넌트를 삽입하라.
 */
public class MyFrame extends JFrame {
	MyFrame(){
		setTitle("GUI starts. (9-4)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout(30, 20));
		
		cp.add(new JButton("add"), BorderLayout.NORTH);
		cp.add(new JButton("div"), BorderLayout.WEST);
		cp.add(new JButton("Culculate"), BorderLayout.CENTER);	
		cp.add(new JButton("mul"), BorderLayout.EAST);
		cp.add(new JButton("sub"), BorderLayout.SOUTH);
		
		setSize(300,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame();
	}

}

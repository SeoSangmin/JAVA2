import java.awt.*;
import javax.swing.*;
/*
 * 9-3
 * 수평 간격이 30, 수직 간격이 40픽셀, LEFT 정렬로 배치하는 FlowLayout 배치관리자를 가진
 * 컨텐트팬에 5개의 버튼 컴포넌트를 부착한 스윙 응용프로그램을 작성하라. 
 */
public class MyFrame extends JFrame {
	MyFrame(){
		//The most basic codes. 
		setTitle("GUI starts. (9-3)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//get contentpane 
		Container cp = getContentPane();
		
		//Set Layout Manager
		cp.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		
		//buttons
		cp.add(new JButton("one"));
		cp.add(new JButton("two"));
		cp.add(new JButton("three"));
		cp.add(new JButton("four"));
		cp.add(new JButton("five"));
		
		setSize(350,220);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame();
	}

}

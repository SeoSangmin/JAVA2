import javax.swing.*;
import java.awt.*;
/*
 * 9-5
 * 아래 화면과 같이 사용자로부터 입력받는 스윙 응용프로그램으로 작성하라. (GridLayout으로 입력 폼 만들기)
 * 두 행 사이의 수직 간격 vGap은 5픽셀로 설정 
 */

public class MyFrame extends JFrame {
	private String[] label_titles = {"이름", "학번", "학과", "과목"};
	
	MyFrame(){
		setTitle("GUI starts. (9-5)");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(4,2,5,5)); // (row, column, hGap, vGap)
		
		for(int i=0; i<label_titles.length; i++) {
			cp.add(new JLabel(label_titles[i]));
			cp.add(new JTextField("")); 
		}
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame();
	}

}

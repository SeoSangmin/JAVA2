import java.awt.*;
import javax.swing.*;
/*
 * 9-2
 * 3개의 컴포넌트를 가진 스윙프레임 만들기 
 * 컨텐트팬의 배경색을 오렌지로, 이곳에 OK, Cancel, Ignore 버튼들을 부착한 스윙프로그램을 작성하라. 
 */
public class MyFrame extends JFrame {
	MyFrame(){ //생성자 
		setTitle("GUI starts. (9-2)");
		setSize(300,200);
		
		//컨텐트팬 
		Container cp = getContentPane();
		cp.setBackground(Color.ORANGE); //set color of contentpane (orange)
		cp.setLayout(new FlowLayout()); //set layout - FlowLayout 
		
		cp.add(new JButton("OK")); //add "OK" button to contentpane
		cp.add(new JButton("Cancel")); //add "Cancel" button to contentpane
		cp.add(new JButton("Ignore")); //add "Ignore" button to contentpane
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyFrame(); //show MyFrame
	}

}

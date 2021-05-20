import javax.swing.JFrame;

//MyFrame 은 JFrame을 상속. 
public class MyFrame extends JFrame {
	
	MyFrame(){
		setTitle("GUI starts.");
		setSize(300,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
	}

}

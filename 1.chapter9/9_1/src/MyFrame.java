import javax.swing.JFrame;

//MyFrame ์ JFrame์ ์์. 
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

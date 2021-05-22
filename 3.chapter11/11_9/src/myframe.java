import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * 11-9
 */
public class myframe extends JFrame{
	private JTextField text1 = new JTextField(35);
	private JTextArea text2 = new JTextArea(24, 35);
	myframe(){
		setTitle("11-9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//label 
		JLabel la = new JLabel("입력 후 <Enter>키를 입력하세요.");
		la.setSize(500,30);
		c.add(la);
		
		text1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				text2.append(t.getText() + "\n");
				t.setText("");
			}
		});
		c.add(text1);
		
		text2.setEnabled(false);
		c.add(new JScrollPane(text2));
	
		setSize(500,500);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myframe();
	}

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
/*
 * 11-11
 */
public class myframe extends JFrame{
	JList<String> nameList = new JList<String>();
	Vector<String> name = new Vector<String>();
	myframe(){
		setTitle("11-11");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("이름 입력 후 <Enter> 키");
		label.setFont(new Font("Arial", Font.ITALIC, 20));
		c.add(label);
		
		JTextField txt = new JTextField(20);
		txt.setFont(new Font("Arial", Font.ITALIC, 20));
		txt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextField t = (JTextField)e.getSource();
				name.add(t.getText());
				nameList.setListData(name);
				t.setText("");
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				nameList.setForeground(new Color(r,g,b));
			}
			
		});
		
		c.add(txt);
		nameList.setFont(new Font("Arial", Font.ITALIC, 20));
		//nameList.setPreferredSize(new Dimension(50, 50)); -> 리스트 내부의 공간 변경 
		//nameList.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 1));
		c.add(new JScrollPane(nameList));
		
		setSize(700,700);
		setLocation(400,100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new myframe();
	}
}

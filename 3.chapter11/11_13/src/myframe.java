import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
/*
 * 11-13
 */
public class myframe extends JFrame{
	private ImageIcon[] fruitIcon = { //image : apple, pear, cherry, kiwi 
			new ImageIcon("/Users/seosangmin/Pictures/apple_500*500.png"),
			new ImageIcon("/Users/seosangmin/Pictures/pear_500*500.png"),
			new ImageIcon("/Users/seosangmin/Pictures/cherry_500*500.png"),
			new ImageIcon("/Users/seosangmin/Pictures/kiwi_500*500.png")};
	
	private String[] fruitNameArray = {"apple","pear","cherry","kiwi"};
	
	private JLabel laIcon = new JLabel("Choose a fruit.");
	
	private JComboBox<String> fruitBox = new JComboBox<String>(fruitNameArray);
	
	myframe(){
		setTitle("11-13");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//콤보박스
		fruitBox.addActionListener(new ActionLi());
		c.add(fruitBox);
		
		//라벨
		laIcon.setFont(new Font("Arial", Font.TYPE1_FONT, 70));
		c.add(laIcon);
		setSize(500,600);
		setVisible(true);
	}
	
	class ActionLi implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JComboBox box = (JComboBox)e.getSource();
			laIcon.setIcon(fruitIcon[box.getSelectedIndex()]);
			/* -> 바로 위의 한 줄이면 끝날 코드들 
			if(box.getSelectedItem().equals("apple")) laIcon.setIcon(fruitIcon[0]);
			if(box.getSelectedItem().equals("pear")) laIcon.setIcon(fruitIcon[1]);
			if(box.getSelectedItem().equals("cherry")) laIcon.setIcon(fruitIcon[2]);
			if(box.getSelectedItem().equals("kiwi")) laIcon.setIcon(fruitIcon[3]);
			*/
			laIcon.setText("");
		}
	}
	
	public static void main(String[] args) {
		new myframe();
	}
}

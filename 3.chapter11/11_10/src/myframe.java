import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * 11-10
 */
public class myframe extends JFrame{
	ImageIcon[] icons = {new ImageIcon("/Users/seosangmin/Pictures/apple.png"),
			new ImageIcon("/Users/seosangmin/Pictures/pear.png"),
			new ImageIcon("/Users/seosangmin/Pictures/cherry.png")};
	
	myframe(){
		setTitle("11-10");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		String[] fruits = {"apple", "banana", "kiwi", "mange",
				"pear", "peach", "berry", "strawberry", "blackberry"};
		
		JList<String> strList = new JList<String>(fruits);
		c.add(strList);
		
		JList<ImageIcon> pngList = new JList<ImageIcon>();
		pngList.setListData(icons);
		c.add(pngList);
		
		JList<String> strListScroll = new JList<String>(fruits);
		c.add(new JScrollPane(strListScroll));
		
		setSize(600,700);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myframe();
	}

}

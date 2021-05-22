import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * 11-4
 */
public class Myframe extends JFrame{
	Myframe(){
		setTitle("11-4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JCheckBox box1 = new JCheckBox("고양이");
		JCheckBox box2 = new JCheckBox("사자");
		JCheckBox box_image = new JCheckBox("전화", new ImageIcon("/Users/seosangmin/Pictures/normal.png"));
		box_image.setBorderPainted(true);
		box_image.setSelectedIcon(new ImageIcon("/Users/seosangmin/Pictures/rollover.png"));
		
		
		c.add(box1);
		c.add(box2);
		c.add(box_image);
		
		setSize(400,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Myframe();
	}

}



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * 11-7
 * modify 11-7.
 * show a image of selected fruit.
 */

public class myframe extends JFrame{
	int fruit_number = 3;
	JRadioButton[] fruit = new JRadioButton[fruit_number];
	String[] fruit_name = {"Apple", "Pear", "Cherry"};
	ImageIcon[] fruit_image = {new ImageIcon("/Users/seosangmin/Pictures/apple.png"),
			new ImageIcon("/Users/seosangmin/Pictures/pear.png"),
			new ImageIcon("/Users/seosangmin/Pictures/cherry.png")};
	JLabel image_label = new JLabel();
	myframe(){
		setTitle("11-6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//radio button
		ButtonGroup group = new ButtonGroup();
		
		itemLi listener = new itemLi();
		for(int i=0; i<fruit_number; i++) {
			fruit[i] = new JRadioButton(fruit_name[i]);
			fruit[i].addItemListener(listener);
			group.add(fruit[i]);
			c.add(fruit[i]);
		}
		
		c.add(image_label);
		
		setSize(300,300);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setVisible(true);
	}
	
	class itemLi implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getItem() == fruit[0]) image_label.setIcon(fruit_image[0]);
			if(e.getItem() == fruit[1]) image_label.setIcon(fruit_image[1]);
			if(e.getItem() == fruit[2]) image_label.setIcon(fruit_image[2]);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myframe();
	}

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * 11-6
 */
public class myframe extends JFrame{
	myframe(){
		setTitle("11-6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//radio button
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton apple = new JRadioButton("Apple");
		JRadioButton pear = new JRadioButton("Pear");
		JRadioButton cherry = new JRadioButton("Cherry");
		
		group.add(apple);
		group.add(pear);
		group.add(cherry);
		
		c.add(apple);
		c.add(pear);
		c.add(cherry);
		
		setSize(500,300);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myframe();
	}

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * 11-12
 */
import java.util.Vector;
public class myframe extends JFrame{
	private String[] fruitName = {"apple","banana","kiwi","mango",
			"pear","peach","berry","strawberry","blackberry"};
	private String[] personName = {"Alix","Daman","Jongrok","H.H"};
	
	myframe(){
		setTitle("11-12");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JComboBox<String> fruitList = new JComboBox<String>(fruitName);
		JComboBox<String> personList = new JComboBox<String>();
		
		c.add(fruitList);
		for(int i=0; i<personName.length; i++) {
			personList.addItem(personName[i]); // dynamic - addItem() method 
			c.add(personList);
		}
		
		setSize(500,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new myframe();
	}
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * 11-14
 */

public class myframe extends JFrame {
	myframe(){
		setTitle("11-14");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		//c.setLayout(new FlowLayout());
		c.setLayout(null);
		
		//JSlider
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 1000, 500);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(100);
		slider.setMinorTickSpacing(10);
		slider.setSize(500,60);
		slider.setLocation(0, 90);
		c.add(slider);
		
		setSize(500,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myframe();
	}

}

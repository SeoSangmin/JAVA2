import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
 * 11-5
 */

public class myframe extends JFrame {
	private JCheckBox box[] = new JCheckBox[3];
	private String fruit[] = {"사과", "배", "체리"};
	JLabel last = new JLabel("현재 0원 입니다.");
	private int sum = 0;
	myframe(){
		setTitle("11-5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("사과 100원, 배 500원, 체리 20000원"));
		for(int i=0; i<box.length; i++) {
			box[i] = new JCheckBox(fruit[i]);
			box[i].addItemListener(new myItemListener());
			c.add(box[i]);
		}

		c.add(last);
		
		setSize(250,200);
		setVisible(true);
	}
	
	class myItemListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				if(e.getItem() == box[0])
					sum += 100;
				if(e.getItem() == box[1])
					sum += 500;
				if(e.getItem() == box[2])
					sum += 20000;
			}
			else {
				if(e.getItem() == box[0])
					sum -= 100;
				if(e.getItem() == box[1])
					sum -= 500;
				if(e.getItem() == box[2])
					sum -= 20000;
			}
			last.setText("현재 "+ sum +"원 입니다.");
		}
	};
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new myframe();
	}

}

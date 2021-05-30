import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/*
 * 과제 
 */
public class myframe extends JFrame{
	panel panel = new panel();
	myframe(){
		setTitle("폐다각형 그리기 과제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(500,500);
		setVisible(true);
	}
	
	class panel extends JPanel{
		private ArrayList<Integer> x = new ArrayList<Integer>();
		private ArrayList<Integer> y = new ArrayList<Integer>();
		panel(){
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					x.add(e.getX());
					y.add(e.getY());
				}
				public void mouseReleased(MouseEvent e) {
					repaint();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int[] xs = (int[])convertIntegers(x);
			int[] ys = (int[])convertIntegers(y);
			
			g.drawPolygon(xs,ys,xs.length);
			
		}
	}
	
	public static int[] convertIntegers(ArrayList<Integer> integers)
	{
	    int[] ret = new int[integers.size()];
	    for (int i=0; i < ret.length; i++) {
	        ret[i] = integers.get(i).intValue();
	    }
	    return ret;
	}

	public static void main(String[] args) {
		new myframe();
	}

}

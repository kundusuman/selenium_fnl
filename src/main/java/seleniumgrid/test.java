package seleniumgrid;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class test {

	 public static void main(String[] args) {
	        final int MAX = 100;
	        final JFrame frame = new JFrame("JProgress Demo");
	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        // creates progress bar
	        final JProgressBar pb = new JProgressBar();
	        pb.setMinimum(0);
	        pb.setMaximum(MAX);
	        pb.setStringPainted(true);
	        pb.setPreferredSize(new Dimension(1000,200));
	        // add progress bar
	        pb.setUI(new ProgressBarUI());
	        frame.setLayout(new FlowLayout());
	        frame.getContentPane().add(pb);
	        frame.setUndecorated(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1000, 200);
	        frame.setVisible(true);
	        frame.setAlwaysOnTop(true);

	        Color startColor = Color.red;
	        Color endColor = Color.blue;

	        
	 
	        // update progressbar
	        for (int i = 0; i <= MAX; i++) {
	            final int currentValue = i;
	            try {
	                SwingUtilities.invokeLater(new Runnable() {
	                    public void run() {
	                        pb.setValue(currentValue);
	                    }
	                });
	                java.lang.Thread.sleep(100);
	            } catch (InterruptedException e) {
	                JOptionPane.showMessageDialog(frame, e.getMessage());
	            }
	            
	        }
	        frame.setVisible(false); //you can't see me!
	        frame.dispose();
	 
	    }

}

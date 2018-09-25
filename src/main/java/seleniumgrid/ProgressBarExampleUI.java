package seleniumgrid;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;

 
public class ProgressBarExampleUI extends JPanel {
 	 	    public static void main(String[] args) {
	        final int MAX = 100;
	        final JFrame frame = new JFrame("JProgress Demo");
	       
	        // creates progress bar
	        final JProgressBar pb = new JProgressBar();
	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        pb.setMinimum(0);
	        pb.setMaximum(MAX);
	        pb.setStringPainted(true);
	        pb.setUI(new ProgressBarUI());
	        int wid=(int) screenSize.getWidth();
	        System.out.println(wid);
	        pb.setPreferredSize(new Dimension(wid,20));
	        // add progress bar
	        frame.setLayout(new FlowLayout());
	        frame.getContentPane().add(pb);
	        frame.setUndecorated(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(wid, 20);
	        frame.setVisible(true);
	        frame.setAlwaysOnTop (true);
	        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	        frame.setLocation((int)screenSize.getWidth()/2, (int)screenSize.getHeight()/2);
	 
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

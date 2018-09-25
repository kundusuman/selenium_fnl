package seleniumgrid;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class GetProgressBar
{
	
	public static JProgressBar getBar()
	{	
         frame= new JFrame("JProgress Demo");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // creates progress bar
        final JProgressBar pb = new Frame().bar();
        pb.setMinimum(0);
        pb.setMaximum(100);
        pb.setStringPainted(true);
      // pb.setUI(new IllusionProgressBarUI());
        pb.setPreferredSize(new Dimension(1000,20));
        // add progress bar
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(pb);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 20);
        frame.setVisible(true);
        return pb;
	}
	public static void end()
	{
		frame.setVisible(false); //you can't see me!
        frame.dispose();
	}

}

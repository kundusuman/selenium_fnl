package seleniumgrid;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;


public class qqqq {

    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JProgressBar bar = new JProgressBar(JProgressBar.VERTICAL,0,100);
    JButton button = new JButton();

    public static void main(String arg[]) {
        new qqqq();
    }

    public qqqq() {
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setLayout(null);
        label.setOpaque(true);
        label.setBackground(Color.BLACK);
        label.setBounds(10,50,100,20);
        bar.setBounds(140,25,20,200);
        button.setBounds(220,100,50,50);
        button.addActionListener(new Progress());
        frame.add(label);
        frame.add(bar);
        frame.add(button);
        frame.setVisible(true);
    }

    class Progress extends SwingWorker<Void, Void> implements ActionListener {

        public Void doInBackground() {
            for(int i=0; i<101; i++) {
                bar.setValue(i);
                try {
                    Thread.sleep(100);
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        public void actionPerformed(ActionEvent e) {
            this.execute();
        }
    }

}
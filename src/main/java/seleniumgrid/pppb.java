package seleniumgrid;

import javax.swing.JFrame;
import javax.swing.JProgressBar;    
public class pppb extends JFrame{   
	
JProgressBar jb;    
int i=0,num=0;     
pppb(){    
jb=new JProgressBar(0,2000);    
jb.setBounds(40,40,160,30);         
jb.setValue(0);    
jb.setStringPainted(true);    
add(jb);    
setSize(250,150);    
setLayout(null);    
}    
   
public static void main(String[] args) {    
    pppb m=new pppb();    
    m.setVisible(true);    
    m.iterate();    
}    
} 

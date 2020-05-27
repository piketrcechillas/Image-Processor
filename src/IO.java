import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class IO {
	 /**
	  * @wbp.parser.entryPoint
	  */
	
	private static JTextField textField_1;
	private static JSlider slider;
	
	 /**
	  * @wbp.parser.entryPoint
	  */
	 public static void displayImage(BufferedImage img1, BufferedImage img2) {
         ImageIcon icon=new ImageIcon(img1);
         ImageIcon icon2=new ImageIcon(img2);
         JFrame frame=new JFrame();
         frame.getContentPane().setLayout(new FlowLayout());  
         frame.setSize(img1.getWidth()+150, img1.getHeight()*3);     
         JLabel lb1=new JLabel();
         JLabel lb2=new JLabel();
         lb1.setText("Before");
         lb2.setText("After");
         lb1.setIcon(icon);
         lb2.setIcon(icon2);
         frame.getContentPane().add(lb1, BorderLayout.CENTER);
         frame.getContentPane().add(lb2, BorderLayout.CENTER);
         
         textField_1 = new JTextField("255");
 	   	 textField_1.setColumns(5);
 		
 		slider = new JSlider();
 		slider.setMinorTickSpacing(50);
 		slider.setPaintLabels(true);
 		slider.setPaintTicks(true);
 		slider.setMajorTickSpacing(100);
 		slider.setMaximum(500);
 		slider.setValue(255);
 		
 		  slider.addChangeListener(new ChangeListener(){
 	            @Override
 	            public void stateChanged(ChangeEvent e) {
 	            	textField_1.setText(String.valueOf(slider.getValue()));
 	            	
 	            	HistogramEqualization.setScaleFactor(slider.getValue());
					BufferedImage result = HistogramEqualization.process(img1);
					ImageIcon iconUpdate = new ImageIcon(result);
					lb2.setIcon(iconUpdate);
					frame.repaint();
 	            }
 	        });
 		  
 		  textField_1.addKeyListener(new KeyAdapter(){
 	            @Override
 	            public void keyReleased(KeyEvent ke) {
 	                String typed =  textField_1.getText();
 	                slider.setValue(0);
 	                if(!typed.matches("\\d+") || typed.length() > 3) {
 	                    return;
 	                }
 	                int value = Integer.parseInt(typed);
 	                slider.setValue(value);
 	               HistogramEqualization.setScaleFactor(slider.getValue());
					BufferedImage result = HistogramEqualization.process(img1);
					ImageIcon iconUpdate = new ImageIcon(result);
					lb2.setIcon(iconUpdate);
					frame.repaint();
 	            }
 	        });
         slider.setMajorTickSpacing(100);
         slider.setPaintLabels(true);
         slider.setPaintTicks(true);
         slider.setMaximum(500);
         JLabel lb3 =new JLabel();
         lb3.setText("Threshold");
        // frame.getContentPane().add(lb3);
         //frame.getContentPane().add(slider,  BorderLayout.SOUTH);
         //frame.getContentPane().add(textField_1, BorderLayout.SOUTH);
         frame.getContentPane().add(lb3);
         frame.setVisible(true);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
	 
	 public static void displayImageLinearFilter(BufferedImage img1, BufferedImage img2) {
         ImageIcon icon=new ImageIcon(img1);
         ImageIcon icon2=new ImageIcon(img2);
         JFrame frame=new JFrame();
         frame.getContentPane().setLayout(new FlowLayout());  
         frame.setSize(img1.getWidth()+150, img1.getHeight()*2 + 30);     
         JLabel lb1=new JLabel();
         JLabel lb2=new JLabel();
         lb1.setText("Image 1");
         lb2.setText("Image 2");
         lb1.setIcon(icon);
         lb2.setIcon(icon2);
         frame.getContentPane().add(lb1, BorderLayout.CENTER);
         frame.getContentPane().add(lb2, BorderLayout.CENTER);
         
     


        // frame.getContentPane().add(lb3);
         frame.setVisible(true);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
}

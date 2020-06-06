import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;

public class IOGeneral {
	
	private static JFrame frame = new JFrame();
	private static  JLabel lb1=new JLabel();
	private static  JLabel lb2=new JLabel();
	private static  JLabel lbHistogram1 =new JLabel();
	private static  JLabel lbHistogram2 =new JLabel();
	private static BufferedImage hist1;
	private static BufferedImage hist2;
	private static BufferedImage result;
	
	public static void displayImage(BufferedImage img1, BufferedImage img2) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
			
			result = img2;
			String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
			UIManager.setLookAndFeel(lookAndFeel);
			Font newLabelFont=new Font(lb1.getFont().getName(),Font.ITALIC+Font.BOLD,lb1.getFont().getSize());
			lb1.setFont(newLabelFont);
			lb2.setFont(newLabelFont);
		    ImageIcon icon=new ImageIcon(img1);
		    ImageIcon icon2=new ImageIcon(img2);
		    lb1.setText("Before");
		    lb2.setText("After");
		    lb1.setIcon(icon);
		    lb2.setIcon(icon2);
	
		    hist1 = drawHistogramImage(img1, 1);
		    hist2 = drawHistogramImage(img2, 2);
		    ImageIcon iconHist1  = new ImageIcon(hist1);
		    ImageIcon iconHist2  = new ImageIcon(hist2);
		    lbHistogram1.setIcon(iconHist1);
		    lbHistogram2.setIcon(iconHist2);
		    
		    frame.setSize(img1.getWidth()*2+250, img1.getHeight()*2+175);

			 JButton btnNewButton = new JButton("Refilter");
		 	    
		 	    btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							ChooseModeNew newMode = new ChooseModeNew(result);
							newMode.setVisible(true);
						} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
								| UnsupportedLookAndFeelException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
		 	    });
			
		
			GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
	        groupLayout.setHorizontalGroup(
	        	groupLayout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(groupLayout.createSequentialGroup()
	        			.addGap(7)
	        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	        				.addGroup(groupLayout.createSequentialGroup()
	        					.addComponent(lb1)
	        					.addGap(10)
	        					.addComponent(lb2)
	        					.addGap(10)
	        					)
	        				.addGroup(groupLayout.createSequentialGroup().
	        								addComponent(lbHistogram1)
	        		     					.addGap(20)
	        		     					.addComponent(lbHistogram2)
	        		     					.addGap(0)))
	        			.addComponent(btnNewButton)
	        			.addPreferredGap(ComponentPlacement.UNRELATED)
	        ));
	        groupLayout.setVerticalGroup(
	        	groupLayout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(groupLayout.createSequentialGroup()
	        			
	        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	        				.addComponent(lb1)
	        				.addComponent(lb2)
	            			).addGap(30)
	        			
	        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
			         			.addComponent(lbHistogram1)
			  					.addComponent(lbHistogram2).addGap(50)
			  					.addGroup(groupLayout.createSequentialGroup() 
	        				))
	        			.addComponent(btnNewButton)
	        			.addContainerGap(47, Short.MAX_VALUE))
	        );
	        frame.getContentPane().setLayout(groupLayout);
	       
	       
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}
	
	 public static BufferedImage drawHistogramImage(BufferedImage image, int index) {
		 HistogramDataset dataset = new HistogramDataset();
	        Raster raster = image.getRaster();
	        final int w = image.getWidth();
	        final int h = image.getHeight();
	        double[] r = new double[w * h];
	        r = raster.getSamples(0, 0, w, h, 0, r);
	        dataset.addSeries("Value", r, 256);
	        JFreeChart chart = ChartFactory.createHistogram("Histogram " + index, "Value",
	                "Count", dataset, PlotOrientation.VERTICAL, true, true, false);
       
       BufferedImage chartImage = chart.createBufferedImage(image.getWidth(), image.getHeight());
       return chartImage;
        
	 }
}

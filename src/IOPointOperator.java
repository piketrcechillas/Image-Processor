import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class IOPointOperator {
	 /**
	  * @wbp.parser.entryPoint
	  */
	
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JSlider sliderAlpha;
	private static JSlider sliderBeta;
	private static JSlider sliderGamma;
	private static JSlider sliderA;
	private static JSlider sliderB;
	private static  JFrame frame = new JFrame();
	private static  JLabel lb1=new JLabel();
	private static  JLabel lb2=new JLabel();
	private static  JLabel lbChart=new JLabel();
	private static  JLabel lbHistogram1 =new JLabel();
	private static  JLabel lbHistogram2 =new JLabel();
	
	private static BufferedImage chartPanel;
	private static BufferedImage hist1;
	private static BufferedImage hist2;
	/**
	 * @wbp.nonvisual location=89,404
	 */
	/**
	  * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @wbp.parser.entryPoint
	  */
	 public static void displayPointOperator(BufferedImage img1, BufferedImage img2) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		 String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
			UIManager.setLookAndFeel(lookAndFeel);
         ImageIcon icon=new ImageIcon(img1);
         ImageIcon icon2=new ImageIcon(img2);
         frame.setSize(img1.getWidth()*3+175, img1.getHeight()*2+200);     

         
         Font newLabelFont=new Font(lb1.getFont().getName(),Font.ITALIC+Font.BOLD,lb1.getFont().getSize());
			lb1.setFont(newLabelFont);
			lb2.setFont(newLabelFont);
         
         
         lb1.setText("Before");
         lb2.setText("After");
         lb1.setIcon(icon);
         lb2.setIcon(icon2);
         
         textField_1 = new JTextField("0.0");
 	   	 textField_1.setColumns(5);
 	   	 textField_2 = new JTextField("2.0");
	   	 textField_2.setColumns(5);
	   	 textField_3 = new JTextField("0.0");
 	   	 textField_3.setColumns(5);
 	   	 textField_4 = new JTextField("90");
	   	 textField_4.setColumns(5);
	   	 textField_5 = new JTextField("140");
 	   	 textField_5.setColumns(5);
 	   	 
 		
 	   	 sliderAlpha = init(sliderAlpha, 0, 100);
 	   	 sliderBeta = init(sliderBeta, 20, 100);
 	   	 sliderGamma = init(sliderGamma, 0, 100);
 	   	 sliderA = init(sliderA, 90, 255);
 	   	 sliderB = init(sliderB, 140, 255);
 	   	 addChangeListenerFloat(sliderAlpha, textField_1, img1);
 	   	 addChangeListenerFloat(sliderBeta, textField_2, img1);
 	   	 addChangeListenerFloat(sliderGamma, textField_3, img1);
 	   	 addChangeListener(sliderA, textField_4, img1);
 	   	 addChangeListener(sliderB, textField_5, img1);
 	  
 	    chartPanel = drawHistogram(img1);
 	    ImageIcon iconChart =new ImageIcon(chartPanel);
 	    lbChart.setIcon(iconChart);
 	    hist1 = drawHistogramImage(img1, 1);
 	    hist2 = drawHistogramImage(img2, 2);
 	    ImageIcon iconHist1  = new ImageIcon(hist1);
 	    ImageIcon iconHist2  = new ImageIcon(hist2);
 	    lbHistogram1.setIcon(iconHist1);
 	    lbHistogram2.setIcon(iconHist2);
 	   
 	   
 	   
         JLabel lb3 =new JLabel();
         lb3.setText("α");
         JLabel lb4 =new JLabel();
         lb4.setText("β");
         JLabel lb5 =new JLabel();
         lb5.setText("γ");
         JLabel lb6 =new JLabel();
         lb6.setText("a");
         JLabel lb7 =new JLabel();
         lb7.setText("b");
        // frame.getContentPane().add(lb3);
         /*
         
         frame.getContentPane().add(sliderAlpha);
         frame.getContentPane().add(sliderBeta);
         frame.getContentPane().add(sliderGamma);
         frame.getContentPane().add(sliderA);
         frame.getContentPane().add(sliderB);
         */

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
         					.addComponent(lbChart)
         					.addGap(0)
         					)
         				.addGroup(groupLayout.createSequentialGroup().
         								addComponent(lbHistogram1)
         		     					.addGap(20)
         		     					.addComponent(lbHistogram2)
         		     					.addGap(0)
         					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
         						.addComponent(sliderB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         						.addComponent(sliderA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         						.addComponent(sliderGamma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         						.addComponent(sliderBeta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         						.addComponent(sliderAlpha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
         					.addGap(0)
         					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
         						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
         			.addPreferredGap(ComponentPlacement.UNRELATED)
         			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
         				.addComponent(lb3)
         				.addComponent(lb4)
         				.addComponent(lb5)
         				.addComponent(lb6)
         				.addComponent(lb7))
         			.addContainerGap(228, Short.MAX_VALUE))
         );
         groupLayout.setVerticalGroup(
         	groupLayout.createParallelGroup(Alignment.LEADING)
         		.addGroup(groupLayout.createSequentialGroup()
         			
         			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
         				.addComponent(lb1)
         				.addComponent(lb2)
         				.addComponent(lbChart).addGap(50)
             			)
         			
         			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
 		         			.addComponent(lbHistogram1)
 		  					.addComponent(lbHistogram2).addGap(50)
 		  					.addGroup(groupLayout.createSequentialGroup()
         			
         				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
         					.addComponent(lb3)
         					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         					.addComponent(sliderAlpha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
         				.addGap(40)
         				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
         						.addComponent(lb4)
         						.addComponent(sliderBeta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
         				.addGap(40)
         				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
         						.addComponent(lb5)
         						.addComponent(sliderGamma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
         				.addGap(40)
         				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
         						.addComponent(lb6)
         						.addComponent(sliderA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
         				.addGap(40)
         				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
         						.addComponent(lb7)
         						.addComponent(sliderB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
         				.addGap(40)))
         			.addContainerGap(47, Short.MAX_VALUE))
         );
         frame.getContentPane().setLayout(groupLayout);
        
        
         frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
	 
	 
	 public static JSlider init(JSlider slider, int initValue, int max) {
		slider = new JSlider();
		if(max == 100)
			slider.setMinorTickSpacing(10);
		else
			slider.setMinorTickSpacing(50);
 		//slider.setPaintLabels(true);
 		slider.setPaintTicks(true);
 		if(max == 100)
 			slider.setMajorTickSpacing(20);
 		else
 			slider.setMajorTickSpacing(100);
 		slider.setMaximum(max);
 		slider.setValue(initValue);

 		return slider;
	 }
	 
	 public static void addChangeListenerFloat(JSlider slider, JTextField textField, BufferedImage img1) {
		 slider.addChangeListener(new ChangeListener(){
	          @Override
	          public void stateChanged(ChangeEvent e) {
	          	textField.setText(String.format("%.1f", slider.getValue()/10.0));
	          	
	        	BufferedImage result = PointOperator.PointProcess(img1, sliderAlpha.getValue()/10.0, sliderBeta.getValue()/10.0, sliderGamma.getValue()/10.0, sliderA.getValue(), sliderB.getValue());
					ImageIcon iconUpdate = new ImageIcon(result);
					lb2.setIcon(iconUpdate);
					chartPanel = drawHistogram(img1);
					ImageIcon iconChartUpdate = new ImageIcon(chartPanel);
					lbChart.setIcon(iconChartUpdate);
					

					hist2 = drawHistogramImage(result, 2);
					ImageIcon histogramUpdate = new ImageIcon(hist2);
					lbHistogram2.setIcon(histogramUpdate);

					frame.repaint();
	          }
	      });
		  
		  textField.addKeyListener(new KeyAdapter(){
	          @Override
	          public void keyReleased(KeyEvent ke) {
	              String typed =  textField.getText();
	              slider.setValue(0);
	              if(!typed.matches("\\d+") || typed.length() > 3) {
	                  return;
	              }
	              double value = Double.parseDouble(typed);
	              slider.setValue((int) Math.round(value));
	          
					BufferedImage result = PointOperator.PointProcess(img1, sliderAlpha.getValue()/10.0, sliderBeta.getValue()/10.0, sliderGamma.getValue()/10.0, sliderA.getValue(), sliderB.getValue());
					ImageIcon iconUpdate = new ImageIcon(result);
					lb2.setIcon(iconUpdate);
					

					hist2 = drawHistogramImage(result, 2);
					ImageIcon histogramUpdate = new ImageIcon(hist2);
					lbHistogram2.setIcon(histogramUpdate);
					frame.repaint();
	          }
	      });
		 
	 }
	 
	 public static void addChangeListener(JSlider slider, JTextField textField, BufferedImage img1) {
		 slider.addChangeListener(new ChangeListener(){
	          @Override
	          public void stateChanged(ChangeEvent e) {
	          	textField.setText(String.valueOf(slider.getValue()));
	          	
	        		BufferedImage result = PointOperator.PointProcess(img1, sliderAlpha.getValue()/10.0, sliderBeta.getValue()/10.0, sliderGamma.getValue()/10.0, sliderA.getValue(), sliderB.getValue());
					ImageIcon iconUpdate = new ImageIcon(result);
					lb2.setIcon(iconUpdate);
					
					chartPanel = drawHistogram(img1);
					ImageIcon iconChartUpdate = new ImageIcon(chartPanel);
					lbChart.setIcon(iconChartUpdate);
					
					hist2 = drawHistogramImage(result, 2);
					ImageIcon histogramUpdate = new ImageIcon(hist2);
					lbHistogram2.setIcon(histogramUpdate);

					frame.repaint();
	          }
	      });
		  
		  textField.addKeyListener(new KeyAdapter(){
	          @Override
	          public void keyReleased(KeyEvent ke) {
	              String typed =  textField.getText();
	              slider.setValue(0);
	              if(!typed.matches("\\d+") || typed.length() > 3) {
	                  return;
	              }
	              int value = Integer.parseInt(typed);
	              slider.setValue(value);
	          
					BufferedImage result = PointOperator.PointProcess(img1,sliderAlpha.getValue()/10.0, sliderBeta.getValue()/10.0, sliderGamma.getValue()/10.0, sliderA.getValue(), sliderB.getValue());
					ImageIcon iconUpdate = new ImageIcon(result);
	
					lb2.setIcon(iconUpdate);
					

					hist2 = drawHistogramImage(result, 2);
					ImageIcon histogramUpdate = new ImageIcon(hist2);
					lbHistogram2.setIcon(histogramUpdate);
					
					frame.repaint();
	          }
	      });
		 
	 }
	 
	 public static BufferedImage drawHistogram(BufferedImage img1) {
		  double alpha = sliderAlpha.getValue()/10.0;
		  double beta = sliderBeta.getValue()/10.0;
		  double gamma = sliderGamma.getValue()/10.0;
		  
		  int a = sliderA.getValue();
		  int b = sliderB.getValue();
		  
		  
		  XYSeries datasetValue = new XYSeries("Value");
		  for(int u = 0; u < 255; u++) {
        	 double v = 0;
        	 double va = alpha*a;
        	 double vb = beta*(b-a) + va;
        	 if(0 <= u && u <= a) {
					v = alpha*u;
				}
        	 else if(u > a && u <= b) {
					v = beta*(u - a) + va;
				}
        	 else if(u > b && u < 255) {
					v = gamma*(u - b) + vb;
				}
        	 if(v > 255) {
					v = 255;
				}
			if(v < 0) {
					v = 0;
				}
			
			datasetValue.add(u, (int) Math.round(v));
 
         }
         
         XYSeriesCollection dataset = new XYSeriesCollection();     
         dataset.addSeries(datasetValue);
         JFreeChart xylineChart = ChartFactory.createXYLineChart(
                 "Curve",
                 "" ,
                 "" ,
                 dataset ,
                 PlotOrientation.VERTICAL ,
                 true , true , false);  
        
        BufferedImage chartImage = xylineChart.createBufferedImage(img1.getWidth(), img1.getHeight());
        return chartImage;
         
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

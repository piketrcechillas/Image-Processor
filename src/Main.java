import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.UnsupportedLookAndFeelException;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		//File imgFile = new File("D:/testFolder/p2.bmp");
		//BufferedImage img1 = ImageIO.read(imgFile);
		//float i = (float) 1/9;
		//float[][] mat = {{0, -1, 0}, {-1, 5 ,-1}, {0, -1, 0}};
		//BufferedImage img2 = PointOperator.PointProcess(img1, 2.0, 2.0, 2.0, 50, 100);
		//BufferedImage img2 = MedianFilter.MedianProcess(img1, 3, 3);2
		//BufferedImage img2 = MinimumFilter.MinimumProcess(img1, 3, 3);
		//BufferedImage img2 = MaximumFilter.MaximumProcess(img1, 3, 3);
		//BufferedImage img2 = CombinedFilter.OpeningProcess(img1, 3, 3);
		//BufferedImage img2 = CombinedFilter.ClosingProcess(img1, 3, 3);
		//IOPointOperator.displayPointOperator(img1, img2);
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseMode window = new ChooseMode();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}

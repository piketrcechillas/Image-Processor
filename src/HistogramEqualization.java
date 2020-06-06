import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
 

public class HistogramEqualization {
	
	private static float scale = (float) 255;
	
	public static void setScaleFactor(float num) {
		scale = num;
	}
	
    public static BufferedImage process(BufferedImage im){
        return processImage(im);
    }

    private static BufferedImage processImage(BufferedImage inImage) {
        int red;
        int green;
        int blue;
        int alpha;
        int newPixel = 0;
 
        ArrayList<int[]> histogramTable = HistogramEqualization.getHistogramTable(inImage);
 
        BufferedImage histogramEQ = new BufferedImage(inImage.getWidth(), inImage.getHeight(), inImage.getType());
 
        for(int i=0; i<inImage.getWidth(); i++) {
            for(int j=0; j<inImage.getHeight(); j++) {
 
                alpha = new Color(inImage.getRGB (i, j)).getAlpha();
                red = new Color(inImage.getRGB (i, j)).getRed();
                green = new Color(inImage.getRGB (i, j)).getGreen();
                blue = new Color(inImage.getRGB (i, j)).getBlue();
                
                red = histogramTable.get(0)[red];
                green = histogramTable.get(1)[green];
                blue = histogramTable.get(2)[blue];
                
                newPixel = HistogramEqualization.colorToRGB(alpha, red, green, blue);
                
                histogramEQ.setRGB(i, j, newPixel);
 
            }
        }
 
        return histogramEQ;
 
    }

    private static ArrayList<int[]> getHistogramTable(BufferedImage input) {

        ArrayList<int[]> imageHist = imageHistogram(input);

        ArrayList<int[]> imageArray = new ArrayList<int[]>();
 
        int[] redH = new int[256];
        int[] greenH = new int[256];
        int[] blueH = new int[256];
 
        for(int i = 0; i < redH.length; i++)
        	redH[i] = 0;
        for(int i = 0; i < greenH.length; i++) 
        	greenH[i] = 0;
        for(int i = 0; i < blueH.length; i++) 
        	blueH[i] = 0;
 
        long redSum = 0;
        long greenSum = 0;
        long blueSum = 0;
 

        float scale_factor = (float) ((scale-1) / (input.getWidth() * input.getHeight()-1));
 
        for(int i=0; i<redH.length; i++) {
            redSum += imageHist.get(0)[i];
            int redValue = (int) (redSum * scale_factor);
            if(redValue > 255) {
                redH[i] = 255;
            }
            else redH[i] = redValue;
 
            greenSum += imageHist.get(1)[i];
            int greenValue = (int) (greenSum * scale_factor);
            if(greenValue > 255) {
                greenH[i] = 255;
            }
            else greenH[i] = greenValue;
 
            blueSum += imageHist.get(2)[i];
            int blueValue = (int) (blueSum * scale_factor);
            if(blueValue > 255) {
                blueH[i] = 255;
            }
            else blueH[i] = blueValue;
        }
 
        imageArray.add(redH);
        imageArray.add(greenH);
        imageArray.add(blueH);
 
        return imageArray;
 
    }
 
    public static ArrayList<int[]> imageHistogram(BufferedImage input) {
 
        int[] redH = new int[256];
        int[] greenH = new int[256];
        int[] blueH = new int[256];
 
        for(int i = 0; i < redH.length; i++) {
        	redH[i] = 0;
        }
        for(int i = 0; i < greenH.length; i++) {
        	greenH[i] = 0;
        }
        for(int i = 0; i < blueH.length; i++) {
        	blueH[i] = 0;
        }
 
        for(int i = 0; i < input.getWidth(); i++) {
            for(int j = 0; j < input.getHeight(); j++) {
 
                int red = new Color(input.getRGB (i, j)).getRed();
                int green = new Color(input.getRGB (i, j)).getGreen();
                int blue = new Color(input.getRGB (i, j)).getBlue();
 
                redH[red]++; 
                greenH[green]++; 
                blueH[blue]++;
 
            }
        }
 
        ArrayList<int[]> hist = new ArrayList<int[]>();
        hist.add(redH);
        hist.add(greenH);
        hist.add(blueH);
 
        return hist;
 
    }
 
    private static int colorToRGB(int alpha, int red, int green, int blue) {
 
        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red;
        newPixel = newPixel << 8;
        newPixel += green;
        newPixel = newPixel << 8;
        newPixel += blue;
 
        return newPixel;
 
    }
 
}
import java.awt.Color;
import java.awt.image.BufferedImage;

public class PointOperator {
	public static BufferedImage PointProcess(BufferedImage img, double alpha, double beta, double gamma, int a, int b) {
		int height = img.getHeight();
		int width = img.getWidth();
		int[][] imgArray = getArray(img);

		BufferedImage processedImage = new BufferedImage(width, height, img.getType());
		int[][] imgArray2 = new int[width][height];
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				double u = imgArray[i][j];
				double va = alpha*a;
				double vb = beta*(b-a) + va;
				if(0 <= u && u <= a) {
					u = alpha*u;
					
				}
				else if(u > a && u <= b) {
					u = beta*(u - a) + va;
				}
				else if(u > b && u < 255) {
					u = gamma*(u - b) + vb;
				}
				
				if(u > 255) {
					u = 255;
				}
				if(u < 0) {
					u = 0;
				}
				
				imgArray2[i][j] = (int) Math.round(u);
			}
		}
		
		
		for(int i = 0; i < img.getWidth(); i++) {
            for(int j = 0; j < img.getHeight(); j++) {
            	int R = imgArray2[i][j];
            	int newPixel = colorToRGB(255, R, R, R);
            	processedImage.setRGB(i, j, newPixel);
            }
        }
		
		return processedImage;
	}
	
	
	public static int[][] getArray(BufferedImage input) {
		int height = input.getHeight();
		int width = input.getWidth();
		 int[][]  arr = new int[width][height];
		 for(int i = 0; i < width; i++) {
			 for(int j = 0; j < height; j++) {
	        	arr[i][j] = 0;
			 }
	        }
		 
		 for(int i = 0; i < input.getWidth(); i++) {
	            for(int j = 0; j < input.getHeight(); j++) {
	 
	                arr[i][j] = new Color(input.getRGB (i, j)).getRed();
	            }
	        }
			
		 return arr;
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

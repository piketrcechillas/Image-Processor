import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class PointOperator {
	
	
	
	public static BufferedImage PointProcess(BufferedImage img, double alpha, double beta, double gamma, int a, int b) {
		int height = img.getHeight();
		int width = img.getWidth();
		int[][] imgArray = getArray(img);
		double va = alpha*a;
		double vb = beta*(b-a) + va;
		//System.out.println("Value array: " + alpha + " " + beta + " " + gamma + " " + a + " " + b + " " + va + " " + vb);

		BufferedImage processedImage = new BufferedImage(width, height, img.getType());
		int[][] imgArray2 = new int[width][height];
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				int u = imgArray[i][j];
				double v = 0;
				
				if(0 <= u && u <= a) {
					v = alpha*u;
					
				}
				else if(u > a && u <= b) {
					v = beta*(u - a) + va;
				}
				else if(u > b && u <= 255) {
					v = gamma*(u - b) + vb;
				}
				
				if(v > 255) {
					v = 255;
				}
				if(v < 0) {
					v = 0;
				}
				//System.out.println(v);

					//System.out.println(u);
				imgArray2[i][j] = (int) Math.round(v);
			}
		}
		
		
		processedImage = rasterize(width, height, imgArray2);
		
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
	            	
	            		 Raster raster = input.getRaster();
	            	 
	            	  arr[i][j] = raster.getSample(i, j, 0);
	            }
	        }
			
		 return arr;
	}
	
	private static BufferedImage rasterize(int width, int height, int[][] arr) {
		int[] matrix = new int[width * height * 3];
		 for(int i = 0; i < width; i++) {
	            for(int j = 0; j < height; j++) {
	            	 for (int band = 0; band < 3; band++)
	                     matrix[((i * height) + j)*3 + band] = arr[i][j];
	            }
	      }
		 
		 BufferedImage image =
			        new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			    WritableRaster raster = (WritableRaster) image.getData();
			    raster.setPixels(0, 0, width, height, matrix);
			    image.setData(raster);
			    return image;
	
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

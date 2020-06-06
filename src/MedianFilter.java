import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianFilter {
	public static BufferedImage MedianProcess(BufferedImage img, int r, int l) {
		int width = img.getWidth();
		int height = img.getHeight();
		int[][] imgArray = getArray(img);
		int[][] imgArray2 = new int[width][height];
		System.out.println("Medfilter");
		int r0 = (int) Math.floor(r/2);
		int l0 = (int) Math.floor(l/2);
		BufferedImage processedImage = new BufferedImage(width, height, img.getType());
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				List<Float> arr = new ArrayList<>();
				float v = 0;
				for(int m = 0; m < r; m++) {
					for(int n = 0; n < l; n++) {
						if(i-m+r0 >= width || i-m+r0 < 0 || j-n+l0 >= height || j-n+l0 <0) {
							v = 0;
						}
						else {
							v = imgArray[i-m+r0][j-n+l0];
						}
						
						arr.add(v);
						
					}
				}
				Collections.sort(arr);	
				
		        imgArray2[i][j] = Math.round(arr.get((int) Math.floor((r*l/2))));
		            
		        
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
	
	private static int[][] getArray(BufferedImage input) {
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

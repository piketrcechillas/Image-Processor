import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LinearFilter {
	public static BufferedImage linearProcess(BufferedImage img, float[][] filter) {
		int height = img.getHeight();
		int width = img.getWidth();
		int[][] imgArray = getArray(img);
		
		int r = filter[0].length;
		int l = filter[1].length;
		int r0 = (int) Math.floor(r/2);
		int l0 = (int) Math.floor(l/2);
		BufferedImage processedImage = new BufferedImage(width, height, img.getType());
		int[][] imgArray2 = new int[width][height];
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				float v = 0;
				float s = 0;
				for(int m = 0; m < r; m++) {
					for(int n = 0; n < l; n++) {
						if(i-m+r0 >= width || i-m+r0 < 0 || j-n+l0 >= height || j-n+l0 <0) {
							v = 0;
						}
						else {
							v = imgArray[i-m+r0][j-n+l0];
						}
						
						s = s + filter[m][n] * v;
						
					}
				}
				
				if(s>255) {
					s = 255;
				}
				if(s<0) {
					s = 0;
				}
				
				imgArray2[i][j] = (int) s;
				
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
	 
	 public static float[][] parse(File file) throws FileNotFoundException {
		 Scanner sc = new Scanner(new BufferedReader(new FileReader(file)));
		 int size = Integer.parseInt(sc.nextLine());
		 float[][] arr = new float[size][size];
		 while(sc.hasNextLine()) {
	         for (int i=0; i<size; i++) {
	            String[] line = sc.nextLine().split(" ");
	            for (int j=0; j<line.length; j++) {
	               arr[i][j] = Float.parseFloat(line[j]);
	            }
	         }
	      }
		 sc.close();
		 return arr;
		 
	 }

}

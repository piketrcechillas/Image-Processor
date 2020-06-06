package codeResize;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageResizer {
    public static BufferedImage resize(BufferedImage inputImage ,int scaleW, int scaleH) throws IOException {
        //input image

        //output image
        BufferedImage outputImage = new BufferedImage(scaleW,scaleH,inputImage.getType());

        //scale input to output Image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage,0,0,scaleW, scaleH, null);
        g2d.dispose();
        
        return outputImage;

    }

    public static BufferedImage resize(BufferedImage inputImage, double percent) throws IOException {

        int scaledWidth = (int) (inputImage.getWidth() * percent);
        int scaledHeight = (int) (inputImage.getHeight() * percent);
        BufferedImage output = resize(inputImage, scaledWidth, scaledHeight);
        return output;
        
    }
}

package codeResize;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class simpleEdit {

    private static JLabel imageLabel;
    private static JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel panel = new JPanel();

                imageLabel = new JLabel(new ImageIcon(createImage()));//set image of JLabel

                panel.add(imageLabel);

                frame.add(panel);

                frame.pack();
                frame.setVisible(true);

                startImageChangeTimer();//creates a timer which will rotate image after 5 seconds
            }

            private void startImageChangeTimer() {
                Timer timer = new Timer(1000, new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //get JLabel Icon and convert to BufferedImage
                        BufferedImage img = getBufferedImageOfIcon(imageLabel.getIcon(), imageLabel.getWidth(), imageLabel.getHeight());
                        BufferedImage image = getBufferedImageOfIcon(imageLabel.getIcon(), imageLabel.getWidth(), imageLabel.getHeight());
                        //rotate the image
                        img = rotateImage(img, -45);
                        //change the labels image
                        image=cropImage(image,0,0,image.getWidth(),image.getHeight());
                        //crop image
                        imageLabel.setIcon(new ImageIcon(img));

                        frame.pack();//resize frame accrodingly
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        });
    }

    public static BufferedImage createImage() {
        File image=new File("D:\\Document\\Ky 20192\\Do an\\Design\\label.jpeg");
        BufferedImage img = new BufferedImage(100, 50, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, img.getWidth(), img.getHeight());
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Calibri", Font.BOLD, 20));
        FontMetrics fm = g2d.getFontMetrics();
        String text = "Hello world";
        int textWidth = fm.stringWidth(text);
        g2d.drawString(text, (img.getWidth() / 2) - textWidth / 2, img.getHeight() / 2);
        g2d.dispose();
        return img;
    }

    public static BufferedImage getBufferedImageOfIcon(Icon icon, int imgW, int imgH) {
        BufferedImage img = new BufferedImage(imgW, imgH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) img.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        icon.paintIcon(null, g2d, 0, 0);
        g2d.dispose();
        return img;
    }

    public static BufferedImage rotateImage(BufferedImage image, double angle) {
        double sin = Math.abs(Math.sin(angle));
        double cos = Math.abs(Math.cos(angle));
        int originalWidth = image.getWidth();
        int originalHeight = image.getHeight();
        int newWidth = (int) Math.floor(originalWidth * cos + originalHeight * sin);
        int newHeight = (int) Math.floor(originalHeight * cos + originalWidth * sin);
        BufferedImage rotatedBI = new BufferedImage(newWidth, newHeight, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = rotatedBI.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.translate((newWidth - originalWidth) / 2, (newHeight - originalHeight) / 2);
        g2d.rotate(angle, originalWidth / 2, originalHeight / 2);
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
        return rotatedBI;
    }

    public static BufferedImage cropImage(BufferedImage bufferedImage, int x, int y, int width, int height){
        BufferedImage croppedImage = bufferedImage.getSubimage(x, y, width, height);
//
        return croppedImage;
    }

}
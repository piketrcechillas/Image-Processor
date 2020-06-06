package codeResize;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CropImage extends JFrame implements MouseListener, MouseMotionListener {
    /**
	 * 
	 */
	private JLabel lb = new JLabel();
	private static final long serialVersionUID = 1L;
	int drag_status = 0, c1, c2, c3, c4;


    public void start(String file){
        ImagePanel image=new ImagePanel(file);
        add(image);
        setSize(image.getWidth()*3,image.getHeight()*3);
        setVisible(true);
        addMouseListener(this);
        addMouseMotionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void draggedScreen() throws AWTException, IOException {
        int w=c1-c3;
        int h=c2-c4;
        w=w*-1;
        h=h*-1;
        Robot robot=new Robot();
        BufferedImage img=robot.createScreenCapture(new Rectangle(c1,c2,w,h));
        ImageIcon imgIcon = new ImageIcon(img);
        lb.setIcon(imgIcon);
        add(lb, BorderLayout.EAST);
        repaint();
        File savePath=new File("screen1.jpg");
        ImageIO.write(img,"JPG", savePath);
        System.out.println("Cropped image saved!");

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        repaint();
        c1=e.getX();
        c2=e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        repaint();
        if(drag_status==1){
            c3=e.getX();
            c4=e.getY();
            try{
                draggedScreen();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        repaint();
        drag_status=1;
        c3=e.getX();
        c4=e.getY();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    public void paint(Graphics g){
        super.paint(g);
        int w=c1-c3;
        int h= c2-c4;
        w=w*-1;
        h=h*-1;
        if (w<0){
            w=w*-1;
        }

        g.drawRect(c1,c2,w,h);
    }


}




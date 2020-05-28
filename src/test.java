import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class test extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private static BufferedImage image = null;
	/**
	 * @wbp.nonvisual location=294,204
	 */
	

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public test(int index) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		UIManager.setLookAndFeel(lookAndFeel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Please choose JPG file");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		JButton btnNewButton = new JButton("Choose file...");
		if(index==1)
			btnNewButton.addActionListener(new PointOperatorAL());
		else if(index==2)
			btnNewButton.addActionListener(new LinearFilterAL());
		else if(index==3)
			btnNewButton.addActionListener(new MedianFilterAL());
		else if(index==4)
			btnNewButton.addActionListener(new MaximumFilterAL());
		else if(index==5)
			btnNewButton.addActionListener(new MinimumFilterAL());
		else if(index==6)
			btnNewButton.addActionListener(new OpeningFilterAL());
		else if(index==5)
			btnNewButton.addActionListener(new ClosingFilterAL());
		else if(index==8)
			btnNewButton.addActionListener(new HistogramEQFilterAL());
		

		JButton btnBackToChoosing = new JButton("Back to Choosing Mode");
		btnBackToChoosing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					ChooseMode window = new ChooseMode();
					window.setVisible(true);
					
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
					.addGap(144))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addComponent(lblNewJgoodiesLabel, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(192, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBackToChoosing, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(144, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addComponent(lblNewJgoodiesLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBackToChoosing)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		
		contentPane.setLayout(gl_contentPane);
	}
	
	  class LinearFilterAL implements ActionListener  {
		    public void actionPerformed(ActionEvent e) {
		    	FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
		    		    "Image files", ImageIO.getReaderFileSuffixes());
		    	JFileChooser c = new JFileChooser("D:\\testFolder");
		    	c.addChoosableFileFilter(imageFilter);
		    	c.setAcceptAllFileFilterUsed(false);
		    	c.setDialogTitle("Choose Image File");
		    	int rVal = c.showOpenDialog(test.this);
		    	if (rVal == JFileChooser.APPROVE_OPTION) {
		    		
		    		try {
		    			dispose();
						image = ImageIO.read(c.getSelectedFile());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		JFileChooser c2 = new JFileChooser("D:\\testFolder\\mat");
		    		c2.setDialogTitle("Choose filter file");
		    		FileNameExtensionFilter txtFilter = new FileNameExtensionFilter(
			    		    "Text File", "txt");
		    		c2.setFileFilter(txtFilter);
		    		c2.setAcceptAllFileFilterUsed(false);
		    		int rValtxt = c2.showOpenDialog(test.this);
		    		if (rValtxt == JFileChooser.APPROVE_OPTION) {
		    			float[][] mat = null;
			    		dispose();
						try {
							mat = LinearFilter.parse(c2.getSelectedFile());
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
			    		
						
						BufferedImage result = LinearFilter.linearProcess(image, mat);
						try {
							IOGeneral.displayImage(image, result);
						} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
								| UnsupportedLookAndFeelException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
		    		}
		    		if (rValtxt == JFileChooser.CANCEL_OPTION) {
		    			dispose();
			    	}
		    	}
		    	if (rVal == JFileChooser.CANCEL_OPTION) {
		    	}
		    }
		  }
	  
	  class PointOperatorAL implements ActionListener  {
		    public void actionPerformed(ActionEvent e) {
		    	FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
		    		    "Image files", ImageIO.getReaderFileSuffixes());
		    	JFileChooser c = new JFileChooser("D:\\testFolder");
		    	c.addChoosableFileFilter(imageFilter);
		    	c.setAcceptAllFileFilterUsed(false);
		    	int rVal = c.showOpenDialog(test.this);
		    	if (rVal == JFileChooser.APPROVE_OPTION) {
		    		
		    		try {
		    			dispose();
						image = ImageIO.read(c.getSelectedFile());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
		    		BufferedImage img2 = PointOperator.PointProcess(image, 0.0, 2.0, 0.0, 90, 140);
		    		try {
						IOPointOperator.displayPointOperator(image, img2);
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
		    	if (rVal == JFileChooser.CANCEL_OPTION) {
		    	}
		    }
		  }
	  
	  class MedianFilterAL implements ActionListener  {
		    public void actionPerformed(ActionEvent e) {
		    	FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
		    		    "Image files", ImageIO.getReaderFileSuffixes());
		    	JFileChooser c = new JFileChooser("D:\\testFolder");
		    	c.addChoosableFileFilter(imageFilter);
		    	c.setAcceptAllFileFilterUsed(false);
		    	int rVal = c.showOpenDialog(test.this);
		    	if (rVal == JFileChooser.APPROVE_OPTION) {
		    		
		    		try {
		    			dispose();
						image = ImageIO.read(c.getSelectedFile());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
		    		BufferedImage img2 = MedianFilter.MedianProcess(image, 3, 3);
		    		try {
						IONonlinearFilter.displayImage(image, img2, 3);
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
		    	if (rVal == JFileChooser.CANCEL_OPTION) {
		    	}
		    }
		  }
	  
	  class MaximumFilterAL implements ActionListener  {
		    public void actionPerformed(ActionEvent e) {
		    	FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
		    		    "Image files", ImageIO.getReaderFileSuffixes());
		    	JFileChooser c = new JFileChooser("D:\\testFolder");
		    	c.addChoosableFileFilter(imageFilter);
		    	c.setAcceptAllFileFilterUsed(false);
		    	int rVal = c.showOpenDialog(test.this);
		    	if (rVal == JFileChooser.APPROVE_OPTION) {
		    		
		    		try {
		    			dispose();
						image = ImageIO.read(c.getSelectedFile());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
		    		BufferedImage img2 = MaximumFilter.MaximumProcess(image, 3, 3);
		    		try {
						IONonlinearFilter.displayImage(image, img2, 4);
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
		    	if (rVal == JFileChooser.CANCEL_OPTION) {
		    	}
		    }
		  }
	  
	  class MinimumFilterAL implements ActionListener  {
		    public void actionPerformed(ActionEvent e) {
		    	FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
		    		    "Image files", ImageIO.getReaderFileSuffixes());
		    	JFileChooser c = new JFileChooser("D:\\testFolder");
		    	c.addChoosableFileFilter(imageFilter);
		    	c.setAcceptAllFileFilterUsed(false);
		    	int rVal = c.showOpenDialog(test.this);
		    	if (rVal == JFileChooser.APPROVE_OPTION) {
		    		
		    		try {
		    			dispose();
						image = ImageIO.read(c.getSelectedFile());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
		    		BufferedImage img2 = MinimumFilter.MinimumProcess(image, 3, 3);
		    		try {
						IONonlinearFilter.displayImage(image, img2, 5);
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
		    	if (rVal == JFileChooser.CANCEL_OPTION) {
		    	}
		    }
		  }
	  
	  class OpeningFilterAL implements ActionListener  {
		    public void actionPerformed(ActionEvent e) {
		    	FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
		    		    "Image files", ImageIO.getReaderFileSuffixes());
		    	JFileChooser c = new JFileChooser("D:\\testFolder");
		    	c.addChoosableFileFilter(imageFilter);
		    	c.setAcceptAllFileFilterUsed(false);
		    	int rVal = c.showOpenDialog(test.this);
		    	if (rVal == JFileChooser.APPROVE_OPTION) {
		    		
		    		try {
		    			dispose();
						image = ImageIO.read(c.getSelectedFile());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
		    		BufferedImage img2 = CombinedFilter.OpeningProcess(image, 3, 3);
		    		try {
						IONonlinearFilter.displayImage(image, img2, 6);
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
		    	if (rVal == JFileChooser.CANCEL_OPTION) {
		    	}
		    }
		  }
	  
	  class ClosingFilterAL implements ActionListener  {
		    public void actionPerformed(ActionEvent e) {
		    	FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
		    		    "Image files", ImageIO.getReaderFileSuffixes());
		    	JFileChooser c = new JFileChooser("D:\\testFolder");
		    	c.addChoosableFileFilter(imageFilter);
		    	c.setAcceptAllFileFilterUsed(false);
		    	int rVal = c.showOpenDialog(test.this);
		    	if (rVal == JFileChooser.APPROVE_OPTION) {
		    		
		    		try {
		    			dispose();
						image = ImageIO.read(c.getSelectedFile());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
		    		BufferedImage img2 = CombinedFilter.ClosingProcess(image, 3, 3);
		    		try {
						IONonlinearFilter.displayImage(image, img2, 7);
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
		    	if (rVal == JFileChooser.CANCEL_OPTION) {
		    	}
		    }
		  }
	  
	  class HistogramEQFilterAL implements ActionListener  {
		    public void actionPerformed(ActionEvent e) {
		    	FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
		    		    "Image files", ImageIO.getReaderFileSuffixes());
		    	JFileChooser c = new JFileChooser("D:\\testFolder");
		    	c.addChoosableFileFilter(imageFilter);
		    	c.setAcceptAllFileFilterUsed(false);
		    	int rVal = c.showOpenDialog(test.this);
		    	if (rVal == JFileChooser.APPROVE_OPTION) {
		    		
		    		try {
		    			dispose();
						image = ImageIO.read(c.getSelectedFile());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
		    		BufferedImage img2 = HistogramEqualization.process(image);
		    		try {
						IOGeneral.displayImage(image, img2);
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
		    	if (rVal == JFileChooser.CANCEL_OPTION) {
		    	}
		    }
		  }
	  
}

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class ChooseModeNew extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChooseModeNew(BufferedImage image) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		setTitle("Image Processor");
		System.out.println("Console!");
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		UIManager.setLookAndFeel(lookAndFeel);
		setBounds(100, 100, 452, 367);
		JButton btnNewButton = new JButton("Point Operator");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BufferedImage img2 = PointOperator.PointProcess(image, 0.0, 2.0, 0.0, 90, 140);
				try {
					IOPointOperator.displayPointOperator(image, img2);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnLinearFilter = new JButton("Linear Filter");
		btnLinearFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser c2 = new JFileChooser("D:\\testFolder\\mat");
	    		c2.setDialogTitle("Choose filter file");
	    		FileNameExtensionFilter txtFilter = new FileNameExtensionFilter(
		    		    "Text File", "txt");
	    		c2.setFileFilter(txtFilter);
	    		c2.setAcceptAllFileFilterUsed(false);
	    		int rValtxt = c2.showOpenDialog(ChooseModeNew.this);
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
		});
		
		JButton btnMedianFilter = new JButton("Median Filter");
		btnMedianFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BufferedImage img2 = MedianFilter.MedianProcess(image, 3, 3);
	    		try {
					IONonlinearFilter.displayImage(image, img2, 3);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnMaximumFilter = new JButton("Maximum Filter");
		btnMaximumFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BufferedImage img2 = MaximumFilter.MaximumProcess(image, 3, 3);
	    		try {
					IONonlinearFilter.displayImage(image, img2, 4);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnMinimumFilter = new JButton("Minimum Filter");
		btnMinimumFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BufferedImage img2 = MinimumFilter.MinimumProcess(image, 3, 3);
	    		try {
					IONonlinearFilter.displayImage(image, img2, 5);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnOpeningFilter = new JButton("Opening Filter");
		btnOpeningFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BufferedImage img2 = CombinedFilter.OpeningProcess(image, 3, 3);
	    		try {
					IONonlinearFilter.displayImage(image, img2, 6);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnClosingFilter = new JButton("Closing Filter");
		btnClosingFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedImage img2 = CombinedFilter.ClosingProcess(image, 3, 3);
	    		try {
					IONonlinearFilter.displayImage(image, img2, 7);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnHistogramEqualization = new JButton("Histogram Equalization");
		btnHistogramEqualization.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BufferedImage img2 = HistogramEqualization.process(image);
	    		try {
					IOGeneral.displayImage(image, img2);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblChooseYourMode = DefaultComponentFactory.getInstance().createTitle("Choose Processing Mode");
		lblChooseYourMode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
	
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(91, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnHistogramEqualization, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnClosingFilter, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOpeningFilter, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnMinimumFilter, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnMaximumFilter, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnMedianFilter, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLinearFilter, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
							.addGap(75))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblChooseYourMode)
							.addGap(102))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChooseYourMode)
					.addGap(19)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLinearFilter)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMedianFilter)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMaximumFilter)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMinimumFilter)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOpeningFilter)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnClosingFilter)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnHistogramEqualization)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JPanel;

public class ChooseMode extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChooseMode() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException {
		setTitle("Image Processor");
		System.out.println("Console!");
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		UIManager.setLookAndFeel(lookAndFeel);
		setBounds(100, 100, 925, 630);
		JButton btnNewButton = new JButton("Point Operator");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					test frame = new test(1);
					frame.setVisible(true);
					
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnLinearFilter = new JButton("Linear Filter");
		btnLinearFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					test frame = new test(2);
					frame.setVisible(true);
					
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnMedianFilter = new JButton("Median Filter");
		btnMedianFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					test frame = new test(3);
					frame.setVisible(true);
					
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnMaximumFilter = new JButton("Maximum Filter");
		btnMaximumFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					test frame = new test(4);
					frame.setVisible(true);
					
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnMinimumFilter = new JButton("Minimum Filter");
		btnMinimumFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					test frame = new test(5);
					frame.setVisible(true);
					
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnOpeningFilter = new JButton("Opening Filter");
		btnOpeningFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					test frame = new test(6);
					frame.setVisible(true);
					
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnClosingFilter = new JButton("Closing Filter");
		btnClosingFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					test frame = new test(7);
					frame.setVisible(true);
					
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnHistogramEqualization = new JButton("Histogram Equalization");
		btnHistogramEqualization.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					test frame = new test(8);
					frame.setVisible(true);
					
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnResize = new JButton("Resize Image");
		btnResize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					test frame = new test(9);
					frame.setVisible(true);
					
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		JLabel lblChooseYourMode = DefaultComponentFactory.getInstance().createTitle("Choose Processing Mode");
		lblChooseYourMode.setFont(new Font("Tahoma", Font.BOLD, 30));
		BufferedImage img = ImageIO.read(new File("img/tae.jpg"));
		JPanel panel = new JPanel();
		
		ImageIcon icon = new ImageIcon(img);
		JLabel label = new JLabel(icon);
		panel.add(label);
		
	
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnLinearFilter, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnClosingFilter, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnOpeningFilter, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnMedianFilter, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnHistogramEqualization, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnMaximumFilter, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnResize, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnMinimumFilter, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
					.addGap(18))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(258)
					.addComponent(lblChooseYourMode)
					.addContainerGap(275, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChooseYourMode)
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnOpeningFilter, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLinearFilter, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnClosingFilter, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnHistogramEqualization, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnMedianFilter, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnMaximumFilter, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnResize, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnMinimumFilter, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}

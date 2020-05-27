import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class ChooseMode extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChooseMode() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		setTitle("Image Processor");
		System.out.println("Console!");
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		UIManager.setLookAndFeel(lookAndFeel);
		setBounds(100, 100, 452, 367);
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
		btnLinearFilter.addActionListener(new ActionListener() {
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
		btnLinearFilter.addActionListener(new ActionListener() {
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

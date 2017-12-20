package edu.eurasia.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FunctionalFrame extends JFrame {
	public FunctionalFrame() {
		super();
		setTitle("功能选择");
		setResizable(false);
		setSize(540, 368);
		final JPanel panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel, BorderLayout.CENTER);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				new BooksTableFrame().setVisible(true);
				setVisible(false);
			}
		});
		button.setText("图书管理");
		button.setBounds(73, 223, 126, 49);
		panel.add(button);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				new CategoryTableFrame().setVisible(true);
				setVisible(false);
			}
		});
		button_1.setText("类别管理");
		button_1.setBounds(312, 223, 126, 49);
		panel.add(button_1);
	}

}

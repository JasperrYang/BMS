package edu.eurasia.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import edu.eurasia.entity.CategoryBean;
import edu.eurasia.service.CategoryService;
import edu.eurasia.service.impl.CategoryServiceImpl;
import edu.eurasia.untils.GeneralMessage;

public class CategoryAddFrame extends JFrame {
	private JTextField textID;
	private JTextArea textMess;
	private JTextField textName;

	public CategoryAddFrame() {
		super();
		setSize(482, 327);
		setResizable(false);
		setTitle("图书类别添加");

		final JPanel panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel, BorderLayout.CENTER);

		final JLabel label = new JLabel();
		label.setText("图书类别名称：");
		label.setBounds(65, 85, 95, 18);
		panel.add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("图书类别描述：");
		label_1.setBounds(67, 139, 95, 18);
		panel.add(label_1);

		textName = new JTextField();
		textName.setBounds(217, 83, 130, 22);
		panel.add(textName);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {

				CategoryBean catebean = new CategoryBean();
				if (textID.getText() == null || textID.getText().equals("")) {
					JOptionPane.showMessageDialog(null, GeneralMessage.ADD_NUM);
				} else {
					catebean.setCID(Integer.parseInt(textID.getText()));
					catebean.setCNAME(textName.getText());
					catebean.setCMESSAGE(textMess.getText());
				}
				CategoryService cs = new CategoryServiceImpl();
				try {
					cs.addCate(catebean);
					JOptionPane.showMessageDialog(null, GeneralMessage.ADD_SUCCESS);
					setVisible(false);
					new CategoryTableFrame().setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, GeneralMessage.ADD_FAILURE + e1.getMessage());
				}

			}
		});
		button.setText("添加");
		button.setBounds(71, 260, 106, 28);
		panel.add(button);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				new CategoryTableFrame().setVisible(true);
				setVisible(false);
			}
		});
		button_1.setText("返回");
		button_1.setBounds(256, 260, 106, 28);
		panel.add(button_1);

		textMess = new JTextArea();
		textMess.setBounds(92, 171, 255, 71);
		panel.add(textMess);

		final JLabel label_2 = new JLabel();
		label_2.setText("序号");
		label_2.setBounds(65, 27, 66, 18);
		panel.add(label_2);

		textID = new JTextField();
		textID.setBounds(217, 25, 130, 22);
		panel.add(textID);
	}

}

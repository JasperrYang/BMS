package edu.eurasia.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;

import edu.eurasia.entity.BooksBean;
import edu.eurasia.service.BooksService;
import edu.eurasia.service.impl.BooksServiceImpl;
import edu.eurasia.untils.GeneralMessage;

public class BooksAddFrame extends JFrame {
	private JTextField textCate;
	private JTextArea textMess;
	private JTextField textAuth;
	private JTextField textName;
	private JTextField textPri;
	private JTextField textId;

	public BooksAddFrame() {
		super();
		setResizable(false);
		setSize(719, 415);
		setTitle("图书添加");

		final JPanel panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel, BorderLayout.CENTER);

		final JLabel label = new JLabel();
		label.setText("编号");
		label.setBounds(75, 38, 66, 18);
		panel.add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("图书名称");
		label_1.setBounds(337, 38, 66, 18);
		panel.add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setText("价格");
		label_2.setBounds(75, 111, 66, 18);
		panel.add(label_2);

		final JLabel label_3 = new JLabel();
		label_3.setText("作者");
		label_3.setBounds(337, 111, 66, 18);
		panel.add(label_3);

		final JLabel label_4 = new JLabel();
		label_4.setText("图书描述");
		label_4.setBounds(337, 196, 66, 18);
		panel.add(label_4);

		textId = new JTextField();
		textId.setBounds(147, 36, 137, 22);
		panel.add(textId);

		textPri = new JTextField();
		textPri.setBounds(147, 109, 137, 22);
		panel.add(textPri);

		textName = new JTextField();
		textName.setBounds(447, 36, 137, 22);
		panel.add(textName);

		textAuth = new JTextField();
		textAuth.setBounds(447, 109, 137, 22);
		panel.add(textAuth);

		textMess = new JTextArea();
		textMess.setBounds(447, 196, 229, 87);
		panel.add(textMess);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {

				BooksBean books = new BooksBean();
				if (textId.getText() == null || textId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, GeneralMessage.ADD_NUM);
				}
				if (textPri.getText() == null || textPri.getText().equals("")) {
					JOptionPane.showMessageDialog(null, GeneralMessage.ADD_PRICE);
				}
				if (textCate.getText() == null || textCate.getText().equals("")) {
					JOptionPane.showMessageDialog(null, GeneralMessage.ADD_NAME);
				} else {
					books.setBID(Integer.parseInt(textId.getText()));
					books.setBNAME(textName.getText());
					books.setBAUTHOR(textAuth.getText());
					books.setBPRICE(Double.parseDouble(textPri.getText()));
					books.setCATEGORYID(Integer.parseInt(textCate.getText()));
					books.setBMESSAGE(textMess.getText());
				}

				BooksService bookservice = new BooksServiceImpl();
				try {
					bookservice.addBooks(books);
					JOptionPane.showMessageDialog(null, GeneralMessage.ADD_SUCCESS);
					setVisible(false);
					new BooksTableFrame().setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, GeneralMessage.ADD_FAILURE + e1.getMessage());
				}
			}
		});
		button.setText("提交");
		button.setBounds(159, 332, 106, 28);
		panel.add(button);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				new BooksTableFrame().setVisible(true);
				setVisible(false);
			}
		});
		button_1.setText("返回");
		button_1.setBounds(447, 332, 106, 28);
		panel.add(button_1);

		final JLabel label_5 = new JLabel();
		label_5.setText("图书类别");
		label_5.setBounds(75, 196, 66, 18);
		panel.add(label_5);

		textCate = new JTextField();
		textCate.setBounds(147, 194, 137, 22);
		panel.add(textCate);
	}

}

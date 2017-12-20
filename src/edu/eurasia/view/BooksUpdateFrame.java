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
import javax.swing.table.DefaultTableModel;

import edu.eurasia.entity.BooksBean;
import edu.eurasia.service.BooksService;
import edu.eurasia.service.CategoryService;
import edu.eurasia.service.impl.BooksServiceImpl;
import edu.eurasia.service.impl.CategoryServiceImpl;
import edu.eurasia.untils.GeneralMessage;

public class BooksUpdateFrame extends JFrame {
	private JTextArea books_textMs;
	private JTextField books_textAuthor;
	private JTextField books_textName;
	private JTextField books_textLb;
	private JTextField books_textPrice;
	private JTextField books_textId;

	public BooksUpdateFrame(DefaultTableModel tm, int bID, String bNAME, String bAUTHOR, double bPRICE, String bMESSAGE,
			String cNAME, int index) {
		super();
		setTitle("图书编辑");
		setResizable(false);
		setSize(719, 415);

		final JPanel panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel, BorderLayout.CENTER);

		final JLabel label = new JLabel();
		label.setText("编号");
		label.setBounds(100, 64, 66, 18);
		panel.add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("图书名称");
		label_1.setBounds(377, 64, 66, 18);
		panel.add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setText("价格");
		label_2.setBounds(100, 137, 66, 18);
		panel.add(label_2);

		final JLabel label_3 = new JLabel();
		label_3.setText("作者");
		label_3.setBounds(377, 137, 66, 18);
		panel.add(label_3);

		final JLabel label_4 = new JLabel();
		label_4.setText("图书类别");
		label_4.setBounds(100, 227, 66, 18);
		panel.add(label_4);

		final JLabel label_5 = new JLabel();
		label_5.setText("图书描述");
		label_5.setBounds(377, 227, 66, 18);
		panel.add(label_5);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				// 获取文本信息
				BooksBean booksbean = new BooksBean();
				BooksService bs = new BooksServiceImpl();

				if (books_textPrice.getText() == null || books_textPrice.getText().equals("")) {
					JOptionPane.showMessageDialog(null, GeneralMessage.ADD_PRICE);
				} else {
					booksbean.setBID(Integer.parseInt(books_textId.getText()));
					booksbean.setBNAME(books_textName.getText());
					booksbean.setBAUTHOR(books_textAuthor.getText());
					booksbean.setBMESSAGE(books_textMs.getText());
					booksbean.setBPRICE(Double.parseDouble(books_textPrice.getText()));
				}

				try {
					bs.editBooks(booksbean);
					JOptionPane.showMessageDialog(null, GeneralMessage.UPDATE_SUCCESS);
					setVisible(false);
					new BooksTableFrame().setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, GeneralMessage.UPDATE_FAILURE + e.getMessage());
				}
			}
		});
		button.setText("提交");
		button.setBounds(153, 333, 106, 28);
		panel.add(button);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				new BooksTableFrame().setVisible(true);
				setVisible(false);
			}
		});
		button_1.setText("返回");
		button_1.setBounds(417, 333, 106, 28);
		panel.add(button_1);

		books_textId = new JTextField();
		books_textId.setEditable(false);
		books_textId.setBounds(172, 62, 114, 22);
		panel.add(books_textId);

		books_textPrice = new JTextField();
		books_textPrice.setBounds(172, 135, 114, 22);
		panel.add(books_textPrice);

		books_textLb = new JTextField();
		books_textLb.setEditable(false);
		books_textLb.setBounds(172, 225, 114, 22);
		panel.add(books_textLb);

		books_textName = new JTextField();
		books_textName.setBounds(489, 62, 127, 22);
		panel.add(books_textName);

		books_textAuthor = new JTextField();
		books_textAuthor.setBounds(489, 135, 127, 22);
		panel.add(books_textAuthor);

		books_textMs = new JTextArea();
		books_textMs.setBounds(489, 227, 173, 94);
		panel.add(books_textMs);

		books_textId.setText(String.valueOf(bID));
		books_textName.setText(bNAME);
		books_textAuthor.setText(bAUTHOR);
		books_textPrice.setText(String.valueOf(bPRICE));
		books_textMs.setText(cNAME);
		books_textLb.setText(bMESSAGE);
	}

}

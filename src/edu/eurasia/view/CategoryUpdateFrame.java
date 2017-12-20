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
import javax.swing.table.DefaultTableModel;

import edu.eurasia.entity.CategoryBean;
import edu.eurasia.service.CategoryService;
import edu.eurasia.service.impl.CategoryServiceImpl;
import edu.eurasia.untils.GeneralMessage;

public class CategoryUpdateFrame extends JFrame {
	private JTextArea text_cmess;
	private JTextField text_cname;
	private JTextField text_cid;

	public CategoryUpdateFrame(DefaultTableModel tm, String cID, String cNAME, String cMESSAGE, int index) {
		super();
		setSize(528, 378);
		setTitle("图书类别修改");
		setResizable(false);

		final JPanel panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel, BorderLayout.CENTER);

		final JLabel label = new JLabel();
		label.setText("编号：");
		label.setBounds(93, 37, 66, 18);
		panel.add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("图书类别名称：");
		label_1.setBounds(93, 99, 106, 18);
		panel.add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setText("图书类别描述：");
		label_2.setBounds(93, 154, 106, 18);
		panel.add(label_2);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {

				CategoryService cs = new CategoryServiceImpl();
				CategoryBean cate = new CategoryBean();

				cate.setCID(Integer.parseInt(text_cid.getText()));
				cate.setCNAME(text_cname.getText());
				cate.setCMESSAGE(text_cmess.getText());
				try {
					cs.editCate(cate);
					JOptionPane.showMessageDialog(null, GeneralMessage.UPDATE_SUCCESS);
					setVisible(false);
					new CategoryTableFrame().setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, GeneralMessage.UPDATE_FAILURE + e.getMessage());
				}

			}
		});
		button.setText("提交");
		button.setBounds(81, 295, 106, 28);
		panel.add(button);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				new CategoryTableFrame().setVisible(true);
				setVisible(false);
			}
		});
		button_1.setText("返回");
		button_1.setBounds(277, 295, 106, 28);
		panel.add(button_1);

		text_cid = new JTextField();
		text_cid.setEditable(false);
		text_cid.setBounds(235, 35, 120, 22);
		panel.add(text_cid);

		text_cname = new JTextField();
		text_cname.setBounds(235, 97, 120, 22);
		panel.add(text_cname);

		text_cmess = new JTextArea();
		text_cmess.setBounds(93, 190, 262, 71);
		panel.add(text_cmess);

		text_cid.setText(cID);
		text_cname.setText(cNAME);
		text_cmess.setText(cMESSAGE);
	}

}

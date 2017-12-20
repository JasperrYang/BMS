package edu.eurasia.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import edu.eurasia.entity.CategoryBean;
import edu.eurasia.service.CategoryService;
import edu.eurasia.service.impl.CategoryServiceImpl;
import edu.eurasia.untils.GeneralMessage;

public class CategoryTableFrame extends JFrame {

	DefaultTableModel tm = new DefaultTableModel();
	CategoryService cateservice = new CategoryServiceImpl();
	CategoryBean cate = new CategoryBean();
	private JTable table;
	private JTextField textField;

	public CategoryTableFrame() {
		super();

		setResizable(false);
		setTitle("图书类别管理");
		setSize(553, 371);

		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				new CategoryAddFrame().setVisible(true);
				setVisible(false);
			}
		});
		button.setText("添加");
		panel.add(button);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int no = table.getSelectedRowCount();
				if (no == 0) {
					JOptionPane.showMessageDialog(null,  GeneralMessage.CHAGE_NULL);
				} else if (no > 1) {
					JOptionPane.showMessageDialog(null, GeneralMessage.CHAGE_ONE);
				} else {
					int confirmNo = JOptionPane.showConfirmDialog(null, GeneralMessage.CHAGE_SURE);
					if (confirmNo == 0) {
						int index = table.getSelectedRow();
						String CID = table.getValueAt(index, 0).toString();
						String CNAME = table.getValueAt(index, 1).toString();
						String CMESSAGE = table.getValueAt(index, 2).toString();
						new CategoryUpdateFrame(tm, CID, CNAME, CMESSAGE, index).setVisible(true);
						setVisible(false);
					}
				}
			}
		});
		button_1.setText("编辑");
		panel.add(button_1);

		final JButton button_2 = new JButton();
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int no = table.getSelectedRowCount();
				if (no == 0) {
					JOptionPane.showMessageDialog(null, GeneralMessage.CHAGE_NULL);
				} else if (no > 1) {
					JOptionPane.showMessageDialog(null, GeneralMessage.CHAGE_ONE);
				} else {
					int confirmNo = JOptionPane.showConfirmDialog(null, GeneralMessage.CHAGE_SURE);
					if (confirmNo == 0) {
						int index = table.getSelectedRow();
						int CID = Integer.parseInt(table.getValueAt(index, 0).toString());
						try {
							cateservice.delInfo(CID);
							JOptionPane.showMessageDialog(null, GeneralMessage.DELETE_SUCCESS);
							setVisible(false);
							new CategoryTableFrame().setVisible(true);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, GeneralMessage.DELETE_FAILURE);
						}
					}
				}
			}
		});
		button_2.setText("删除");
		panel.add(button_2);

		final JButton button_4 = new JButton();
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				new FunctionalFrame().setVisible(true);
				setVisible(false);
			}
		});
		button_4.setText("返回");
		panel.add(button_4);

		final JPanel panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(1, 0));
		getContentPane().add(panel_1, BorderLayout.NORTH);

		final JLabel label = new JLabel();
		label.setText("图书类别名称");
		panel_1.add(label);

		textField = new JTextField();
		panel_1.add(textField);

		final JButton button_3 = new JButton();
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {

				String booksname = textField.getText();
				try {
					List<CategoryBean> list = cateservice.selectBycname(booksname);
					int rowCount = table.getRowCount();
					for (int i = 0; i < rowCount; i++) {
						tm.removeRow(0);
					}
					for (int i = 0; i < list.size(); i++) {
						tm.addRow(new Object[] { list.get(i).getCID(), list.get(i).getCNAME(),
								list.get(i).getCMESSAGE() });
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, GeneralMessage.QUERY_FAILURE + e1.getMessage());
				}

			}
		});
		button_3.setText("查询");
		panel_1.add(button_3);

		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		// 表中添加模具
		table.setModel(tm);
		// 设置表头
		tm.addColumn("编号");
		tm.addColumn("图书类别名称");
		tm.addColumn("图书类别描述");
		// 查询表所有数据并添加
		try {
			List<CategoryBean> list = cateservice.selectCategoryAll();
			for (int i = 0; i < list.size(); i++) {
				tm.addRow(new Object[] { list.get(i).getCID(), list.get(i).getCNAME(), list.get(i).getCMESSAGE() });
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, GeneralMessage.QUERY_FAILURE);
		}

		scrollPane.setViewportView(table);
	}

}

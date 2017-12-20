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

import edu.eurasia.entity.BooksBean;
import edu.eurasia.entity.CategoryBean;

import edu.eurasia.service.BooksService;
import edu.eurasia.service.impl.BooksServiceImpl;
import edu.eurasia.untils.GeneralMessage;

public class BooksTableFrame extends JFrame {
	DefaultTableModel tm = new DefaultTableModel();
	BooksService bookservice = new BooksServiceImpl();
	BooksBean booksbean = new BooksBean();
	private JTable table;
	private JTextField textField;
	public BooksTableFrame() {
		super();
		setSize(636,389);
		setTitle("图书管理");
		setResizable(false);

		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				new BooksAddFrame().setVisible(true);
				setVisible(false);
			}
		});
		button.setText("添加");
		panel.add(button);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				
				int no=table.getSelectedRowCount();
				if(no==0){
					JOptionPane.showMessageDialog(null, GeneralMessage.CHAGE_NULL);
				}else if(no>1){
					JOptionPane.showMessageDialog(null, GeneralMessage.CHAGE_ONE);
				}else{
					int confirmNo=JOptionPane.showConfirmDialog(null, GeneralMessage.CHAGE_SURE);
					if(confirmNo==0){
						int index=table.getSelectedRow();
						int BID =Integer.parseInt( table.getValueAt(index, 0).toString());
						String BNAME = table.getValueAt(index, 1).toString();
						String BAUTHOR = table.getValueAt(index, 2).toString();
						double BPRICE = Double.parseDouble(table.getValueAt(index, 3).toString());
						String CNAME = table.getValueAt(index, 4).toString();
						String BMESSAGE = table.getValueAt(index, 5).toString();
						new BooksUpdateFrame(tm,BID,BNAME,BAUTHOR,BPRICE,CNAME,BMESSAGE,index).setVisible(true);
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
				int no=table.getSelectedRowCount();
				if(no==0){
					JOptionPane.showMessageDialog(null,GeneralMessage.CHAGE_NULL);
				}else if(no>1){
					JOptionPane.showMessageDialog(null, GeneralMessage.CHAGE_ONE);
				}else{
					int confirmNo=JOptionPane.showConfirmDialog(null, GeneralMessage.CHAGE_SURE);
					if(confirmNo==0){
						int index=table.getSelectedRow();
						int BID =Integer.parseInt(table.getValueAt(index, 0).toString());
						try {
							bookservice.delInfo(BID);
							JOptionPane.showMessageDialog(null, GeneralMessage.DELETE_SUCCESS);
							setVisible(false);
							new BooksTableFrame().setVisible(true);
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
			public void actionPerformed(final ActionEvent e) {
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
		label.setText("图书名称");
		panel_1.add(label);

		textField = new JTextField();
		panel_1.add(textField);

		final JButton button_3 = new JButton();
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				//获取文本值
				String booksname = textField.getText();
				
				try {
					List<BooksBean> list = bookservice.selectBycname(booksname);
					//获取当前行数，并且移除
					int rowCount = table.getRowCount();
					for (int i = 0; i < rowCount; i++) {
						tm.removeRow(0);
					}
					//查询数据添加到面板
					for (int i = 0; i < list.size(); i++) {
						tm.addRow(new Object[] { list.get(i).getBID(),list.get(i).getBNAME(),list.get(i).getBAUTHOR(),list.get(i).getBPRICE(),
								list.get(i).getCNAME(),list.get(i).getBMESSAGE() });
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
		tm.addColumn("图书名称");
		tm.addColumn("图书作者");
		tm.addColumn("价格");
		tm.addColumn("图书类别");
		tm.addColumn("图书描述");
		//关联查询Books表所有字段以及Category表中的cname字段
		List<BooksBean> list;
		try {
			list = bookservice.selectBooksAll();
			for (int i = 0; i < list.size(); i++) {
				tm.addRow(new Object[] {list.get(i).getBID(),list.get(i).getBNAME(),list.get(i).getBAUTHOR(),list.get(i).getBPRICE(),
						list.get(i).getCNAME(),list.get(i).getBMESSAGE()});
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null,GeneralMessage.QUERY_FAILURE);
		}
		
	
		
		scrollPane.setViewportView(table);
	}

}

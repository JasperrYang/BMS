package edu.eurasia.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.eurasia.entity.UsersBean;
import edu.eurasia.service.UserService;
import edu.eurasia.service.impl.UserServiceImpl;
import edu.eurasia.untils.GeneralMessage;

public class LoginFrame extends JFrame {
	private JPasswordField password;
	private JTextField username;

	public LoginFrame() {
		super();
		setResizable(false);
		setTitle("管理员登录");
		setSize(540, 368);

		final JPanel panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel, BorderLayout.CENTER);

		final JLabel label = new JLabel();
		label.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label.setText("账号");
		label.setBounds(105, 82, 66, 18);
		panel.add(label);

		final JLabel label_1 = new JLabel();
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label_1.setText("密码");
		label_1.setBounds(105, 168, 66, 28);
		panel.add(label_1);

		username = new JTextField();
		username.setBounds(228, 80, 141, 22);
		panel.add(username);

		password = new JPasswordField();
		password.setBounds(228, 175, 141, 22);
		panel.add(password);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				// 获取文本框内容
				String LoginName = username.getText();
				String LoginPass = password.getText();
				// 添加数据到实体类
				UsersBean users = new UsersBean();
				users.setNAME(LoginName);
				users.setPASSWORD(LoginPass);
				// 调用service层
				UserService userservice = new UserServiceImpl();
				// 异常处理
				try {
					// 调用接口login方法
					List<UsersBean> list = userservice.login(users);
					JOptionPane.showMessageDialog(null, GeneralMessage.LOGIN_SUCCESS);
					new FunctionalFrame().setVisible(true);
					setVisible(false);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, GeneralMessage.LOGIN_FAILURE + e1.getMessage());
				}

			}
		});
		button.setText("登录");
		button.setBounds(190, 257, 106, 28);
		panel.add(button);
	}

}

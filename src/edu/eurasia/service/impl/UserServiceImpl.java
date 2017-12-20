package edu.eurasia.service.impl;

import java.util.List;

import edu.eurasia.dao.UserDao;
import edu.eurasia.dao.impl.UserDaoImpl;
import edu.eurasia.entity.UsersBean;
import edu.eurasia.service.UserService;
import edu.eurasia.untils.GeneralMessage;

public class UserServiceImpl implements UserService {
	
	UserDao userdao = new UserDaoImpl();

	@Override
	public List<UsersBean> login(UsersBean users) throws Exception {
		List<UsersBean> list = null;
		// 判断账号是否为空
		if (users.getNAME() == null || users.getNAME().equals("")) {
			throw new RuntimeException(GeneralMessage.LOGIN_NAME);
		}
		// 判断密码是否为空
		if (users.getPASSWORD() == null || users.getPASSWORD().equals("")) {
			throw new RuntimeException(GeneralMessage.LOGIN_PASS);
		} else {
			// 调用dao层接口login方法
			list = userdao.login(users);
			if (list == null) {
				throw new RuntimeException(GeneralMessage.LOGIN_PROMPT);
			}
		}
		return list;

	}

}

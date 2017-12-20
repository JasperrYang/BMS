package edu.eurasia.dao.impl;

import java.util.List;

import edu.eurasia.dao.UserDao;
import edu.eurasia.entity.UsersBean;
import edu.eurasia.untils.DbUtils;

public class UserDaoImpl implements UserDao {
	
	DbUtils dbutils = new DbUtils();

	@Override
	public List<UsersBean> login(UsersBean users) throws Exception {
		String sql = "SELECT * from users where name = ? and password = ?";
		Object[] num = { users.getNAME(), users.getPASSWORD() };
		List<UsersBean> list = dbutils.query(sql, num, UsersBean.class);
		return (list != null && list.size() > 0 ? list : null);
	}

}

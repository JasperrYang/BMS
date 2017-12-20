package edu.eurasia.dao.impl;

import java.util.List;

import edu.eurasia.dao.CategoryDao;
import edu.eurasia.entity.CategoryBean;
import edu.eurasia.entity.UsersBean;
import edu.eurasia.untils.DbUtils;

public class CategoryDaoImpl implements CategoryDao {
	
	DbUtils dbutils = new DbUtils();

	@Override
	public List<CategoryBean> selectCategoryAll() throws Exception {
		String sql = "SELECT * FROM CATEGORY";
		List<CategoryBean> list = dbutils.query(sql, null, CategoryBean.class);
		return (list != null && list.size() > 0 ? list : null);
	}

	@Override
	public List<CategoryBean> selectBycname(String booksname) throws Exception {
		String sql = "SELECT * FROM CATEGORY WHERE CNAME LIKE ?";
		Object[] num = { "%" + booksname + "%" };
		List<CategoryBean> list = dbutils.query(sql, num, CategoryBean.class);
		return (list != null && list.size() > 0 ? list : null);
	}

	@Override
	public void addCate(CategoryBean catebean) throws Exception {
		String sql = "INSERT INTO CATEGORY(CID,CNAME,CMESSAGE) VALUES(?,?,?)";
		Object[] num = { catebean.getCID(), catebean.getCNAME(), catebean.getCMESSAGE() };
		dbutils.update(sql, num);
	}

	@Override
	public void editCate(CategoryBean cate) throws Exception {
		String sql = "UPDATE CATEGORY SET CNAME=?,CMESSAGE=? WHERE CID=?";
		Object[] num = { cate.getCNAME(), cate.getCMESSAGE(), cate.getCID() };
		dbutils.update(sql, num);
	}

	@Override
	public void delInfo(int cID) throws Exception {
		String sql = "DELETE FROM CATEGORY WHERE CID=?";
		Object[] num = { cID };
		dbutils.update(sql, num);
	}

}

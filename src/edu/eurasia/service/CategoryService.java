package edu.eurasia.service;

import java.util.List;

import edu.eurasia.entity.CategoryBean;
import edu.eurasia.entity.UsersBean;

public interface CategoryService {
	
	// 查询Category表所有数据
	List<CategoryBean> selectCategoryAll() throws Exception;

	// 用cname模糊查询Category表对应数据
	List<CategoryBean> selectBycname(String booksname) throws Exception;

	// 添加图书类别信息
	void addCate(CategoryBean catebean) throws Exception;

	// 修改图书类别信息
	void editCate(CategoryBean cate) throws Exception;

	// 删出图书分类信息
	void delInfo(int cID) throws Exception;
}

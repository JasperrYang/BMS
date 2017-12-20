package edu.eurasia.service;

import java.util.List;

import edu.eurasia.entity.BooksBean;

public interface BooksService {
	
	// 关联查询Books表所有字段以及Category表中的cname字段
	List<BooksBean> selectBooksAll() throws Exception;

	// 用bname模糊查询Books表所有字段以及Category表中的cname字段
	List<BooksBean> selectBycname(String booksname) throws Exception;

	// 添加图书信息
	void addBooks(BooksBean books) throws Exception;

	// 修改图书信息
	void editBooks(BooksBean booksbean) throws Exception;

	// 删除图书信息
	void delInfo(int bID) throws Exception;

}

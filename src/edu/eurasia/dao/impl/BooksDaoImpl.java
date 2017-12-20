package edu.eurasia.dao.impl;

import java.util.List;

import edu.eurasia.dao.BooksDao;
import edu.eurasia.entity.BooksBean;
import edu.eurasia.untils.DbUtils;

public class BooksDaoImpl implements BooksDao {
	
	DbUtils dbutils = new DbUtils();

	@Override
	public List<BooksBean> selectBooksAll() throws Exception {
		String sql = "SELECT BID,BNAME,BAUTHOR,BPRICE,BMESSAGE,CATEGORY.CNAME FROM BOOKS,CATEGORY WHERE BOOKS.CATEGORYID=CATEGORY.CID";
		List<BooksBean> pojo = dbutils.query(sql, null, BooksBean.class);
		return (pojo != null && pojo.size() > 0 ? pojo : null);
	}

	@Override
	public List<BooksBean> selectBycname(String booksname) throws Exception {
		String sql = "SELECT BID,BNAME,BAUTHOR,BPRICE,BMESSAGE,CATEGORY.CNAME FROM BOOKS,CATEGORY WHERE BOOKS.CATEGORYID=CATEGORY.CID AND BNAME LIKE ?";
		Object[] num = { "%" + booksname + "%" };
		List<BooksBean> list = dbutils.query(sql, num, BooksBean.class);
		return (list != null && list.size() > 0 ? list : null);
	}

	@Override
	public void addBooks(BooksBean books) throws Exception {
		String sql = "INSERT INTO BOOKS VALUES(?,?,?,?,?,?)";
		Object[] num = { books.getBID(), books.getBNAME(), books.getBAUTHOR(), books.getBPRICE(), books.getBMESSAGE(),
				books.getCATEGORYID() };
		dbutils.update(sql, num);
	}

	@Override
	public void editBooks(BooksBean booksbean) throws Exception {
		String sql = "UPDATE BOOKS SET BNAME=?,BAUTHOR=?,BPRICE=?,BMESSAGE=? WHERE BID=?";
		Object[] num = { booksbean.getBNAME(), booksbean.getBAUTHOR(), booksbean.getBPRICE(), booksbean.getBMESSAGE(),
				booksbean.getBID() };
		dbutils.update(sql, num);
	}

	@Override
	public void delInfo(int bID) throws Exception {
		String sql = "DELETE FROM BOOKS WHERE BID=?";
		Object[] num = { bID };
		dbutils.update(sql, num);
	}

}

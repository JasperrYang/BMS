package edu.eurasia.service.impl;

import java.util.List;

import edu.eurasia.dao.BooksDao;
import edu.eurasia.dao.impl.BooksDaoImpl;
import edu.eurasia.entity.BooksBean;
import edu.eurasia.service.BooksService;
import edu.eurasia.untils.GeneralMessage;

public class BooksServiceImpl implements BooksService {
	
	BooksDao booksdao = new BooksDaoImpl();

	@Override
	public List<BooksBean> selectBooksAll() throws Exception {
		return booksdao.selectBooksAll();
	}

	@Override
	public List<BooksBean> selectBycname(String booksname) throws Exception {
		List<BooksBean> list = null;
		// 判断输入是否为空
		if (booksname == null || booksname.equals("")) {
			throw new RuntimeException(GeneralMessage.Like_TEXTNULL);
		} else {
			list = booksdao.selectBycname(booksname);
			// 判断查询结果
			if (list == null) {
				throw new RuntimeException(GeneralMessage.Like_RESULTNULL);
			}
		}
		return list;
	}

	@Override
	public void addBooks(BooksBean books) throws Exception {
		if (books.getBNAME() == null || books.getBNAME().equals("")) {
			throw new RuntimeException(GeneralMessage.ADD_BOOKNAME);
		}
		if (books.getBAUTHOR() == null || books.getBAUTHOR().equals("")) {
			throw new RuntimeException(GeneralMessage.ADD_AUTHOR);
		}
		if (books.getBMESSAGE() == null || books.getBMESSAGE().equals("")) {
			throw new RuntimeException(GeneralMessage.UPDATE_MESSAGE);
		} else {
			booksdao.addBooks(books);
		}
	}

	@Override
	public void editBooks(BooksBean booksbean) throws Exception {
		if (booksbean.getBNAME() == null || booksbean.getBNAME().equals("")) {
			throw new RuntimeException(GeneralMessage.ADD_BOOKNAME);
		}
		if (booksbean.getBAUTHOR() == null || booksbean.getBAUTHOR().equals("")) {
			throw new RuntimeException(GeneralMessage.ADD_AUTHOR);
		}
		if (booksbean.getBMESSAGE() == null || booksbean.getBMESSAGE().equals("")) {
			throw new RuntimeException(GeneralMessage.UPDATE_MESSAGE);
		} else {
			booksdao.editBooks(booksbean);
		}

	}

	@Override
	public void delInfo(int bID) throws Exception {
		booksdao.delInfo(bID);

	}

}

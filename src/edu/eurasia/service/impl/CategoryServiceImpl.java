package edu.eurasia.service.impl;

import java.util.List;

import edu.eurasia.dao.CategoryDao;
import edu.eurasia.dao.impl.CategoryDaoImpl;
import edu.eurasia.entity.CategoryBean;
import edu.eurasia.service.CategoryService;
import edu.eurasia.untils.GeneralMessage;

public class CategoryServiceImpl implements CategoryService {
	
	CategoryDao categorydao = new CategoryDaoImpl();

	@Override
	public List<CategoryBean> selectCategoryAll() throws Exception {
		return categorydao.selectCategoryAll();
	}

	@Override
	public List<CategoryBean> selectBycname(String booksname) throws Exception {
		List<CategoryBean> list = null;
		// 判断输入是否为空
		if (booksname == null || booksname.equals("")) {
			throw new RuntimeException(GeneralMessage.Like_TEXTNULL);
		} else {
			list = categorydao.selectBycname(booksname);
			// 判断查询结果
			if (list == null) {
				throw new RuntimeException(GeneralMessage.Like_RESULTNULL);
			}
		}

		return list;
	}

	@Override
	public void addCate(CategoryBean catebean) throws Exception {
		if (catebean.getCNAME() == null || catebean.getCNAME().equals("")) {
			throw new RuntimeException(GeneralMessage.ADD_NAME);
		}
		if (catebean.getCMESSAGE() == null || catebean.getCMESSAGE().equals("")) {
			throw new RuntimeException(GeneralMessage.UPDATE_MESSAGE);
		} else {
			categorydao.addCate(catebean);
		}

	}

	@Override
	public void editCate(CategoryBean cate) throws Exception {
		if (cate.getCNAME() == null || cate.getCNAME().equals("")) {
			throw new RuntimeException(GeneralMessage.ADD_NAME);
		}
		if (cate.getCMESSAGE() == null || cate.getCMESSAGE().equals("")) {
			throw new RuntimeException(GeneralMessage.UPDATE_MESSAGE);
		} else {
			categorydao.editCate(cate);
		}

	}

	@Override
	public void delInfo(int cID) throws Exception {
		categorydao.delInfo(cID);
	}

}

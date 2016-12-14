package com.ycc.redbabyserver.service.impl;

import java.util.List;

import com.ycc.redbabyserver.dao.CategoryDao;
import com.ycc.redbabyserver.domain.Category;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.CateService;

public class CateServiceImpl implements CateService {
	
	private CategoryDao cateDao = BasicFactory.getFactory().getInstance(CategoryDao.class);
	
	@Override
	public List<Category> getCateInfo() {
		return cateDao.findAll();
	}

	@Override
	public String getLastVersion() {
		return cateDao.getLastVersion();
	}

}

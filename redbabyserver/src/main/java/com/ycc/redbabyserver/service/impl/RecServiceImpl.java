package com.ycc.redbabyserver.service.impl;

import java.util.List;

import com.ycc.redbabyserver.dao.RecDao;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.RecService;

public class RecServiceImpl implements RecService {
	RecDao recdao = BasicFactory.getFactory().getInstance(RecDao.class);
	@Override
	public List<Object> getKeywords() {
		return recdao.find();
	}

}

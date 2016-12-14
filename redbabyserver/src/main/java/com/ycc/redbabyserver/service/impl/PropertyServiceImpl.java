package com.ycc.redbabyserver.service.impl;

import java.util.List;

import com.ycc.redbabyserver.dao.PropertyDao;
import com.ycc.redbabyserver.domain.Property;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.PropertyService;

public class PropertyServiceImpl implements PropertyService {

	private PropertyDao propertyDao = BasicFactory.getInstance(PropertyDao.class);

	@Override
	public List<Property> findAllPropertyById(int id) {
		// TODO Auto-generated method stub
		return propertyDao.findAllPropertyById(id);
	}
}

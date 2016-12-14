package com.ycc.redbabyserver.service.impl;

import java.util.List;

import com.ycc.redbabyserver.dao.AddressAreaDao;
import com.ycc.redbabyserver.domain.AddressArea;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.AddressAreaService;

public class AddressAreaServiceImpl implements AddressAreaService {
	AddressAreaDao addressAreaDao = BasicFactory.getInstance(AddressAreaDao.class);

	@Override
	public AddressArea findAddrAreaByAreaId(String areaId) {
		return addressAreaDao.findAddrAreaByAreaId(areaId);
	}

	
}

package com.ycc.redbabyserver.service.impl;

import java.util.List;

import com.ycc.redbabyserver.dao.AddressDao;
import com.ycc.redbabyserver.domain.Address;
import com.ycc.redbabyserver.domain.AddressArea;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.AddressService;

public class AddressServiceImpl implements AddressService {
	private AddressDao addressdao = BasicFactory.getInstance(AddressDao.class);

	@Override
	public List<Address> getAddressList(String userid) {
		return addressdao.findAddressByUserid(userid);
	}

	@Override
	public List<AddressArea> getAreaById(String areaid) {
		List<AddressArea> areas;
		if ("0".equals(areaid)) {
			areas = addressdao.findAllArea();
		} else {
			areas = addressdao.findAreaByAreaid(areaid);
		}
		return areas;
	}

	@Override
	public String saveAddress(String userid, String name, String phonenumber, String areadetail) {
		String addressid = addressdao.insert(userid, name, phonenumber, areadetail);
		String id = addressdao.findIdByAddressId(addressid);
		return id;
	}

	@Override
	public String updateAddress(String userid, String addressid, String name, String phonenumber, String areadetail) {
		String id = addressdao.findIdByAddressId(addressid);
		if(id==null||"".equals(id)){
			return null;
		}
		addressdao.update(userid, addressid, name, phonenumber, areadetail);
		return addressdao.findIdByAddressId(addressid);
	}
}

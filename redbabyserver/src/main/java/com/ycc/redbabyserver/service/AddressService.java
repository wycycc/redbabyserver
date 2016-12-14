package com.ycc.redbabyserver.service;

import com.ycc.redbabyserver.domain.Address;
import com.ycc.redbabyserver.domain.AddressArea;

import java.util.List;

public interface AddressService {
	/**
	 * 根据用户id查询地址信息
	 * @param userid
	 * @return
	 */
	List<Address> getAddressList(String userid);
	/**
	 * 根据地区id查询地区
	 * @param areaid
	 * @return
	 */
	List<AddressArea> getAreaById(String areaid);
	/**
	 * 添加地址
	 * @param userid
	 * @param name
	 * @param phonenumber
	 * @param areadetail
	 * @return 是否添加成功
	 */
	String saveAddress(String userid, String name, String phonenumber, String areadetail);
	/**
	 * 更新地址
	 * @param userid
	 * @param addressid
	 * @param name
	 * @param phonenumber
	 * @param fixedtel
	 * @param provinceid
	 * @param cityid
	 * @param areaid
	 * @param areadetail
	 * @param zipcode
	 * @return
	 */
	String updateAddress(String userid, String addressid, String name, String phonenumber, String areadetail);

}

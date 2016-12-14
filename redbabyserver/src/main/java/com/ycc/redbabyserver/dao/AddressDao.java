package com.ycc.redbabyserver.dao;

import com.ycc.redbabyserver.domain.Address;
import com.ycc.redbabyserver.domain.AddressArea;

import java.util.List;


public interface AddressDao {
	/**
	 * 根据用户名查询地址信息
	 * @param userid
	 * @return
	 */
	List<Address> findAddressByUserid(String userid);
	/**
	 * 查询所有地区
	 * @return
	 */
	List<AddressArea> findAllArea();
	/**
	 * 根据地区id查询地区
	 * @param areaid
	 * @return
	 */
	List<AddressArea> findAreaByAreaid(String areaid);
	/**
	 * 添加地址
	 * @param userid
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
	String insert(String userid, String name, String phonenumber, String areadetail);
	/**
	 * 修改地址
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
	boolean update(String userid, String addressid, String name, String phonenumber, String areadetail);
	/**
	 * 根据地址id查询id
	 * @param addressid
	 * @return
	 */
	String findIdByAddressId(String addressid);
	/**
	 * 设置默认地址
	 * @return
	 */
	int updateDefault(String addressid);
	/**
	 * 删除指定id的地址
	 * @param addressid
	 * @return
	 */
	int delete(String addressid);

}

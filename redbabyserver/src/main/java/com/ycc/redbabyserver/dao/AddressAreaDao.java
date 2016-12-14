package com.ycc.redbabyserver.dao;

import com.ycc.redbabyserver.domain.AddressArea;

public interface AddressAreaDao {
	/**
	 * 通过区域id获取area
	 * @param areaId
	 * @return
	 */
	AddressArea findAddrAreaByAreaId(String areaId);

}

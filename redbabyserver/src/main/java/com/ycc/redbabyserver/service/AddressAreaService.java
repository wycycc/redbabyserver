package com.ycc.redbabyserver.service;

import com.ycc.redbabyserver.domain.AddressArea;

import java.util.List;

public interface AddressAreaService {

/**
 * 通过区域id获取地址
 * @param areaId
 * @return
 */
	AddressArea findAddrAreaByAreaId(String areaId);

}

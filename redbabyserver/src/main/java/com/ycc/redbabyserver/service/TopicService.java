package com.ycc.redbabyserver.service;

import com.ycc.redbabyserver.domain.Brand;
import com.ycc.redbabyserver.domain.Topic;

import java.util.List;
import java.util.Map;

public interface TopicService {
	/**
	 * 获取首页主题大图
	 * @return
	 */
	List<Topic> getBanner();
	/**
	 * 获取推荐品牌
	 * @return
	 */
	Map<String, List<Brand>> getBrand();
}

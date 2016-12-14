package com.ycc.redbabyserver.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ycc.redbabyserver.dao.BrandDao;
import com.ycc.redbabyserver.dao.TopicDao;
import com.ycc.redbabyserver.domain.Brand;
import com.ycc.redbabyserver.domain.Topic;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.TopicService;

public class TopicServiceImpl implements TopicService {
	TopicDao topicdao = BasicFactory.getInstance(TopicDao.class);
	BrandDao branddao = BasicFactory.getInstance(BrandDao.class);

	@Override
	public List<Topic> getBanner() {
		return topicdao.find();
	}

	@Override
	public Map<String, List<Brand>> getBrand() {
		Map<String, List<Brand>> map = new HashMap<String, List<Brand>>();
		List<Brand> list = branddao.getBrand();
		Set<String> keys = new HashSet<String>();
		for (Brand brand : list) {
			String key = brand.getKeyword();
			keys.add(key);
		}
		for (String key : keys) {
			List<Brand> value = branddao.getBrandByKey(key);
			map.put(key, value);
		}
		return map;
	}
}

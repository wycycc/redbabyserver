package com.ycc.redbabyserver.dao;

import com.ycc.redbabyserver.domain.Topic;

import java.util.List;

public interface TopicDao {
	/**
	 * 查找专题信息
	 * @return
	 */
	List<Topic> find();
	/**
	 * 通过专题id查询所有产品id
	 * @param id 专题id
	 * @return
	 */
	List<Object> getPList(String id);
	
}

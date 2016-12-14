package com.ycc.redbabyserver.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ycc.redbabyserver.dao.TopicDao;
import com.ycc.redbabyserver.domain.Topic;
import com.ycc.redbabyserver.utils.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

public class TopicDaoImpl implements TopicDao {

	@Override
	public List<Topic> find() {
		String sql = "select * from topic";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<Topic>(Topic.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Object> getPList(String id) {
		String sql = "select pro_id from topicpro where topic_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return (List<Object>) runner.query(sql, new ColumnListHandler(),id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}

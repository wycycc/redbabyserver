package com.ycc.redbabyserver.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ycc.redbabyserver.dao.CommentDao;
import com.ycc.redbabyserver.domain.Comment;
import com.ycc.redbabyserver.utils.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class CommentDaoImpl implements CommentDao {

	@Override
	public List<Comment> getComments(String pId, String page, String pageNum) {
		String sql = "select * from comment where pro_id=? limit ?,?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<Comment>(Comment.class),pId,(Integer.valueOf(page)-1)*Integer.valueOf(pageNum),Integer.valueOf(pageNum));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
	
	}
	

	@Override
	public String getCommentCount(String pId) {

		String sql = "select count(*) from comment where pro_id=?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return (String) runner.query(sql, new ScalarHandler(),pId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
	}

}

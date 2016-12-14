package com.ycc.redbabyserver.dao;

import com.ycc.redbabyserver.domain.Comment;

import java.util.List;

public interface CommentDao {
	
	/**
	 * 获取评论列表
	 * @param pId
	 * @param page
	 * @param pageNum
	 * @return
	 */
	List<Comment> getComments(String pId, String page, String pageNum);

	/**
	 * 获取评论总数
	 * @return
	 */
	String getCommentCount(String pId);

}

package com.ycc.redbabyserver.service;

import com.ycc.redbabyserver.domain.Comment;

import java.util.List;

public interface CommentService {

	/**
	 * 获取某一商品的评论信息
	 * @param pId 商品ID
	 * @param page 页码
	 * @param pageNum 每页显示数量
	 * @return
	 */
	List<Comment> getComments(String pId, String page, String pageNum);
	
	/**
	 * 获取商品评论数
	 * @param pId
	 */
	String getCommentCount(String pId);

}

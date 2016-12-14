package com.ycc.redbabyserver.service.impl;

import java.util.List;

import com.ycc.redbabyserver.dao.CommentDao;
import com.ycc.redbabyserver.domain.Comment;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.CommentService;

public class CommentServiceImpl implements CommentService {
	CommentDao commentDao = BasicFactory.getInstance(CommentDao.class);
	@Override
	public List<Comment> getComments(String pId, String page, String pageNum) {
		return commentDao.getComments(pId,page,pageNum);
	}
	
	@Override
	public String getCommentCount(String pId) {
		return commentDao.getCommentCount(pId);
	}

	
}

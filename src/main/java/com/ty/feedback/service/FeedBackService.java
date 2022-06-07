package com.ty.feedback.service;

import java.util.List;

import com.ty.feedback.dao.FeedBackDao;
import com.ty.feedback.dto.FeedBack;

public class FeedBackService {
	FeedBackDao feedBackDao=new FeedBackDao();
	public FeedBack addFeedBack(FeedBack feedBack) {
		return feedBackDao.addFeedBack(feedBack);
	}
	public List<FeedBack> getAllFeedBackPrograms(){
		return feedBackDao.getAllFeedBackPrograms();
	}
	public FeedBack getFeedBackById(int id) {
		return feedBackDao.getFeedBackById(id);
	}
	public FeedBack updateTrainingPrograms(FeedBack feedBack) {
		return feedBackDao.updateTrainingPrograms(feedBack);
	}
	public FeedBack deleteFeedBackById(int id) {
		return feedBackDao.deleteFeedBackById(id);
	}
}

package service;

import java.util.Set;

import exceptions.InvalidQuestionException;
import models.Question;

public interface UserActivityService {
	public Question postQuestion(String heading, String desc, Set<String> tags, String userId);
	public Question addAnswer(String answerText, String quesId, String userId) throws InvalidQuestionException;
	public Question addComment(String commentText, String quesid, String ansid,String userId) throws InvalidQuestionException;
	public Integer upvote(String quesId, String userId) throws InvalidQuestionException;
	public Integer downvote(String quesId, String userId) throws InvalidQuestionException;
	public Boolean flagQuestion(String quesId, String userId);
	
}

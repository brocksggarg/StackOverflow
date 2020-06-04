package service;

import exceptions.InvalidQuestionException;
import models.Question;

public interface ModeratorActivityService {

	void deleteQues(String quesId) throws InvalidQuestionException;

	Question unDeleteQues(String quesId) throws InvalidQuestionException;
}

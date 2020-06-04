package service.impl;

import exceptions.InvalidQuestionException;
import models.Question;
import repository.DataStore;
import service.ModeratorActivityService;

public class ModeratorActivityServiceImpl implements ModeratorActivityService {

	private DataStore dataStore;

	public ModeratorActivityServiceImpl(DataStore dataStore) {
		this.dataStore = dataStore;
	}

	@Override
	public void deleteQues(String quesId) throws InvalidQuestionException {
		Question ques = dataStore.getQuestionFromId(quesId);
		if (ques == null) {
			throw new InvalidQuestionException("quesId does not exist");
		} else {
			ques.setIsDeleted(Boolean.TRUE);
			dataStore.updateQuestion(ques);
		}

	}

	@Override
	public Question unDeleteQues(String quesId) throws InvalidQuestionException {
		Question ques = dataStore.getQuestionFromId(quesId);
		if (ques == null) {
			throw new InvalidQuestionException("quesId does not exist");
		} else {
			ques.setIsDeleted(Boolean.TRUE);
			dataStore.updateQuestion(ques);
			return ques;
		}
	}

}

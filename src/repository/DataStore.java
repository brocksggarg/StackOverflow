package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import constants.AppConstants;
import exceptions.UserAccountException;
import models.Question;
import models.User;

public class DataStore {

	Map<String, String> usernamePasswordMap;
	Map<String, Question> questionStore;
	Set<String> grammaticalWords;
	Map<String, List<String>> tagsToQuestionMap;
	Map<String, User> useraccounts;

	public DataStore() {
		usernamePasswordMap = new HashMap<>();
		questionStore = new HashMap<>();
		grammaticalWords = new HashSet<>();
		tagsToQuestionMap = new HashMap<>();
		useraccounts = new HashMap<>();
	}

	public User addUser(String username, String password, String role) throws UserAccountException {
		if (usernamePasswordMap.containsKey(username)) {
			throw new UserAccountException("username " + username + " already exists");
		}
		User user = new User(username, password, role);
		usernamePasswordMap.put(username, password);
		useraccounts.put(user.getId(), user);
		return user;
	}

	public Question addQuestionToStore(Question ques) {
		questionStore.put(ques.getId(), ques);
		return ques;
	}

	public Question getQuestionFromId(String quesId) {
		return questionStore.get(quesId);
	}

	public void updateQuestionWithAnswer(Question ques) {
		questionStore.put(ques.getId(), ques);

	}

	public List<String> getTagsFromText(String searchText) {
		List<String> tags = new ArrayList<>();
		String words[] = searchText.split(AppConstants.SPACE);
		for (String word : words) {
			if (!grammaticalWords.contains(word)) {
				tags.add(word);
			}
		}
		return tags;
	}

	public List<String> getQuestionIdsFromTag(String tag) {
		return tagsToQuestionMap.get(tag);
	}

	public void updateQuestion(Question ques) {
		questionStore.put(ques.getId(), ques);

	}

}

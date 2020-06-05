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

	public User addUser(User user) throws UserAccountException {
		if (usernamePasswordMap.containsKey(user.getUsername())) {
			throw new UserAccountException("username " + user.getUsername() + " already exists");
		}

		usernamePasswordMap.put(user.getUsername(), user.getPasssword());
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

	public void addQuestionIdToTagStore(String keyword, String id) {
		List<String> l = tagsToQuestionMap.getOrDefault(keyword, new ArrayList<>());
		l.add(id);
		tagsToQuestionMap.put(keyword, l);

	}

}

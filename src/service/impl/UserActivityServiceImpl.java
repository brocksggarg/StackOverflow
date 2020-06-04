package service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import exceptions.InvalidQuestionException;
import models.Answer;
import models.Comment;
import models.Question;
import repository.DataStore;
import service.UserActivityService;

public class UserActivityServiceImpl implements UserActivityService{

	DataStore dataStore;
	
	
	public UserActivityServiceImpl() {
		dataStore=new DataStore();
	}

	@Override
	public Question postQuestion(String heading, String desc, Set<String> tags, String userId) {
		Question ques=new Question(heading, desc,tags,userId);
		return dataStore.addQuestionToStore(ques);
	}

	@Override
	public Question addAnswer(String answerText, String quesId, String userId) throws InvalidQuestionException {
		Question ques=dataStore.getQuestionFromId(quesId);
		if(ques==null) {
			throw new InvalidQuestionException("quesId does not exist");
		}else {
			Answer ans=new Answer(answerText);
			ques.getAnswers().put(quesId, ans);
			dataStore.updateQuestionWithAnswer(ques);
			return ques;
		}
	}

	@Override
	public Question addComment(String commentText, String quesId, String ansId, String userId) throws InvalidQuestionException {
		Question ques=dataStore.getQuestionFromId(quesId);
		if(ques==null) {
			throw new InvalidQuestionException("quesId does not exist");
		}else {
			Comment comment=new Comment(commentText,userId);
			if(quesId==ansId) {
				ques.getComments().add(comment);
				dataStore.updateQuestionWithAnswer(ques);
			}else {
				Answer answer=ques.getAnswers().get(ansId);
				answer.getComments().add(comment);
				dataStore.updateQuestionWithAnswer(ques);
			}
		}
		return ques;
	}

	@Override
	public Integer upvote(String quesId, String userId) throws InvalidQuestionException {
		Question ques=dataStore.getQuestionFromId(quesId);
		if(ques==null) {
			throw new InvalidQuestionException("quesId does not exist");
		}else {
			ques.getUpvotes().add(userId);
			dataStore.updateQuestion(ques);
			return ques.getUpvotes().size();
		}
	}

	@Override
	public Integer downvote(String quesId, String userId) throws InvalidQuestionException {
		Question ques=dataStore.getQuestionFromId(quesId);
		if(ques==null) {
			throw new InvalidQuestionException("quesId does not exist");
		}else {
			ques.getUpvotes().remove(userId);
			dataStore.updateQuestion(ques);
			return ques.getUpvotes().size();
		}
	}

	@Override
	public Boolean flagQuestion(String quesId, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	Question searchQuestion(String searchText){
		List<Question> quesList=new ArrayList<Question>();
		List<String> tags=dataStore.getTagsFromText(searchText);
		Map<String, Long> questionCountMap=new HashMap<>();
		for(String tag:tags) {
			List<String> quesIds = dataStore.getQuestionIdsFromTag(tag);
			for(String id:quesIds) {
				questionCountMap.put(id, questionCountMap.getOrDefault(id, 0l)+1);
			}
		}
		if(questionCountMap.size()==0) {
			return null;
		}else {
			String maxCountQuesId="";
			long maxCount=0l;
			for(String id:questionCountMap.keySet()) {
				if(questionCountMap.get(id)>maxCount) {
					maxCountQuesId=id;
					maxCount=questionCountMap.get(id);
				}
			}
			return dataStore.getQuestionFromId(maxCountQuesId);
		}
		
	}


}

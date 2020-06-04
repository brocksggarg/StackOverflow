package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utility.KeyGenerationUtility;

public class Question extends Base {

	private String heading;
	private String description;
	private String ownerId;
	private Map<String, Answer> answers;
	private List<Comment> comments;
	private Set<String> upvotes;
	private Set<String> tags;
	private Boolean isDeleted;

	public Question(String heading, String desc, Set<String> tags, String userId) {
		this.id = KeyGenerationUtility.getQuestionId();
		this.heading = heading;
		this.description = desc;
		this.tags = tags;
		this.ownerId = userId;
		answers = new HashMap<String, Answer>();
		this.created = new Date();
		this.updated = new Date();
		this.comments = new ArrayList<Comment>();
		this.upvotes = new HashSet<>();
		isDeleted = false;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public Map<String, Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Map<String, Answer> answers) {
		this.answers = answers;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Set<String> getUpvotes() {
		return upvotes;
	}

	public void setUpvotes(Set<String> upvotes) {
		this.upvotes = upvotes;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}

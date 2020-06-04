package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utility.KeyGenerationUtility;

public class Answer extends Base {
	private String answerText;
	private List<Comment> comments;

	public Answer(String answerText) {
		this.id = KeyGenerationUtility.getAnswerId();
		this.answerText = answerText;
		this.created = new Date();
		this.updated = new Date();
		this.comments=new ArrayList<Comment>();
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}

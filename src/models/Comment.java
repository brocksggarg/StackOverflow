package models;

import utility.KeyGenerationUtility;

public class Comment extends Base {
	private String commentText;
	private String fromUserId;

	public Comment(String commentText, String userId) {
		this.id = KeyGenerationUtility.getCommentId();
		this.commentText = commentText;
		this.fromUserId = userId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public String getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}

}

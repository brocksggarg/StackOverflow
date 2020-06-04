package utility;

public class KeyGenerationUtility {
	private static Long questionIdCounter = 0l;
	private static Long answerIdCounter = 0l;
	private static Long commentIdCounter = 0l;
	private static Long userIdCounter = 0l;

	public static String getQuestionId() {
		++questionIdCounter;
		return "QUES:" + questionIdCounter;
	}

	public static String getAnswerId() {
		++answerIdCounter;
		return "ANS:" + answerIdCounter;
	}

	public static String getCommentId() {
		++commentIdCounter;
		return "Comment:" + commentIdCounter;
	}

	public static String getUserId() {
		++userIdCounter;
		return "User:" + userIdCounter;
	}
}

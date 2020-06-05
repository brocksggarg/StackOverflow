package enums;

public enum UserRole {
	USER("USER"), MODERATOR("MODERATOR");

	private final String value;

	UserRole(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}

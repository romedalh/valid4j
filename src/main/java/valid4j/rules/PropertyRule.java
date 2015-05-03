package valid4j.rules;

import valid4j.model.ValidationError;


public abstract class PropertyRule<T> {
	private int errorCode;
	private String errorMessage;
	
	public PropertyRule(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public abstract ValidationError validate(T target);
}

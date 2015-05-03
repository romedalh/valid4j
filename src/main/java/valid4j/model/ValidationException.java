package valid4j.model;


public class ValidationException extends RuntimeException {
	private ValidationResult result;
	
	public ValidationException(String message, ValidationResult result) {
		super(message);
		this.result = result;
	}
	
	public ValidationResult getValidationResult() {
		return result;
	}
}

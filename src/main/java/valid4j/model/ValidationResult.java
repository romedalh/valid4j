package valid4j.model;

import java.util.LinkedList;
import java.util.List;

public class ValidationResult {
	private List<ValidationError> errors;
	
	public ValidationResult() {
		errors = new LinkedList<ValidationError>();
	}
	
	public Boolean isValid() {
		return getErrors().size() == 0;
	}
	
	public void addError(ValidationError error) {
		if(error != null) {
			getErrors().add(error);
		}
	}

	public List<ValidationError> getErrors() {
		return errors;
	}
}

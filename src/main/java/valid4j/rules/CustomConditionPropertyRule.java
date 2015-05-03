package valid4j.rules;


import java.util.function.Predicate;

import valid4j.model.ValidationError;

public class CustomConditionPropertyRule<T> extends PropertyRule<T> {

	private Predicate<T> failurePredicate;
	
	public CustomConditionPropertyRule(Predicate<T> failurePredicate, int errorCode, String errorMessage) {
		super(errorCode, errorMessage);
		this.failurePredicate = failurePredicate;
	}

	@Override
	public ValidationError validate(T target) {
		if(failurePredicate.test(target)){
			return new ValidationError(getErrorCode(), getErrorMessage());
		}
		return null;
	}

}

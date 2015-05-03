package valid4j;

import java.util.List;

import valid4j.model.ValidationException;
import valid4j.model.ValidationResult;
import valid4j.rules.PropertyRule;

public abstract class BaseValidator<TEntity extends Object> implements IValidator<TEntity> {

	protected ValidationHelper<TEntity> helper;
	
	public BaseValidator() {	
	}
	
	public ValidationResult validate(TEntity target) {
		helper = new ValidationHelper<TEntity>();
		validationDefinition();
		ValidationResult result = new ValidationResult();
		List<PropertyRule<TEntity>> validationRules = helper.getRules();
		for(PropertyRule<TEntity> rule: validationRules){
			result.addError(rule.validate(target));
		}
		return result;
	}
	
	public void validateAndThrow(TEntity target) {
		ValidationResult err = validate(target);
		if(!err.isValid()){
			String msg = String.format("Validation of %s failed", target.getClass().getSimpleName());
			throw new ValidationException(msg,err);
		}
			
	}
	
	protected abstract void validationDefinition();
}

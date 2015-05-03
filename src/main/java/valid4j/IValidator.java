package valid4j;

import valid4j.model.ValidationResult;

public interface IValidator<TEntity>{
	ValidationResult validate(TEntity object);
	void validateAndThrow(TEntity object);
}

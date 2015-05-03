package valid4j.rules;

import java.util.function.Function;

import valid4j.model.ValidationError;

public class NotEmptyPropertyRule<T, TValue> extends PropertyRule<T> {

	private Function<T,TValue> propertyFunc;
	
	public NotEmptyPropertyRule(Function<T,TValue> propertyFunc,int errorCode, String errorMessage) {
		super(errorCode, errorMessage);
		this.propertyFunc = propertyFunc;
	}
	
	@Override
	public ValidationError validate(T target) {
		TValue propertyValue = propertyFunc.apply(target);
		if(propertyValue == null || isInvalidString(propertyValue) || isDefaultPrimitive(propertyValue))
			return new ValidationError(getErrorCode(), getErrorMessage());
		return null;
	}
	
	private boolean isDefaultPrimitive(TValue propertyValue) {
		TValue defaulftValue = (TValue) Defaults.getDefaultValue(propertyValue.getClass());
		return propertyValue.equals(defaulftValue);
	}
	
	private boolean isInvalidString(TValue propertyValue) {
		if(propertyValue instanceof String){
			return ((String) propertyValue).isEmpty();
		}
		return false;
	}

}

package valid4j.rules;

import java.util.function.Function;
import java.util.regex.Pattern;

import valid4j.model.ValidationError;


public class EmailPropertyRule<T> extends PropertyRule<T>{
	private Function<T,String> propertyFunc;
	private Pattern pattern;
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public EmailPropertyRule(Function<T,String> propertyFunc, int errorCode, String errorMessage) {
		super(errorCode, errorMessage);
		this.propertyFunc = propertyFunc;
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	@Override
	public ValidationError validate(T target) {
		String propertyValue = propertyFunc.apply(target);
		if(propertyValue == null || !pattern.matcher(propertyValue).matches()){
			return new ValidationError(getErrorCode(), getErrorMessage());
		}
		return null;
	}
	
}

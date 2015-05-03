package valid4j;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import valid4j.rules.CustomConditionPropertyRule;
import valid4j.rules.EmailPropertyRule;
import valid4j.rules.NotEmptyPropertyRule;
import valid4j.rules.PropertyRule;

public class ValidationHelper<T extends Object> {
	private List<PropertyRule<T>> rules;
	
	public ValidationHelper() {
		rules = new LinkedList<PropertyRule<T>>();
	}
	
	public List<PropertyRule<T>> getRules() {
		return rules;
	}
	
	public <TValue> void rejectIfEmpty(Function<T,TValue> propertyFunc, int errorCode, String errorMessage){
		PropertyRule<T> notEmptyRule = new NotEmptyPropertyRule<T,TValue>(propertyFunc, errorCode, errorMessage);
		getRules().add(notEmptyRule);
	}
	
	public <TValue> void rejectIfIncorrectEmail(Function<T,String> propertyFunc, int errorCode, String errorMessage){
		PropertyRule<T> notEmptyRule = new EmailPropertyRule<T>(propertyFunc, errorCode, errorMessage);
		getRules().add(notEmptyRule);
	}	
	
	public void rejectIf(Predicate<T> failurePredicate, int errorCode, String errorMessage){
		PropertyRule<T> customPredicateRule = new CustomConditionPropertyRule<T>(failurePredicate, errorCode, errorMessage);
		getRules().add(customPredicateRule);
	}
}

package valid4j.rules;

import static org.junit.Assert.*;

import org.junit.Test;

import valid4j.Target;
import valid4j.model.ValidationError;

public class CustomConditionValidatorTests {
	@Test
	public void shouldReturnErrorWhenSpecifiedConditionIsTrue(){
		//Arrange
		Target t = new Target();
		t.setName("mat");
		CustomConditionPropertyRule<Target> rule = new CustomConditionPropertyRule<Target>(trg->trg.getName().equals("mat"), 3, "error3");
		
		//Act
		ValidationError error= rule.validate(t);
		
		//Assert
		assertNotNull(error);
	}
	
	@Test
	public void shouldReturnErrorWhenSpecifiedConditionIsFalse(){
		//Arrange
		Target t = new Target();
		t.setAge(12);
		CustomConditionPropertyRule<Target> rule = new CustomConditionPropertyRule<Target>(trg->trg.getAge()<0, 3, "error3");
		
		//Act
		ValidationError error= rule.validate(t);
		
		//Assert
		assertNull(error);
	}
}

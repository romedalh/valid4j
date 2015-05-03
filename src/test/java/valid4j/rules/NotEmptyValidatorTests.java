package valid4j.rules;

import static org.junit.Assert.*;

import org.junit.Test;

import valid4j.Target;
import valid4j.model.ValidationError;

public class NotEmptyValidatorTests {
	@Test
	public void shouldReturnErrorWhenObjectIsNull(){
		//Arrange
		Target t = new Target();
		t.setAge(10);
		t.setName(null);
		NotEmptyPropertyRule<Target,String> rule = new NotEmptyPropertyRule<Target, String>(trg->trg.getName(), 1, "error");
		
		//Act
		ValidationError error= rule.validate(t);
		
		//Assert
		assertNotNull(error);
		assertEquals(1, error.getErrorCode());
		assertEquals("error", error.getErrorMessage());
	}
	
	@Test
	public void shouldReturnErrorWhenStringIsEmpty(){
		//Arrange
		Target t = new Target();
		t.setAge(10);
		t.setName("");
		NotEmptyPropertyRule<Target,String> rule = new NotEmptyPropertyRule<Target, String>(trg->trg.getName(), 1, "error");
		
		//Act
		ValidationError error= rule.validate(t);
		
		//Assert
		assertNotNull(error);
	}
	
	@Test
	public void shouldReturnErrorWhenDefaultValueForPrimitiveType(){
		//Arrange
		Target t = new Target();
		t.setAge(0);
		t.setName("mat");
		NotEmptyPropertyRule<Target,Integer> rule = new NotEmptyPropertyRule<Target, Integer>(trg->trg.getAge(), 2, "error2");
		
		//Act
		ValidationError error= rule.validate(t);
		
		//Assert
		assertNotNull(error);
	}
	
	@Test
	public void shouldNotReturnErrorWhenValueIsSet(){
		//Arrange
		Target t = new Target();
		t.setName("mat");
		NotEmptyPropertyRule<Target,String> rule = new NotEmptyPropertyRule<Target, String>(trg->trg.getName(), 2, "error2");
		
		//Act
		ValidationError error= rule.validate(t);
		
		//Assert
		assertNull(error);
	}
}

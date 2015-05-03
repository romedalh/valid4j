package valid4j.rules;

import static org.junit.Assert.*;

import org.junit.Test;

import valid4j.Target;
import valid4j.model.ValidationError;

public class EmailValidatorTests {

	@Test
	public void canValidateCorrectEmail(){
		//Arrange
		Target t= new Target();
		t.setEmail("testmail+123@gmail.com");
		EmailPropertyRule<Target> sut= new EmailPropertyRule<Target>(trg->trg.getEmail(),4,"error");
		
		//Act
		ValidationError error = sut.validate(t);
		
		//Assert
		assertNull(error);
	}
	
	@Test
	public void shouldReturnErrorWhenMailIsNotCorrect(){
		//Arrange
		Target t= new Target();
		t.setEmail("testmail+123@gmail.");
		EmailPropertyRule<Target> sut= new EmailPropertyRule<Target>(trg->trg.getEmail(),4,"error");
		
		//Act
		ValidationError error = sut.validate(t);
		
		//Assert
		assertNotNull(error);
	}
	
	@Test
	public void shouldReturnErrorWhenMailIsNull(){
		//Arrange
		Target t= new Target();
		t.setEmail(null);
		EmailPropertyRule<Target> sut= new EmailPropertyRule<Target>(trg->trg.getEmail(),4,"error");
		
		//Act
		ValidationError error = sut.validate(t);
		
		//Assert
		assertNotNull(error);
	}
}

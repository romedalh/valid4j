package valid4j;
import static org.junit.Assert.*;

import org.junit.Test;

import valid4j.model.ValidationError;
import valid4j.model.ValidationResult;
import valid4j.utils.CustomCollector;

public class ValidatorTests {

	@Test
	public void should_return_validation_errors() {
		//Arrange
		Target target = new Target();
		TargetValidator sut = new TargetValidator();
		
		//Act
		ValidationResult result = sut.validate(target);
		
		//Assert
		assertFalse(result.isValid());
		assertEquals(2,result.getErrors().size());
		ValidationError nameError = result.getErrors().stream()
				.filter(er->er.getErrorCode() == 1)
				.collect(CustomCollector.firstOrDefaultCollector());
		ValidationError ageError = result.getErrors().stream()
				.filter(er->er.getErrorCode() == 2)
				.collect(CustomCollector.firstOrDefaultCollector());
		assertNotNull(nameError);		
		assertNotNull(ageError);
	}
	
	@Test
	public void should_return_error_only_for_age() {
		//Arrange
		Target target = new Target();
		target.setName("Matt Ellis");
		TargetValidator sut = new TargetValidator();
		
		//Act
		ValidationResult result = sut.validate(target);
		
		//Assert
		assertFalse(result.isValid());
		assertEquals(1,result.getErrors().size());
		ValidationError nameError = result.getErrors().stream()
				.filter(er->er.getErrorCode() == 1)
				.collect(CustomCollector.firstOrDefaultCollector());
		ValidationError ageError = result.getErrors().stream()
				.filter(er->er.getErrorCode() == 2)
				.collect(CustomCollector.firstOrDefaultCollector());
		assertNull(nameError);		
		assertNotNull(ageError);
	}
	
	@Test
	public void should_not_return_validation_errors_when_object_is_correct() {
		//Arrange
		Target target = new Target();
		target.setName("Matt Ellis");
		target.setAge(45);
		TargetValidator sut = new TargetValidator();
		
		//Act
		ValidationResult result = sut.validate(target);
		
		//Assert
		assertTrue(result.isValid());
		assertEquals(0,result.getErrors().size());
	}
}



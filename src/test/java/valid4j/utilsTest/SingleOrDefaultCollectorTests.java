package valid4j.utilsTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import valid4j.utils.CustomCollector;



public class SingleOrDefaultCollectorTests {

	@Test
	public void shouldReturnValueIfFound(){
		//Arrange
		List<String> list = new LinkedList<String>(Arrays.asList("str1","str2","str3"));
		
		//Act
		String item = list.stream().filter(s->s.equals("str2")).collect(CustomCollector.singleOrDefaultCollector());
		
		//Assert
		Assert.assertEquals("str2", item);
	}
	
	@Test
	public void shouldReturnNullIfValueNotFound(){
		//Arrange
		List<String> list = new LinkedList<String>(Arrays.asList("str1","str2","str3"));
		
		//Act
		String item = list.stream().filter(s->s.equals("str4")).collect(CustomCollector.singleOrDefaultCollector());
		
		//Assert
		Assert.assertEquals(null, item);
	}
	
	@Test(expected=IllegalStateException.class)
	public void shouldThrowIllegalStateExceptionWhenManyValuesFound(){
		//Arrange
		List<String> list = new LinkedList<String>(Arrays.asList("str1","str2","str3","str1"));
		
		//Act
		String item = list.stream().filter(s->s.equals("str1")).collect(CustomCollector.singleOrDefaultCollector());
		
		//Assert
		Assert.assertEquals(null, item);
	}
}

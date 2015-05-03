package valid4j.utilsTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import valid4j.utils.CustomCollector;

public class FirstOrDefaultCollectorTests {
	
	private class TestObj{
		public TestObj(int id, String name) {
			this.id = id;
			this.name = name;
		}
		public int id;
		public String name;
	}
	
	@Test
	public void shouldReturnValueIfFound(){
		//Arrange
		List<String> list = new LinkedList<String>(Arrays.asList("str1","str2","str3"));
		
		//Act
		String item = list.stream().filter(s->s.equals("str2")).collect(CustomCollector.firstOrDefaultCollector());
		
		//Assert
		Assert.assertEquals("str2", item);
	}
	
	@Test
	public void shouldReturnNullIfValueNotFound(){
		//Arrange
		List<String> list = new LinkedList<String>(Arrays.asList("str1","str2","str3"));
		
		//Act
		String item = list.stream().filter(s->s.equals("str4")).collect(CustomCollector.firstOrDefaultCollector());
		
		//Assert
		Assert.assertEquals(null, item);
	}
	
	@Test
	public void shouldReturnFirstOccurenceOfValueIfFound(){
		//Arrange
		TestObj test1 = new TestObj(1, "name1");
		TestObj test2 = new TestObj(2, "name2");
		TestObj test3 = new TestObj(3, "name3");
		TestObj test4 = new TestObj(4, "name2");
		List<TestObj> list = new LinkedList<TestObj>(Arrays.asList(test1,test2,test3,test4));
		
		//Act
		TestObj item = list.stream().filter(t->t.name.equals("name2")).collect(CustomCollector.firstOrDefaultCollector());
		
		//Assert
		Assert.assertEquals(test2, item);
	}
}

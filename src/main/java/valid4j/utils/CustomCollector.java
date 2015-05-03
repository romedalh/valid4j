package valid4j.utils;

import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollector {
	public static <T> Collector<T, ?, T> singleOrDefaultCollector() {
	    return Collectors.collectingAndThen(
	            Collectors.toList(),
	            list -> {
	                if (list.size() > 1) {
	                    throw new IllegalStateException();
	                }
	                else if(list.size() == 0){
	                	return null;
	                }
                	return list.get(0);
	            }
	    );
	}
	
	public static <T> Collector<T, ?, T> firstOrDefaultCollector() {
	    return Collectors.collectingAndThen(
	            Collectors.toList(),
	            list -> {
	                if(list.size() == 0){
	                	return null;
	                }
                	return list.get(0);
	            }
	    );
	}
}

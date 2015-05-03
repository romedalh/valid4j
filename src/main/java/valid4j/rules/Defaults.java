package valid4j.rules;

import java.util.HashMap;
import java.util.Map;
/**
 * Class was created basing on Guava Defaults class.
 */
public final class Defaults {
	private static Map<Class<?>, Object> map = new HashMap<Class<?>, Object>();

	 static{
		 map.put(boolean.class, false);
		 map.put(char.class, '\0');
		 map.put(byte.class, (byte)0);
		 map.put(short.class, (short)0);
		 map.put(int.class, 0);
		 map.put(long.class, 0L);
		 map.put(float.class, 0f);
		 map.put(double.class, 0d);
		 map.put(Boolean.class, false);
		 map.put(Character.class, '\0');
		 map.put(Byte.class, (byte)0);
		 map.put(Short.class, (short)0);
		 map.put(Integer.class, 0);
		 map.put(Long.class, 0L);
		 map.put(Float.class, 0f);
		 map.put(Double.class, 0d);
	 }
	 
	 @SuppressWarnings("unchecked")
	 public static <T> T getDefaultValue(Class<T> type){
		 if(type==null){
			 throw new NullPointerException("type");
		 }
		 return (T)map.get(type);
	 }
}

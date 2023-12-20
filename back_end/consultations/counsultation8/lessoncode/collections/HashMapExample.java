package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapExample 
{
	Map<String,String> map;
	
	public HashMapExample()
	{
		System.out.println("ConcurrentHashMap");
		createMap(true);
		addValue (true);

		System.out.println("\n\nHashMap");
		createMap(false);
		addValue (false);
	}

	private void addValue(boolean concurrent)
	{
		System.out.println("  before iterator : " + map);
		Iterator<String> it = map.keySet().iterator();

		System.out.print("  cycle : ");
		while(it.hasNext()){
			String key = it.next();
			if (key.equals("2")) {
				map.put(key + "new", "222");
				if (!concurrent)
					break;
			} else
				System.out.print("  " + key + "=" + map.get(key));
		}
		System.out.println();
		System.out.println("  after iterator : " + map);
	}

	private void createMap(boolean concurrent)
	{
		if (concurrent)
			map = new ConcurrentHashMap<String, String>();
		else
			map = new HashMap<String,String>();
		map.put("1", "1");
		map.put("2", "1");
		map.put("3", "1");
		map.put("4", "1");
		map.put("5", "1");
		map.put("6", "1");
	}

	public static void main(String[] args) 
	{
		new HashMapExample();
		System.exit(0);
	}
}

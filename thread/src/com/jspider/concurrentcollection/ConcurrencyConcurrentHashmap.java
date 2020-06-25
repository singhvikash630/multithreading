package com.jspider.concurrentcollection;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrencyConcurrentHashmap {
	//Initialize ConcurrentHashMap instance
	ConcurrentHashMap<String, Integer> m = new ConcurrentHashMap<String, Integer>();
	 
	//Print all values stored in ConcurrentHashMap instance
	for each (Entry<String, Integer> e : m.entrySet())
	{
	system.out.println(e.getKey()+"="+e.getValue());
	}
	
	ConcurrentHashMap<String, Integer> instance = new ConcurrentHashMap<String, Integer>(16, 0.9f, 1);

}

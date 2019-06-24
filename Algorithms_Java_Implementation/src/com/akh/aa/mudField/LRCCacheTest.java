package com.akh.aa.mudField;

import org.junit.Assert;
import org.junit.Test;


/**
 *  @fileName: LRCCacheTest.java
 *  @author: Akhash Ramamurthy
 *  Created on: Aug 1, 2018
 */

public class LRCCacheTest {

	@Test
	public void testAdd(){
		LRUCache lruCache = new LRUCache(3);
		lruCache.setCapacity(3);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.put(3, 3);
		Assert.assertEquals(3, lruCache.getRecent());
	}
	
	@Test
	public void testGet(){
		LRUCache lruCache = new LRUCache(3);
		lruCache.setCapacity(3);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.put(3, 3);
		Assert.assertEquals(3, lruCache.get(3));
	}
	
	@Test
	public void testGet_RemovedItem(){
		LRUCache lruCache = new LRUCache(3);
		lruCache.setCapacity(3);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.put(3, 3);
		lruCache.put(4, 4);
		Assert.assertEquals(-1, lruCache.get(1));
	}
	
	@Test
	public void testAddOverCapacity(){
		LRUCache lruCache = new LRUCache(3);
		lruCache.setCapacity(3);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.put(3, 3);
		lruCache.put(4, 4);
		Assert.assertEquals(4, lruCache.getRecent());
		Assert.assertEquals(2, lruCache.getOldest());
	}
	
	@Test
	public void testMoveToRecents(){
		LRUCache lruCache = new LRUCache(3);
		lruCache.setCapacity(3);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.get(1);
		lruCache.put(3, 3);
		lruCache.put(4, 4);
		Assert.assertEquals(4, lruCache.getRecent());
		Assert.assertEquals(1, lruCache.getOldest());
	}
	
	@Test
	public void testMoveToRecents_2(){
		LRUCache lruCache = new LRUCache(3);
		lruCache.setCapacity(3);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.put(3, 3);
		lruCache.get(1);
		lruCache.get(2);
		lruCache.put(4, 4);
		lruCache.get(2);
		Assert.assertEquals(2, lruCache.getRecent());
		Assert.assertEquals(1, lruCache.getOldest());
	}
}

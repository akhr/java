package com.akh.java_concepts_test.hashMapTest;

import java.util.*;

public class JHashMap<K, V> implements Map<K, V> {

	List<Entry<K,V>> dataList = new ArrayList<>();
	int size = 0;

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		K k1 = (K)key;
		int hash = k1.hashCode();
		int bucketIndex = hash % dataList.size();
		Entry<K,V> entry = dataList.get(bucketIndex);
		if(entry.getKey().equals(k1) && entry.getKey().hashCode() == k1.hashCode()){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean containsValue(Object value) {
		return false;
	}

	@Override
	public V get(Object key) {
		K k1 = (K)key;
		int hash = k1.hashCode();
		int bucketIndex = hash % dataList.size();
		return dataList.get(bucketIndex).getValue();
	}

	@Override
	public V put(K key, V value) {
		K k1 = (K)key;
		int hash = k1.hashCode();
		int bucketIndex = hash % dataList.size();
		Entry<K,V> entry = new AbstractMap.SimpleEntry<>(key, value);
		dataList.add(bucketIndex, entry);
		return value;
	}

	@Override
	public V remove(Object key) {
		K k1 = (K)key;
		int hash = k1.hashCode();
		int bucketIndex = hash % dataList.size();
		Entry<K,V> entry = dataList.get(bucketIndex);
		dataList.remove(bucketIndex);
		return entry.getValue();
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {

	}

	@Override
	public void clear() {

	}

	@Override
	public Set<K> keySet() {
		return null;
	}

	@Override
	public Collection<V> values() {
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return null;
	}
}

/**
 * 
 */
package com.ak.eventBusImpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Akhash Ramamurthy
 *
 * Apr 5, 2016 11:35:39 AM
 * EventBus.java
 */
public class EventBus {
	private Map<String, Set<Listener>> listenersMap;

	public EventBus(){
		listenersMap = new HashMap<String, Set<Listener>>();
	}

	public void register(String eventName, Listener listener) {
		Set<Listener> listeners = null;
		if(listenersMap.get(eventName) == null){
			listeners = new HashSet<Listener>();
		}
		listeners.add(listener);
		listenersMap.put(eventName, listeners);
	}

	public void unregister(String eventName, Listener listener) {
		if(listenersMap.get(eventName) != null){
			Set<Listener> listeners = listenersMap.get(eventName);
			if(listeners.contains(listener))
				listeners.remove(listener);
		}
	}

	public void postEvent(String eventName, Object data) {
		Set<Listener> listeners;
		if(listenersMap.get(eventName) != null){
			listeners = listenersMap.get(eventName); 
			for(Listener listener:listeners){
				listener.onEvent(data);
			}
		}
	}

	public interface Listener {
		void onEvent(Object data);
	}

}

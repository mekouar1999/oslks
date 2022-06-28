package com.scrabble.websocket;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

public class Group {
	private String id;
	private List<Socket> list;
	private Hashtable<String, Socket> map;
	
	public Group(String id) {
		this.id = id;
		list = new Vector<Socket>();
		map = new Hashtable<String, Socket>();
	}
	
	public void add(Socket s) {
		if (map.get(s.getSessionId()) == null) {
			list.add(s);
			map.put(s.getSessionId(), s);
			s.setGroup(this);
		}
	}
	
	public void emit(String event, String data) {
		for (Socket socket : list) {
			socket.emit(event, data);
		}
	}
	
	public boolean contains(String sessionId) {
		return (map.get(sessionId) != null);
	}
	
	public String getId() {
		return id;
	}
	
	public int size() {
		return list.size();
	}
	
	public String toString() {
		return "Group " + id + ", size : " + list.size();
	}
	
	public List<Socket> getList() {
		return list;
	}
}

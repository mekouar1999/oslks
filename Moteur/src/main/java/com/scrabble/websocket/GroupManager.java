package com.scrabble.websocket;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

public class GroupManager {
	private List<Group> groupList;
	private Hashtable<String, Group> sessionGroup;
	private int maxGroupSize = 0;
	
	public GroupManager() {
		groupList = new Vector<Group>();
		groupList.add(new Group("G1"));
		sessionGroup = new Hashtable<String, Group>();
	}
	
	public void setMaxGroupSize(int maxGroupSize) {
		this.maxGroupSize = maxGroupSize;
	}
	
	public int getMaxGroupSize() {
		return maxGroupSize;
	}
	
	public Group add(Socket socket) {
		Group group = groupList.get(groupList.size() - 1);
		if (group.size() >= maxGroupSize && maxGroupSize != 0) {
			group = new Group("G" + (groupList.size() + 1));
			groupList.add(group);
		}
		group.add(socket);
		sessionGroup.put(socket.getSessionId(), group);
		return group;
	}
	
	public Group getSessionGroup(String sessionId) {
		return sessionGroup.get(sessionId);
	}
}

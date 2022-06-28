package com.scrabble.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

public class Socket {
	private WebSocketSession session;
	private Message message;
	private Group group = null;

	public Socket(WebSocketSession session, Message message) {
		super();
		this.session = session;
		this.message = message;
	}
	
	public Socket(WebSocketSession session, Message message, Group group) {
		super();
		this.session = session;
		this.message = message;
		this.group = group;
	}

	public WebSocketSession getSession() {
		return session;
	}

	public String getSessionId() {
		return session.getId();
	}

	public Message getMessage() {
		return message;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public void emit(String event, String data) {
		emit(new Message(event, data));
	}
	
	public void emit(Message m) {
		try {
			session.sendMessage(new TextMessage(m.toJSON()));
		}
		catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

	public void emitToGroup(String event, String data) {
		if (group != null) {
			group.emit(event, data);
		}
	}
}

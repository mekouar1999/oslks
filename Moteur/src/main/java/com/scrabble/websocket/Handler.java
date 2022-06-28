package com.scrabble.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.Hashtable;
import java.util.function.Consumer;

public class Handler {
	private ObjectMapper mapper;
	private Hashtable<String, Consumer<Socket>> actions;
	private String paths[] = {"/"};
	private GroupManager groupManager;
	
	public Handler() {
		actions = new Hashtable<String, Consumer<Socket>>();
		mapper = new ObjectMapper();
		groupManager = new GroupManager();
	}
	
	public void setUrlPaths(String... paths) {
		this.paths = paths;
	}

	public String[] getUrlPaths() {
		return paths;
	}
	
	public void setMaxGroupSize(int size) {
		groupManager.setMaxGroupSize(size);
	}
	
	public int getMaxGroupSize() {
		return groupManager.getMaxGroupSize();
	}
	
	public void on(String event, Consumer<Socket> action) {
		 actions.put(event, action);
	}
	
	public void onConnection(Socket socket) {
		//groupManager.add(socket);
	}
	
	private class DefaultHandler extends AbstractWebSocketHandler {
		
		public DefaultHandler() {
		}

		public void afterConnectionEstablished(WebSocketSession session) throws Exception {
			System.out.println(">>> Connection Established : " + session.getId());
			onConnection(new Socket(session, null));
		}

		public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
			Message m = mapper.readValue("" + message.getPayload(), Message.class);
			Socket s = new Socket(session, m);//, groupManager.getSessionGroup(session.getId()));
			
			Consumer<Socket> action = actions.get(m.getEvent());
			if (action != null) {
				action.accept(s);
			}
		}
		
	}
	
	public Group addToGroup(Socket socket) {
		return groupManager.add(socket);
	}
	
	public WebSocketHandler getDefaultHandler() {
		return new DefaultHandler();
	}
}

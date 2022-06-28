package com.scrabble.websocket;

//import com.fasterxml.jackson.databind.ObjectMapper;

public class Message {
	private String event;
	private String data;
	
	public Message() {
	}
	
	public Message(String event, String data) {
		super();
		this.event = event;
		this.data = data;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Message [event=" + event + ", data=" + data + "]";
	}
	
	public String toJSON() {
		// ObjectMapper mapper = new ObjectMapper();
		// String s = mapper.writeValueAsString(this);
		// return s;
		return "{\"event\":\"" + event +"\",\"data\":\"" + data + "\"}";
	}
	
}

package com.scrabble.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import java.util.List;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	@Autowired
	private List<Handler> handlers;
	
	public WebSocketConfig() {
	}
	
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		for (Handler handler : handlers) {
			registry.addHandler(handler.getDefaultHandler(), handler.getUrlPaths());	
		}
	}
}

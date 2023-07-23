package com.example.web.socket.SocketChat.webSocket;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler{
	@Autowired
	MessageHandler messageHandler;
	
	
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		SessionManager.addWebSocketSession(session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		session.close();
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {
		for(String s:session.getAttributes().keySet()) {
			System.out.println(s);
		}
		
	    //sender.send(topic, textMessage.getPayload());
	}
	
	
}

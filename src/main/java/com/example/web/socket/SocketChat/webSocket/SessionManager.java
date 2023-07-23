package com.example.web.socket.SocketChat.webSocket;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

public class SessionManager {
	private static Map<String,WebSocketSession> mSession = new HashMap<>();
	
	public static void addWebSocketSession(WebSocketSession session) {
		if(mSession.get(session.getId())==null) {
			mSession.put(session.getId(), session);
		}else {
			mSession.remove(session.getId());
			mSession.put(session.getId(), session);
		}
	}
	
	public static WebSocketSession getWebSocketSession(String key) {
		return mSession.get(key);
	}
	
	public static String[] getSockets() {
		return (String[]) mSession.keySet().toArray();
	}
	
	public static void sendMessageToUser(String message,String key) {
		try {
			mSession.get(key).sendMessage(new TextMessage(message));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

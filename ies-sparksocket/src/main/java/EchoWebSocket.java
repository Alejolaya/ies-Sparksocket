import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

@WebSocket
public class EchoWebSocket {
	//store sessions
	private static final Queue<Session> sessions = new ConcurrentLinkedQueue<>();
	
	
	
	public static synchronized final Queue<Session> getSessions() {
		return sessions;
	}

	@OnWebSocketConnect
	public void connected(Session session) {
		sessions.add(session);
		System.out.println("Estan conectados por websocket");
		try {
			session.getRemote().sendString("Iniciando coneccion\n\t");
			session.getRemote().sendString("helloWorld");
			for (int i=0; i<1000;i++) {
				session.getRemote().sendString("hola de nuevo numero: "+i+session.getRemote().getInetSocketAddress().toString());
				;
				Thread.sleep(2000);
			}
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@OnWebSocketClose
	public void closed(Session session,int statusCode, String reason) {
		sessions.remove(session);
		System.out.println("Estan desconectados del websocket");
	}
	
	@OnWebSocketMessage
	public void message(Session session, String message) throws IOException{
		System.out.println("Estado de mensajes de websocket");
		System.out.println("Got: " + message);
		session.getRemote().sendString("Hola este es un mensaje predeterminado");
		try {
		session.getRemote().sendString(message);
		session.getRemote().sendString("hola de nuevo");
		session.getRemote().sendString("bai");
		for (int i=0; i<1000;i++) {
			session.getRemote().sendString("hola de nuevo numero: "+i);
			Thread.sleep(2000);
		}
		}catch(Exception e) {
			
		
		
		}
		
	}
}

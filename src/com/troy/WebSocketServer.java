package com.troy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import weblogic.websocket.ClosingMessage;
import weblogic.websocket.WebSocketAdapter;
import weblogic.websocket.WebSocketConnection;
import weblogic.websocket.annotation.WebSocket;


@SuppressWarnings("deprecation")
@WebSocket ( 
  pathPatterns = {"/tail/*"}
)
public class WebSocketServer extends WebSocketAdapter {
	
	FileReader fr;
	BufferedReader br;

	@SuppressWarnings("deprecation")
	@Override
	public void onMessage(WebSocketConnection connection, String payload) {
	  try {
		  fr = new FileReader(payload);
		  br = new BufferedReader(fr);
		  
		  connection.send("[TROY] Tailing log : " + payload);
		  
		  while (true) 
		  {
		    String line = br.readLine();
		    if (line == null)
		      {
		        Thread.sleep(1*1000);
		      } 
		      else
		      {
		        System.out.println(line);
		        connection.send(line);
		        line=null;
		      }
		    }
		  
	  } 
	  catch (Exception ex) {
		  ex.printStackTrace();
	  } 
   }

	@Override
	public void onClose(WebSocketConnection connection, ClosingMessage msg) {
		super.onClose(connection, msg);
		try {
			connection.send("[TROY] Connection closed.");
			br.close();
			fr.close();
			connection.close(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onOpen(WebSocketConnection connection) {
		super.onOpen(connection);
		try {
			connection.send("[TROY] Connection established...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	  


}
package Serveur;

import java.net.*;
import java.util.LinkedList;
import java.io.*;

import Stockage.Stokage;
 
public class Serveur {
    public static void main(String[] args) throws IOException {
         
        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }
         
        int portNumber = Integer.parseInt(args[0]);
        System.out.println("Ready");
         
        try (
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
            Socket clientSocket = serverSocket.accept();     
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);                   
            BufferedReader in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
        ) 
        {	
        	
            String inputLine;
            Stokage store = new Stokage();
            
            while ((inputLine = in.readLine()) != null) {
	            	String resulat = null;
	                String[] listOfInput = inputLine.split(" ");
	                String cle = listOfInput[0];
	        		LinkedList<String> valeurs = new LinkedList<String>();
	        		for (int i=1;i<listOfInput.length;i++){
	        			valeurs.add(listOfInput[i]);
	        		}
	        		
	        		switch (cle) {
	        			case("GET"):
	        				resulat = store.GET(cle); 
	        				break;
	        				
	        			case("SET"):
	        				resulat = store.SET(cle, valeurs);
	        				break;
	        			
	        			case("SETNX"):
	        				resulat = store.SETNX(cle, valeurs);
        					break;
	        			
	        			case("DEL"):
	        				resulat = store.DEL(cle);
        					break;
        					
	        			case("LPUSH"):
	        				resulat = store.LPUSH(cle, valeurs);
        					break;
        					
	        			case("RPUSH"):
	        				resulat = store.RPUSH(cle, valeurs);
        					break;
	        			
	        			case("LLEN"):
	        				resulat = store.LLEN(cle);
        					break;
	        			
	        			case("LPOP"):
	        				resulat = store.LPOP(cle);
        					break;
	        			
	        			case("RPOP"):
	        				resulat = store.RPOP(cle);
        					break;
	        			
	        			case("LRANGE"):
	        				//resulat = store.LRANGE(cle, valeurs[0], valeurs[1]);
        					break;
	        			
	        			default:
	        					break;
	        		}
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
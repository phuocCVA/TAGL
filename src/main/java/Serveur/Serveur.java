package Serveur;

import java.net.*;
import java.util.LinkedList;
import java.io.*;

import Stockage.Stockage;
 
public class Serveur {
    public static void main(String[] args) throws IOException {
         
//        if (args.length != 1) {
//            System.err.println("Usage: java EchoServer <port number>");
//            System.exit(1);
//        }
//        
        String hostName = "localhost";
        int portNumber = Integer.parseInt(args[0]);
        System.out.println("Ready");
         
        try (
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();     
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);                   
            BufferedReader in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
        ) 
        {	
        	
            String inputLine ;
            inputLine = "SET connection 10";
            Stockage store = new Stockage();
            
            while ((inputLine != null)) {
	            	String resultat = null;
	            	
	                String[] listOfInput = inputLine.split(" ");
	                String commande = listOfInput[0];
	                String cle = listOfInput[1];
	        		LinkedList<String> valeurs = new LinkedList<String>();
	        		for (int i=2;i<listOfInput.length;i++){
	        			valeurs.add(listOfInput[i]);
	        		}
	        		
	        		switch (commande) {
		        		case("GET"):
		        			resultat = store.GET(cle); 
		        			break;
	
		        		case("SET"):
		        			for (int i=2;i<listOfInput.length;i++){
		        				String valeur = listOfInput[i];
		        				resultat = store.SET(cle, valeur);
		        			}
		        			break;
		        			
		        		case("SETNX"):
		        			for (int i=2;i<listOfInput.length;i++){
		        				String valeur = listOfInput[i];
		        				resultat = store.SETNX(cle, valeur);
		        			}
		        			break;
	
		        		case("SETX"):
		        			resultat = store.SETX(cle, valeurs);
		        			break;
	
		        		case("DEL"):
		        			resultat = store.DEL(cle);
		        			break;
	
		        		case("LPUSH"):
		        			for (int i=2;i<listOfInput.length;i++){
		        				String valeur = listOfInput[i];
		        				resultat = store.LPUSH(cle, valeur);
		        			}
		        			break;
	
		        		case("RPUSH"):
		        			for (int i=2;i<listOfInput.length;i++){
		        				String valeur = listOfInput[i];
		        				resultat = store.RPUSH(cle, valeur);
		        			}
		        			break;	
	
		        		case("LPUSHX"):
		        			resultat = store.LPUSHX(cle, valeurs);
		        			break;
	
		        		case("RPUSHX"):
		        			resultat = store.RPUSHX(cle, valeurs);
		        			break;
	
		        		case("LLEN"):
		        			resultat = store.LLEN(cle);
		        			break;
	
		        		case("LPOP"):
		        			resultat = store.LPOP(cle);
		        			break;
	
		        		case("RPOP"):
		        			resultat = store.RPOP(cle);
		        			break;
	
		        		case("LRANGE"):
		        			resultat = store.LRANGE(cle,valeurs.get(0),valeurs.get(1));
		        			break;

	        			default:
	        				System.out.println(resultat);
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
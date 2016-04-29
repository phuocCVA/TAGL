package Stockage;

import java.util.Hashtable;
import java.util.LinkedList;

public class Stokage {
	
	public static final int MAX = 10;
	
	public Hashtable<String, LinkedList<String>> store;
	
	// Constructor
	public Stokage(){
		if(store == null) store = new Hashtable<String, LinkedList<String>>();
	}
	
	/**
	 * 
	 * @param cle
	 * @param valeur
	 */
	public String SET (String cle, LinkedList<String> valeur){
		String res = "";
		if(!cle.equals("")){			
			if(store.containsKey(cle)){
				store.get(cle).clear();
				store.get(cle).addAll(valeur);
			}
			else{
				store.put(cle, valeur);
			}
			res = "Success !!!" ;
		}
		else res = "La cles est null !!!";
		
		return res;
	}
	
	/**
	 * 
	 * @param cle
	 * @param valeur
	 */
	public String SETNX (String cle, LinkedList<String> valeur){
		String res = "";
		if(!cle.equals("")){
			if(store.containsKey(cle)){
				res = ("La cle existe deja !!!");
			}
			else{
				store.put(cle, valeur);
				res = ("Sucess !!!");
			}
		}
		return res;
	}
	
	/**
	 * 
	 * @param cle
	 * @return
	 */
	public String GET(String cle){
		String valeurs="";
		
		if(!cle.equals("")){
			if(store.containsKey(cle)){
				LinkedList<String> temp = store.get(cle);
			    for(int i = 0; i < temp.size(); i++){
			    	valeurs += temp.get(i);
			    }
			}
			else{
				valeurs = "La cle n'existe pas !!!";
				}
			
		}else{
			valeurs = ("La cle est null !!!");
		}
		return valeurs;
	}
	
	/**
	 * 
	 * @param cle
	 */
	public String DEL (String cle){
		String res = "";
		if(!cle.equals("")){
			if(store.containsKey(cle)){
				store.remove(cle);
				res = ("Success !!!");
			}
			
		} else{
			res = ("La cle est null !!!");
		}
		return res;
	}
	
	
	/**
	 * 
	 * @param cle
	 * @param valeur
	 */
	public String LPUSH(String cle, LinkedList<String> valeur){
		String res = "";
		if(!cle.equals("")){
			if(store.containsKey(cle)){
				for(int i=valeur.size();i>0;i--){
					store.get(cle).addFirst(valeur.get(i));
				}
			}
			else{
				store.put(cle, valeur);
			}
			res = "Success !!!";
		}else{
			res = ("La cle est null !!!");
		}
		return res;
	}
	
	/**
	 * 
	 * @param cle
	 * @param valeurs
	 */
	public String RPUSH(String cle, LinkedList<String> valeurs){
		String res = "";
		if(!cle.equals("")){
			if(store.containsKey(cle)){
				for(int i=0;i<valeurs.size();i--){
					store.get(cle).addLast(valeurs.get(i));
				}
			}
			else{
				store.put(cle, valeurs);
			}
			res = "Success !!!";
		}else{
			res = ("La cle est null !!!");
		}
		return res;
	}
	
	/**
	 * 
	 * @param cle
	 * @return
	 */
	public String LLEN(String cle){
		String result = "La liste " + cle + " a " + store.get(cle).size() + "elements";
		return result;
	}
	
	/**
	 * 
	 * @param cle
	 * @return
	 */
	public String LPOP(String cle){
		String res = "";
		if(!cle.equals("")){
			if(store.containsKey(cle)){
				store.get(cle).removeFirst();
				res = ("Success !!!");
			}
			else{
				res = ("La cle n'exsite pas !!!");
			}
		}else{
			res = ("La cle est null !!!");
		}
		return res;
	}
	
	/**
	 * 
	 * @param cle
	 * @return
	 */
	public String RPOP(String cle){
		String res = "";
		if(!cle.equals("")){
			if(store.containsKey(cle)){
				store.get(cle).removeLast();
				res = "Success !!!";
			}
			else{
				res = ("La cle n'exsite pas !!!");
			}
		}else{
			res = ("La cle est null !!!");
		}
		return res;
	}
	
	/**
	 * 
	 * @param cle
	 * @return
	 */
	public String LRANGE(String cle, String begin, String end){
		String valeurs = "";
	    
		int b = Integer.parseInt(begin);
		int e = Integer.parseInt(end);
		
		if(!cle.equals("")){
			if(store.containsKey(cle)){
				for(int i=b; i<=e; i++){
					valeurs += store.get(cle).get(i)+" ";
				}
			}
			else{
				System.out.println("La cle n'exsite pas !!!");
			}
		}else{
			System.out.println("La cle est null !!!");
		}

		return valeurs;
	}
}

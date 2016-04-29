package Stockage;

import java.util.Hashtable;
import java.util.LinkedList;

public class Stockage {
	
	public static final int MAX = 10;
	
	public Hashtable<String, LinkedList<String>> store;
	
	// Constructor
	public Stockage(){
		if(store == null) store = new Hashtable<String, LinkedList<String>>();
	}
	
	/**
	 * Store the value to the key
	 * @param cle
	 * @param valeur
	 */
	public String SET (String cle, String valeur){
		String res = "";
		if(!cle.equals("")){			
			if(store.containsKey(cle)){
				store.get(cle).clear();
				store.get(cle).add(valeur);
			}
			else{
				LinkedList<String> valeurs = new LinkedList<String>();
				valeurs.add(valeur);
				store.put(cle, valeurs);
			}
			res = "Success !!!" ;
		}
		else res = "La cles est null !!!";
		
		return res;
	}
	
	/**
	 * Set a list of value to the key
	 * @param cle
	 * @param valeur
	 * @return
	 */
	public String SETX (String cle, LinkedList<String> valeur){
		String res = "";
		if(!cle.equals("")){
			if(store.containsKey(cle)){
				res = ("La cle existe deja !!!");
			}
			else{
				store.put(cle, valeur);
				res = ("Success !!!");
			}
		}
		return res;
	}
	
	/**
	 * Store the value to the key if the key is not exists
	 * @param cle
	 * @param valeur
	 */
	public String SETNX (String cle, String valeur){
		String res = "";
		if(!cle.equals("")){
			if(store.containsKey(cle)){
				res = ("La cle existe deja !!!");
			}
			else{
				LinkedList<String> valeurs = new LinkedList<String>();
				valeurs.add(valeur);
				store.put(cle, valeurs);
				res = ("Success !!!");
			}
		}
		return res;
	}
	
	/**
	 * Get values of the key
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
	 * Atomically increment a number stored at a given key
	 * @param cle
	 * @return
	 */
	public String INCR(String cle){
		String resultat = "";
		if(!cle.equals("")){
			if(store.containsKey(cle)){
				String v = String.valueOf(store.get(cle).getFirst());
				try{
					int x = Integer.parseInt(v);
					x+=1;
					SET(cle,String.valueOf(x));
					
				}catch(NumberFormatException x){
					throw x;
				}
				resultat = store.get(cle).toString();
			}
			else{
				SET(cle,"1");
				resultat = store.get(cle).toString();
				}
			
		}else{
			resultat = ("La cle est null !!!");
		}
		return resultat;
	}
	/**
	 * delete a given key and associated value
	 * @param cle
	 */
	public String DEL(String cle){
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
	 * puts the new value at the start of the list.
	 * @param cle
	 * @param valeur
	 * @return
	 */
	public String LPUSH(String cle, String valeur){
		String res = "";
		if(!cle.equals("")){
			if(store.containsKey(cle)){
				store.get(cle).addFirst(valeur);
			}
			else{
				LinkedList<String> valeurs = new LinkedList<String>();
				valeurs.add(valeur);
				store.put(cle, valeurs);
			}
			res = store.get(cle).toString();
		}else{
			res = ("La cle est null !!!");
		}
		return res;
	}
	
	/**
	 * puts the new value at the end of the list.
	 * @param cle
	 * @param valeurs
	 */
	public String RPUSH(String cle,String valeur){
		String res = "";
		if(!cle.equals("")){
			if(store.containsKey(cle)){
				store.get(cle).addLast(valeur);
			}
			else{
				LinkedList<String> valeurs = new LinkedList<String>();
				valeurs.add(valeur);
				store.put(cle, valeurs);
			}
			res = store.get(cle).toString();
		}else{
			res = ("La cle est null !!!");
		}
		return res;
	}
	
	/**
	 * puts a list of new values at the start of the list.
	 * @param cle
	 * @param valeur
	 */
	public String LPUSHX(String cle, LinkedList<String> valeur){
		String res = "";
		if(!cle.equals("")){
			if(store.containsKey(cle)){
				for(int i=valeur.size()-1;i>=0;i--){
					store.get(cle).addFirst(valeur.get(i));
				}
			}
			else{
				store.put(cle, valeur);
			}
			res = store.get(cle).toString();
		}else{
			res = ("La cle est null !!!");
		}
		return res;
	}
	
	/**
	 * puts a list of new values at the end of the list.
	 * @param cle
	 * @param valeurs
	 */
	public String RPUSHX(String cle, LinkedList<String> valeurs){
		String res = "";
		if(!cle.equals("")){
			if(store.containsKey(cle)){
				for(int i=0;i<valeurs.size();i++){
					store.get(cle).addLast(valeurs.get(i));
				}
			}
			else{
				store.put(cle, valeurs);
			}
			res = store.get(cle).toString();
		}else{
			res = ("La cle est null !!!");
		}
		return res;
	}
	
	/**
	 * returns the current length of the list.
	 * @param cle
	 * @return
	 */
	public String LLEN(String cle){
		String result = "La liste " + cle + " a " + store.get(cle).size()+" elements";
		return result;
	}
	
	/**
	 * removes the first element from the list and returns it.
	 * @param cle
	 * @return
	 */
	public String LPOP(String cle){
		String res = "";
		if(!cle.equals("")){
			if(store.containsKey(cle)){
				store.get(cle).removeFirst();
				res = store.get(cle).toString();
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
	 * removes the last element from the list and returns it.
	 * @param cle
	 * @return
	 */
	public String RPOP(String cle){
		String res = "";
		if(!cle.equals("")){
			if(store.containsKey(cle)){
				store.get(cle).removeLast();
				res = store.get(cle).toString();
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
	 * gives a subset of the list
	 * @param cle
	 * @return
	 */
	public String LRANGE(String cle, String begin, String end){
		 LinkedList<String> valeurs = new  LinkedList<String>();
	    
		int b = Integer.parseInt(begin)-1;
		int e = Integer.parseInt(end)-1;
		
		if(!cle.equals("")){
			if(store.containsKey(cle)){
				for(int i=b; i<=e; i++){
					valeurs.add(store.get(cle).get(i));
				}
			}
			else{
				System.out.println("La cle n'exsite pas !!!");
			}
		}else{
			System.out.println("La cle est null !!!");
		}

		return valeurs.toString();
	}
}

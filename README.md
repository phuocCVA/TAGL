# PROJECT TAGL

 Des services simples de stockage cle-valeur
 
 
# Fonctionnalies fournies 
 
-	D’abord, j’ai implémenté un serveur pour construire gestionnaire de stockage clé/valeur multithreads. Les clients connectent au serveur par l’adresse du serveur et aussi un numéro de port.
-	Le système permet de manipuler les structures de données complexe (Integer, String, des listes des valeurs...) par les fonctions suivantes : <br>
          GET  ---->Return les valeurs associent à une clé donnes. <br>
          SET	 ---->Ajoute la valeur à la clé. Si la clé existe déjà, l’ancienne valeur sera remplacée. <br>
          SETX ---->	    Ajoute une liste des valeurs à la clé. <br>
          SETNX ---->	    Ajoute la valeur à la clé seulement si la clé n’existe pas. <br>
          DEL ---->	      Supprimer la valeur associée à la clé.<br>
          INCR ---->	    Incrémenter la valeur associée à la clé. <br>
          RPUSH ---->     Ajoute une value à la fin d’une liste associée à la clé <br>
          RPUSHX ---->    Ajoute une liste des values à la fin d’une liste associée à la clé <br>
          LPUSH---->	    Ajoute une value au début d’une liste associée à la clé <br>
          LPUSHX---->    Ajoute une liste des values au début d’une liste associée à la clé <br>
          RPOP---->	    Envoie le dernier élément de la liste associée à la clé <br>
          LPOP---->	    Envoie le premier élément de la liste associée à la clé <br>
          LLEN---->	    Envoie la taille de la liste associée à la clé <br>
          LRANGE---->   Envoie la liste des valeurs entre les indexes début et fin d’une liste associée à la clé <br>

  Chaque fonctions fournira des exceptions aussi (la clé n’existe pas, est null…)
  
-	Les fonctions ont été valide par des test unitaires. 

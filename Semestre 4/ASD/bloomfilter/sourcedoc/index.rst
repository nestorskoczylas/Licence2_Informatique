---------------
 tp-bloom
---------------


.. toctree::
   :maxdepth: 1

   hash_functions.rst
   bloomfilter.rst
   

~~~~~~~~~~
Etat du TP
~~~~~~~~~~

Vasco_Lucas Skoczylas_Nestor

~~~~~~~~~~~~~~~~~~~~~~
Réponses aux questions
~~~~~~~~~~~~~~~~~~~~~~


Question 4.3.3
--------------
.. image :: ../src/tp4.png

Question 4.3.4
--------------

On remarque que plus la taille du filtre est petite plus le nombre de faux positifs est élevé. On peut associer ceci au fait que plus le filtre est petit, plus il y'a de chance pour que la fonction de hachage lors de la recherche tombe uniquement sur des cases contenant True ce qui faussera la recherche de cette valeur lors de l'utilisiation de contains(). 
Ceci implique également que plus il y a de fonction de hachage, plus le filtre doit être grand pour éviter qu'un mot ne remplisse tout le filtre en y ajoutant trop d'élement.
 

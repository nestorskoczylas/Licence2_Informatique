# l2s4-projet-2021

# Equipe

* Alexandre LEDUN
* Théo SERRA
* Nestor SKOCZYLAS
* Lucas VASCO

# Sujet

[Le sujet 2021](https://www.fil.univ-lille1.fr/~varre/portail/l2s4-projet/sujet2021.pdf)

# **Exécution des programmes et commandes Make**

* `make` : compile la source (`/classes`), puis crée les deux jars exigés (`/jar`)
* `make all` : exécute `make jars` puis `make doc`
* `make jars` : compile la source puis crée les deux jars exigés + deux jars avec stratégie humaine (InputStrategy)
* `make agricole.jar`, `make guerre.jar`, `make inputGuerre.jar`, `make inputAgricole.jar`  : créent uniquement le jar correspondant
* `make cls` : compilation de tous les `/src`, mais pas les `/tests`
* `make clseco` : compile uniquement la source liée au jeu agricole
* `make clswar` : compile uniquement la source liée au jeu de guerre
* `make clsInputEco` : compile uniquement la source liée au jeu agricole avec un joueur humain
* `make clsInputWar` : compile uniquement la source liée au jeu de guerre avec un joueur humain
* `make doc` : création d'un dossier `doc` et contenant la javadoc, lisible dans `index.html`
* `make agricole`, `make guerre`, `make inputAgricole`, `make inputGuerre` : compilent la source et créent le jar correspondant, puis lancent le jeu avec 5 joueurs prédéfinis, avant de supprimer les sources compilées (le jar reste présent)
* `make runguerre` : lancement du jeu de guerre avec 5 joueurs prédéfinis (nécessite compilation et création du jar préalable)
* `make runagricole` : lancement du jeu agricole avec 5 joueurs prédéfinis (nécessite compilation et création du jar préalable)
* `make runInputGuerre` : lancement du jeu de guerre avec 5 joueurs prédéfinis le premier étant controlé par un humain (nécessite compilation et création du jar préalable)
* `make runInputAgricole` : lancement du jeu agricole avec 4 joueurs prédéfinis le premier étant controlé par un humain  (nécessite compilation et création du jar préalable)
* `make cleancls` : supprime les fichiers du dossier `/classes`
* `make cleandoc` : supprime le dossier `/doc`
* `make cleanjars` : supprime les 2 jars
* `make clean` : supprime les fichiers compilés et la documentation

## Suggestion d'enchaînement de commandes Make

* Pour uniquement lancer l'un ou l'autre jeu avec 5 joueurs prédéfinis, entrez directement :

``` bash
$ make agricole
```

...ou :

``` bash
$ make guerre
```

* Sinon, pour une lecture de la javadoc ainsi qu'une exécution manuelle des fichiers GameMain (créés dans le dossier `/classes`), afin de tester la personnalisation des joueurs :

``` bash
$ make all
```

* Après avoir lancé une des trois commandes ci-dessus, vous pouvez lancer les programmes avec 5 joueurs prédéfinis :

``` bash
$ make runguerre
```

``` bash
$ make runagricole
```

* Enfin, pour nettoyer le répertoire :

``` bash
$ make clean
```

## Ajouts suplémentaires 

- Nous avons implémenté un affichage du plateau au début de chaque tour. `[P]` pour les tuiles de type Plaine, `[M]` pour les montagnes, etc...

- Dans ce projet, nous avons également ajouté la possibilité qu'une personne joue au jeu que ce soit contre l'ordinateur ou contre d'autre joueurs.

Les commandes permettant de tester cet ajout en créant une partie dont un joueur est humain et tout les autres sont contrôlés par l'ordinateur sont : 

```bash 
make inputAgricole
```
```bash 
make inputGuerre
```

- Dans le cas ou l'on ne passerait pas par le MakeFile pour lancer le jar, il est à noter que le premier nom entré en paramètre sera le nom du personnage contrôlé par le joueur et tout les autres nom seront des personnages contrôlés par l'ordinateur.

# **Livrables**

* Les trois UML sont lisibles dans le dossier `/captures_UML`
* Premier UML : `Unit`, `Army`, `Worker`
* Deuxième UML : `BoardGame`, `Fabrice`, `Cell`, `Resource`
* Troisième UML : `Game`, `Player`, `Move`, `Strategy`

## ► **Livrable 1 : Modélisation des personnages**

### *Atteinte des objectifs*

* L'UML attendu pour ce livrable est terminé.
* La création d'une classe abstraite **Unit**, d'une classe **Army** et d'une classe **Worker**, permet la gestion des personnages.
* Les méthodes de ces classes et leurs tests sont codés, la javadoc est complète.

### *Difficultés restantes à résoudre*

* Aucune

## ► **Livrable 2 :  Modélisation du plateau**

### *Atteinte des objectifs*

* L'UML est terminé pour **Cell** (les tuiles) et **BoardGame** (les plateaux), ainsi que les **Fabrices** (qui déterminent les règles de création de tuile) et les **Resource** (récoltées sur les tuiles).
* La création de l'interface **Fabrice** appelée par **BoardGame** permet de déterminer les règles du jeu à appliquer. **FabriceEcolo** pour le jeu de dévelopement agricole, et **FabriceArmy** pour le jeu de guerre.
* Les méthodes de ces classes et leurs tests sont codés, la javadoc est complète.

### *Difficultés restantes à résoudre*

* Aucune

## ► **Livrable 3 : Modélisation des actions**

### *Atteinte des objectifs*

* L'UML ainsi que la modélisation sont traités.
* Les **Player** (joueurs) sont construits avec une **Strategy** (stratégie) spécifique, qui sera de type **RandomStrategy** pour des choix aléatoires, ou **InputStrategy** pour des choix entrés dans la console par l'utilisateur. Ces stratégies détermineront le résultat à l'exécution des objets **Move** (actions). Enfin le **Game** déterminera quel **Move** est obligatoire ou non au cours d'une partie, et déterminera les spécificités du calcul du score des joueurs en fin de partie.
* Les méthodes de ces classes et leurs tests sont codés, la javadoc est complète.

### *Difficultés restantes à résoudre*

* Aucune

## ► **Livrable 4 : Modélisation complète**

### *Atteinte des objectifs*

* La modélisation et l'UML sont entièrement terminés. 
* Tous les codes sont fonctionnels et testés, la javadoc est complétée.
* Les deux jeux sont fonctionnels, et des *main* ont été codés pour les deux types de jeux, ainsi que pour les deux types de stratégies.

### *Difficultés restantes à résoudre*

* Aucune

# **Journal de bord**

## ⇒ **Semaine 1**

**4 et 5 février : Travail uniquement sur l'UML**

* L'UML pour **Boardgame** est en partie réalisé à l'issue de la séance. Il reste à déterminer une grande partie des méthodes pour chaqu'une des classes.
* Les tuiles, les personnages, les plateaux, le joueur et le jeu sont en grande partie détaillés. Ils comprennent attributs, hiérarchie, choix des méthodes.
* La gestion des **/moves**, actions des joueurs et/ou personnages, reste à déterminer. Toutefois, elles devraient être gérées par une interface.
* `Warrior` n'est pas une classe, mais un attribut de la classe **Army**, elle-même sous-classe de **Character**
* ... Ou **Army** est une classe avec en attribut une *liste* de Warrior?
* La gestion des **/ressources** n'est pas encore au point. Cependant, chaque ressource doit être gérée dans une classe séparée.
* Les `points` ont été renommé par `score`.

## ⇒ **Semaine 2**

**Travail avant la séance sur l'UML : dossier Characters et plusieurs questionnement, notamment sur les interactions entre Characters et certaines autres classes**

* Nous décidons de ne pas coder une classe à part Warrior.  Ils ne sont utilisés qu'autrement en tant qu'attribut de **Army**.
* Bien que `Gold` définisse notre Worker et notre Army, nous envisageons de ne pas l'inclure dans leur super classe **Character**. Cela laisse la possibilité de créer un nouveau personnage dont la quantité d'or ne sera pas un attribut.
* Les **Army** voient leur besoin (`need`) altéré par leur taille. Les **Worker** voient leur besoin en or altéré par la tuile (**Cell**) où ils se trouvent. Il reste à déterminer comment ce besoin peut-être altéré à chaque tour. De manière cohérente : le code dans les cellules? dans les ressources? dans les personnages? dans la classe gérant la partie (Game) ?...

**12 février : Deuxième séance de TP, travail sur l'UML et réflexions sur l'ensemble (notamment Player et Ressource)**

* **Character** est renommé **Unit** pour prévenir des conflits.
* L'attribut : `Gold : int`, est finalement intégré à la super classe **Unit**.
* Les besoins des **Unit** seront gérés ultérieurement. Inéluctablementpar les tuiles (**/cells**) qui auront un coût (*cost*), en or ou en nourriture, selon les jeux.
* La façon de gérer l'appartenance des **Unit** pour un **Player** pose question. 3 manières de gérer cela ont été suggérées par l'équipe :
  - Soit le player a une liste avec toutes ses **Unit**. On doit mettre à jour la liste à chaque fois qu'on retire une **Unit** ;
  - Soit le player a une `<Hashmap(cell,int)>` qui compte le nombre d'unités que le joueur a sur chaque type de case. On doit mettre à jour la hashmap à chaque fois qu'on place ou retire une unit ;
  - Soit à la fin de chaque tour on regarde TOUTES les cellules du board. Si il y a une unit on récupère sa **Team** avec `getTeam()`. On ajoute les ressources de la case en fonction ;
* Pour gérer le fait qu'un jeu impose un nombre maximum d'**Unit** par **Player**, là encore 2 propositions :
  - La mise en place de deux attributs dans **Player** : pour déterminer si le jeu impose ou non un nombre maximum de personnages (comme c'est le cas dans le jeu de guerre). Si oui, un second attribut détermine le nombre ;
  - Création d'une super classe **Player**, avec une sous-classe par type de jeu ;
* Redéfinition de l'utilisation des classes **Ressources** : une "valeur" absolue, qu'on peut ensuite utiliser soit en tant qu'or, soit en tant que nourriture (, soit telle quelle pour compter les points en fin de partie?).

## ⇒ **Semaine 3**

**Travail avant la séance sur l'UML : code d'Unit et ses sous-classes, et réflexion sur Cell et Board**

* Ajout du code des Unit comportant les tests et les classes, ainsi que la modélisation des Board et la fin de la modélisation des Cell.
* Ajout de fonctions `equals` et `toString` pour Unit.

**19 février : Troisième séance de TP, travail sur l'UML, discussion sur la gestion des Unit par Player, ainsi que sur la gestion de l'aléatoire des Cell au sein d'un Board**

* Le choix de la gestion des Unit en attribut de Player s'est réduit à : 
  - soit une liste d'Unit ;
  - soit une vérification Cell par Cell du Board, tel que "*quelle Cell a quelle Unit*" puis à qui elle appartient etc ;

La seconde option, nous semble plus simple à mettre en oeuvre, à défaut d'être optimisée d'un point de vue calcul. Le choix définitif n'est pas encore fait. Dans les deux cas, nous pourrons récupérer la **Cell** (et ses attributs) à partir de l'**Unit** ou inversement.

* Nous avons décidé de donner deux sous-classes à **Player**. Une correspondant à un joueur du jeu de guerre. L'autre correspondant à un joueur du jeu de récolte. D'une part, cela permet d'éviter que deux joueurs d'un type différent se retrouvent dans une Game. D'autre part permet d'affiner la méthode deployUnit qui, dans le cas du jeu de guerre, doit préciser combien de soldats (`size`) possède l'objet **Army**.
* Un début de réflexion sur comment la création de chaque plateau sera gérée, à la création de l'objet Board. Il faudra à la fois correspondre à certains critères, par exemple pas plus de 30% des tuiles de type autre que Ocean. Tout en incluant une répartition aléatoire des types de cellules à des coordonnées aléatoires, pour que chaque partie ait lieu sur un plateau différent généré de manière méthodique.
* Elimination de quelques méthodes et attributs redondants, par exemple isBusy de Cell alors qu'une méthode listant les Unit placées sur la Cell est déjà prévue.

## ⇒ **Semaine 4**

**5 mars : Quatrième séance de TP, travail sur l'UML, discussion sur certaines méthodes de Cell et sur la création du Board en fonction des contraintes**

* Modification sur les classes **/cells** :
  - suppression de l'attribut ressource permettant de savoir quelle ressource donne la tuile en question. Ceci est maintenant géré en redéfinissant la méthode `getRessource()` dans les classes filles. Nous n'avons donc plus besoin d'aucun attribut pour définir le type de la tuile ;
  - ajout de gold et maxUnit dans le constructeur de **Cell**, nécesaire pour gérer le changement de ces valeurs en fonction du jeu ;
  - ajout d'une méthode `setCost()` permettant de modifier le coût d'une case. Elle sera utile notamment dans le **GameWar** où le prix change en fonction de la taille de l'unité ;
* Après discussion, nous avons conclu qu'il suffisait d'une seule classe **Board** pour les deux jeux. Celle-ci gèrant la répartiton des cases en fonction du pourcentage et de leurs voisines. La classe **fabrik** par jeu qui gére les attributs des tuiles en fonction du jeu (gold, cost, maxUnit, ...).
* Après une discussion sur l'algorithme de création du **Board**, nous avons choisi d'opérer ainsi :
  - Le plateau est d'abord rempli complétement d'océan ;
  - Puis 33% de cases non océan sont placées aléatoirement sur le **Board** ;
  - On vérifie que pour chaque case, si une tuile non océan n'est pas seule, sinon elle est supprimée ;
* Une discussion sur la nécessité de deux classes **Game** : une pour chaque jeu.
* Le choix sur la facon dont les unités de **Player** sont gérées, chaque **Player** aura une liste avec toutes ses unités.
* L'écriture du code et des tests de **Cell** ont commencé.
* Le début de l'écriture du code pour la création du **Board**; selon l'approche choisie.

## ⇒ **Semaine 5**

**12 mars : Cinquième séance de TP, travail sur l'UML, rajout d'une interface Fabric, travail sur code, doc et tests**

* La mise en application du **Board** unique, faisant appel à une interface **Fabric** qui gère la fonction `createCell()` dépendant des règles du jeu, et appelée par la fonction `defineCell()` de **BoardGame**.
* La compilations des codes et de la doc de **BoardGame** (notamment `initBoard()`) et de **Fabric**, `getAdjacentCell()` renvoie un tableau de 2 à 4 cellules, et de 0 à 2 "null", selon que la Cell considérée est sur un bord ou dans un coin du plateau. Le code semble cependant optimisable.

***Un tag a été appliqué sur le git à une version précédente de BoardGame incluant une version plus simple de getAdjacentCell, mais cette version fonctionnerait-elle en cas de cellule hors du plateau ?***

* La création d'une interface **Fabric** dédiée à la gestion de la méthode `createCell()` appelée par **BoardGame**, créera les tuiles selon les règles de chaque jeu. Nous avons fait le choix de mettre des constructeurs vides et de classes sans attributs.
* La complétion du code des **/resources** est réussi.
* L'ajout des **/cells** : Desert, Forest, Mountain, Ocean et Plain.

**13 mars : Résolution d'une centaine d'erreurs dans les codes de Cell, BoardGame, Unit; changement de getAdjacentCell**

* Une version de `getAdjacentCell()` renvoyant une liste de cellules plutôt qu'un array est implémentée sans provoquer d'erreurs. Cependant, les test restent à faire. On notera que la version précédente est gardée *au cas où*.
* Les codes des **/cells**, de **BoardGame**, de **Fabric** sont bientôt terminer. Toutefois, les test ne sont pas commencés.

## ⇒ **Semaine 6**

**19 mars : Sixième séance de TP, corrections sur l'UML, correction du code de Cell et ses sous-classes, complétion des tests pour les Ressources et les Cell; optimisation de l'interaction entre les classes Fabric et BoardGame**

* L'implémentation de l'optimisation proposée par vos soins a été réalisé avec succès :-)
* Un début de réflexion sur l'implémentation de deux sous-classes **Game** (une par jeu).
* Des corrections dans le code des Cell ont été réalisé, notamment le constructeur manquant la value.

## ⇒ **Semaine 7**

**26 mars : Semaine de DS... :'(**

## ⇒ **Semaine 8**

**2 avril : Septième séance de TP, réflexion sur l'implémentation de Game, des moves; et travail sur les tests**

* L'ajout des peudos codes du déroulement du **Game**.
* La complétion des tests de **/cells** et de **/fabrices** sont réussis avec succès.

## ⇒ **Semaine 9**

**9 avril : Huitième séance de TP, création d'un second UML, réflexions supplémentaire sur l'implémentation des moves et de stratégies**

* La création d'objets **Move** : **DeployArmy**, **DeployWorker**, **Harvest** (récolte des ressources), **Exchange** (conversion de ressources en l'élément requis par les **Unit**), **FixNeed** (retire les ressources nécessaires aux besoin dans la liste de ressources du joueur, ou appel `quit()` sur autant d'Unit que nécessaires) et **DoNothing**.
* La complétion de l'UML pour implémenter les **/strategy** est faites.

## ⇒ **Semaine 10**

**16 avril : Neuvième séance de TP, travail pour un premier lancement de game eco**

* Un briefing sur les stratégies et les actions est réalisé en début de séance.
* L'écriture complète des tests de **Deploy** et de **EcoPlayer** est fait.
* L'ajout de `List<Move> mandatoryMoves` dans **Game** contenant les actions (objets **Move**) que le joueur doit obligatoirement effectuer lors de son tour. Celle-ci vient en complément de la liste de moves classiques. Le fait d'utiliser ce système de liste, permet une grande flexibilité lors de la création potentielle de différents jeux.
* La création de la classe **GameEco** a été effectué.
* La création du Main pour lancer le jeu Eco est créé.
* La création d'un display pour debugging (affichage du board) est réalisé.
* La gestion de l'impossibilté de placer une unité sur l'ocean est maintenant effectué via le `maxUnit` de l'océan (égale à 0). Permettant ainsi, si l'on souhaite la possibilité de placer des unités dans l'eau. Par exemple, dans un prochain si l'on veut que les soldats partent à la mer.
* **En ce 16 avril 2021, à 9h34 précise, le tout premier lancement du jeu de développement agricole est fait !** Beaucoup d'erreurs sont à corriger, ce sera le début de la phase de debug.

## ⇒ **Semaine 11**

**20 avril : Discussion et réflexion supplémentaire sur les stratégies et les actions, ainsi que sur des choix faits auparavant**

* L'amorçage de la transformation de la `HashMap <Unit,Cell>` du **Player** en deux `ArrayLists <Unit>` et `ArrayLists <Cell>`, avec ce que cela implique sur le reste du code.
* Ajout d'une méthode `usableInThisGame()` dans les **/cells**, qui renvoie `False` si le `maxUnit` est mis à 0 lors de la création par le **Fabrice**. Précédemment, la différence entre les cellules Ocean et les autres se faisaient par la méthode `getResource()`, après discussion ce n'était pas pertinent.
* L'ajout d'une méthode `requiresSalary()` dans les **/units**, qui renvoie `False` chez **Army** (la nourriture donnée par le joueur est instantanément mangée...).
* Le découpage est effectué dans la méthode `execute()` de **FixNeed** en plusieurs plus petites méthodes, et dans la gestion des éléments qui y sont manipulés au cours d'un tour via certains attributs private.
* Le travail de correction de bugs sur les actions (au moins celles du jeu Eco) semble avoir porté ses fruits. Le jeu semble fonctionner comme prévu, du moins lors de l'utilisation de la stratégie aléatoire et avec deux joueurs. La complétion des tests unitaires permettra de confirmer cela.
* Mise à jour de l'UML lucidchart pour refléter les changements effectués à ce jour, ainsi que des corrections de certaines relations affichées en flèches pleines.
* Un UML créé via l'outil suggéré par Pr. Varré est fourni dans le dossier captures_UML, mais il nous semble difficile de faire un UML ordonné... Nous mettons aussi à jour l'UML sur lucidchart (en deux liens pour contourner la limite du nombre d'objets par projet en version gratuite)
- **A ce jour, le jeu Eco semble 100% fonctionnel en stratégie aléatoire. Le jeu War se lance, il reste à vérifier que les choses qui varient d'un jeu à l'autre sont bien appliquées et calculées.**

**23 avril : Dixième séance de TP, travail sur les tests, petites optimisations, tentatives de corrections d'erreurs**

* La transformation de la `HashMap <Resource,Integer>` du **Player** en `<String,ArrayList<Resource>>`. A chaque **Resource**, identifiée par un String "ID", est liée une liste de toutes les **Resources** de ce type possédée par le joueur. La taille de cette liste correspond donc au nombre de ces **Resources** possédées par le **Player**.
* Le travail sur les tests des **/players** progresse.
* La création d'un main **GameWar** pour voir l'étendue du travail nécessaire à son fonctionnement est créé.
* Une tentative de correction d'erreurs autour du FixNeed est en cours.

## ⇒ **Période de pause pédagogique**

* La refonte de la façon dont le score est calculé. Elle ne permettait pas de déterminer une situation d'égalité.
* Les corrections autour de la **RandomStrategy** sont faites.
* Les corrections des erreurs liées au **FixNeed** et au **DeployArmy** ont été faite. Le code source de chaque jeu semble 100% fonctionnel, du moins en stratégie aléatoire comme requis par le cahier des charges.
* La complétion des *Main* pour correspondre au cahier des charges a été réalisé.
* Le travail sur la javadoc et sur la mise en forme est en cours de progression.
* La création d'un `Makefile` et de fichiers `manifest` pour correspondre au cahier des charges ont été faite. Les commandes `make` possibles sont détaillées au début de ce `Readme`.

## ⇒ **Semaine 12**

* Peaufinages (implémentation de la différence entre *0 points* et *1 point* par exemple...)
* Corrections de dernières minutes (certaines règles avaient été oubliées)
* Validation des tests après chaque modification
* Complétion du readme, mise en forme de l'UML, complétion de la javadoc
* Ajout des *main* pour la **InputStrategy**, semblent fonctionnels; les commandes `Makefile` relatives ont été ajoutées et documentées en haut de ce README.md
* Vérification que les *main* se lancent correctement...
* Tout semble OK!

## Choses apprises durant ce beau projet

* "0" en anglais, c'est généralement pluriel.
* L'organisation c'est important et on est pas très forts pour ça :/
* Eclipse c'est bien !
* Faire le journal de bord très régulièrement et si possible à plusieurs simplifie la vie.
* Faut tout noter sinon on oublie tout (vive les post-it X) ).
* Faire les choses dans l'ordre, on n'en comprend l'importance que quand il est trop tard...

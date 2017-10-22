# AMT - Projet 1 - Nackeskratta

## Description du projet

Ce projet a pour but de fournir une console web de gestion de meuble Ikea. Il est possible de lister, insérer, éditer, supprimer et générer des meubles. Ce projet à été réalisé à l'aide de Java EE, ainsi que mysql.

## Exécuter l'application

Docker a été utilisé afin de pouvoir exécuter le serveur web facilement. 2 images docker ont été créées: 
    - mysql: base de donnée de base de notre application. Les tables sont créées automatiquement au build grâce au fichier _docker/mysql/src/ikea.sql_.
    - wildfly: serveur web java EE de notre application. A l'instanciation de l'image docker, le .war (dans le dossier _docker/wildfly/data_) correspondant à notre application est automatiquement monté. Le fichier de configuration associé ainsi que le driver mysql sont aussi déployés.

Afin d'exécuter notre application, il suffit de faire un _docker-compose up --build_ depuis le dossier _/docker_. Pour tester l'application, il faut se rendre sur http://<docker machine ip>:8080/Nackeskratta-1.0-SNAPSHOT, soit, par défaut, http://192.168.99.100:8080/Nackeskratta-1.0-SNAPSHOT

On arrive premièrement sur la page d'accueil listant les meubles, cependant, la base de donnée est pour le moment vide. Il est possible de générer un certain nombre de meuble grâce à la page de génération. On peut aussi insérer un nouveau meuble grâce à la page d'insertion. Afin d'éditer un meuble, il suffit de cliquer sur son nom depuis la page d'accueil, accessible via le bouton 'home' du haut. La page d'édition permet aussi de supprimer le meuble courant.

## Choix d'implémentation

Un design pattern multi-tiers MVC côté serveur a été utilisé. On peut trouver ci-dessous la structure de notre application, disponible dans le dossier _/Nackeskratta_:

![Files](/res/ProjectFiles.png)

    - Sources (_src/main/java/ch/heigvd/Nackeskratta_)
        - package _controllers_: endpoint de l'application, soit des servlets. Pour chaque requête, on utilisera les pages jsp présente dans WEB-INF. 
        - package _model_ : modèles de la base de données. Furniture représente un meuble. Sa catégorie, sa couleur et son matériel sont représenté à l'aide de modèle enum.
        - package _dao_ : les DAO de notre projet. Ici, il n'y en a qu'un, FurnituresManager. Celui-ci dialogue avec la datasource Ikea. On y exécute les requêtes SQL afin de récupérer la liste des meubles, insérer un nouveau meuble, etc.

    - Pages (_src/main/webapp_)
        - furnitures.jsp : listes des meubles, soit la page d'accueil de l'application. Celle-ci attend dans le _requestScope_ une liste de Furniture (ajouté via le servlet FurnituresServlet), qu'elle affichera. 
        - generate.jsp: permet de générer une liste de meuble. Le servlet associé accepte aussi les requêtes POST. Lorsqu'une telle requête arrive suite à une demande de génération de données, le servlet lance un thread en arrière plan qui génèrera les données afin de ne pas bloquer le serveur.
        - insert.jsp: permet d'insérer un nouveau meuble. Le servlet associé accepte aussi les requêtes POST, appelé au submit depuis le formulaire d'insertion.
        - edit.jsp: permet d'éditer un nouveau meuble. Le servlet associé accepte aussi les requêtes POST, appelé au submit depuis le formulaire d'édition. La page est pré-chargée avec les données du meuble à éditer. L'id du meuble à éditer est passé en paramètre de requête dans l'URL (edit?id=123)

Notons qu'il n'y a pas de page _delete.jsp_, mais seulement un servlet _DeletionServlet_ mappé sur _/delete_. Ce endpoint efface le meuble, et redirige l'utilisateur sur la page d'accueil.


## Build

    TODOOOOO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Ou ce n'est peut être pas important ?
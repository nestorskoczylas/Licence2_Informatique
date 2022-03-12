<?php
 // Inclusion de la bibliothèque de fonctions :
  require("lib/BookReader.class.php");
  require("lib/FileBookReader.class.php");
  require("lib/fonctionsLivre.php");
 
 // Lecture  du fichier et mémorisation dans des variables PHP :
  $reader = new FileBookReader('data/livres.txt');
  $bookHTML = libraryToHTML($reader);
 
 // inclusion de la page template :
  require('views/pageBibliotheque.php');
?>
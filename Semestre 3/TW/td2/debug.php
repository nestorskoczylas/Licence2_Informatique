<?php
/**
 * Indique au navigateur qu'il doit afficher du texte ordinaire, sans l'interpréter comme de l'HTML :
*/
header("Content-Type: text/plain;charset=UTF-8");

/**
 * Inclusion du fichier de définitions de fonctions :
 */
require("lib/BookReader.class.php");
require("lib/FileBookReader.class.php");
require_once("lib/fonctionsLivre.php");    // inclusion de fichier

/* Test question 1.1
 */

/* fonction de test
 *  reçoit comme argument un nom de fichier et affiche le résultat de readBook sur ce fichier
 */
function testReadBook($fileName){
    $dl = new FileBookReader($fileName);
    $book = $dl->readBook();
    echo "Résultat pour $fileName \n";
    print_r($book);
}




/*
 * Lancement des tests :
 */
// une description corretce de livre suivie de la fin de fichier
// doit produire un résultat correct
testReadBook('data/exempleLivre.txt');

// une description de livre,(avec des espaces inutiles) suivie d'une ligne vide puis d'un autre texte à ignorer
// doit produire un résultat correct
testReadBook('data/exempleLivre2.txt');

// une description de livre incorrecte (manque ':' en ligne 2)
// doit déclencher une exception
//testReadBook('data/exempleLivreErrone.txt');

function testelementbuilder(string $elementType,
                        string $content,
                        string $elementClass = ""){
 $s=elementBuilder($elementType,$content,$elementClass );
  echo "le resultat du test de la  fonction elementBuilder est : $s \n \n";}


testelementbuilder('p','bla bla');
testelementbuilder('h2','La marque du diable','titre');


function testauthorsToHTML(string $authors){
  $s=authorsToHTML($authors);
  echo "le resultat du test de la  fonction authorsToHTML est : $s \n \n";}


testauthorsToHTML('Marini - Desberg');

function testcoverToHTML(string $fileName){
$s=coverToHTML($fileName);
echo "le resultat du test de la  fonction coverToHTML est : $s \n \n";}

testcoverToHTML('scorpion.jpg');

function testpropertyToHTML(string $propName, string $propValue){
$s=propertyToHTML( $propName, $propValue);
echo "le resultat du test de la  fonction propertysToHTML est : $s \n \n";}

testpropertyToHTML('titre', 'La marque du diable');
testpropertyToHTML('auteurs', 'Marini - Desberg');

function testbookToHTML(string $fileName){
  $dl = new FileBookReader($fileName);
$book = $dl->readBook();
echo bookToHTML($book);}
testbookToHTML('data/exempleLivre.txt')."\n\n";


function testlibraryToHTML(BookReader $reader) {

echo libraryToHTML($reader)."\n\n";}
$d = new FileBookReader('data/livres.txt');
testlibraryToHTML($d);

/**
Voilà ce qui devrait s'afficher :
=================================

Résultat pour data/exempleLivre.txt
Array
(
    [couverture] => scorpion.jpg
    [titre] => La marque du diable
    [serie] => Le Scorpion
    [auteurs] => Marini - Desberg
    [année] => 2000
    [catégorie] => bandes-dessinées
)
Résultat pour data/exempleLivre2.txt
Array
(
    [couverture] => scorpion.jpg
    [titre] => La marque du diable
    [serie] => Le Scorpion
    [auteurs] => Marini - Desberg
    [année] => 2000
    [catégorie] => bandes-dessinées
)
<br />
<b>Fatal error</b>:  Uncaught Exception: .....etc ....


*/

?>

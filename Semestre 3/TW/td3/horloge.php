<?php

  require("lib/ParmsException.class.php");

  require("lib/fonctions_parms.php");
  require("lib/fonctions_clock.php");

/**
 * IMPORTANT :
 * Ce script n'est qu'une ébauche.
 *
 * En l'état actuel son fonctionnement n'est pas satisfaisant
 *
 *
 * Utiliser directement les variable du tableau $_GET peut être dangereux
 *
 * Ce script est à modifier et compléter au cours de l'exercice
 *
 *
try{
  // hours doit être un entier sans signe
  $hours = $_GET['hours'];

  // minutes doit être un entier sans signe
  $minutes = $_GET['minutes'];

  // seconds doit être un entier sans signe
  $seconds = $_GET['seconds'];
  if (ctype_digit($seconds) || $seconds =='') {
    if (isset($seconds) && $seconds !==''){
         $seconds = $_GET['seconds'];
       }
       else {
         $seconds = 0;
       }
     }
   else {
     throw new ParmsException();
   }

  // calcul des angles des aiguilles
  $angles = angles($hours, $minutes, $seconds);

  // inclusion de la page template :
  require('views/page.php');
}
 *
 */

try {
  // hours doit être un entier sans signe
  $hours = checkUnsignedInt("hours",0);

  // minutes doit être un entier sans signe
  $minutes = checkUnsignedInt("minutes",0);

  // seconds doit être un entier sans signe
  $seconds = checkUnsignedInt("seconds",0);

  // hands, bg, mark doit être une couleur définie dans lib/color_defs.php
  $hands = checkColor("color","black");

  $bg = checkColor("bg","transparent");

  $mark = checkColor("mark","slategrey");

  // calcul des angles des aiguilles
  $angles = angles($hours, $minutes, $seconds);

  // inclusion de la page template :
  require('views/page.php');
}
catch (ParmsException $e){
   require('views/pageErreur.html');
  }


?>

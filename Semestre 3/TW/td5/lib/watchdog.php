<?php

  /* Sentinelle :
   *  Pour un utilisateur non authentifi�, une page d'erreur est envoy�e et
   *  le script global est arr�t� d�finitivment (exit)
   *
   */


 //session_save_path(__DIR__);
 session_name('sesssyn');
 session_start();

 /**
  * test si le script s'ex�cute dans une session o� l'utilisateur s'est d�j� authentifi�
  * se fonde sur le t�moin d'authentification : $_SESSION['ident']
  */
 function alreadyLogged() : bool {
   return  isset($_SESSION['ident']);
 }

 /**
  * tente de r�aliser une nouvelle connexion
  * - si des identifiants valides ont �t� fournis dans $_POST, la connexion est r�ussie
  *    et l'identit� de l'utilisateur est rang�e dans $_SESSION['ident']
  * @param $authent_function  fonction d'authentification de profil  function(login, password) : Identite
  * @return false si connexion �chou�e, true si r�sussie
  */
 function tryConnect(callable $authent_function) : bool {
    if ( !isset($_POST['login']) || !isset($_POST['password']) ) // pas de login ou pas de password fourni => �chec
      return FALSE;

   $person = $authent_function($_POST['login'],$_POST['password']);
    if ($person === NULL) {// authentification en �chec
      $_SESSION['echec'] = TRUE;
      return FALSE;
   }
   // authentification r�ussie
    $_SESSION['ident'] = $person;
    $_SESSION['echec'] = NULL;
    return TRUE;
 }



 $my_authent = [$data,"authentification"];  // m�thode d'authentification �

 if (! alreadyLogged() && ! tryConnect($my_authent)){ // pas d�ja logg� et pas de connexion correcte
     require('views/pageLogin.php');
     exit; // Important !
 }
?>

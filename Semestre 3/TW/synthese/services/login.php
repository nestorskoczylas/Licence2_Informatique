<?php
set_include_path('..'.PATH_SEPARATOR);
spl_autoload_register(function ($className) {
     include ("lib/{$className}.class.php");
 });
require_once('lib/common_service.php');
require_once('lib/initDataLayer.php');
require('lib/fonctions_parms.php');
require('lib/watchdog.php');


try {
  $my_authent = [$data,"authentification"];
  $connexion= tryConnect($my_authent);
  if ($connexion){
    $res = array("login"=>$_SESSION['ident']->login,"nom"=>$_SESSION['ident']->nom,"prenom"=>$_SESSION['ident']->prenom);
    produceResult($res);
    exit();
  }
  else if(alreadyLogged()){
    produceError($_SESSION['ident']->name.", vous êtes connecté !");
    exit();
  }
  else{
    if($_SESSION['echec']){
      produceError("Le login et/ou le mot de passe n'existe pas et/ou incorrect.");
      exit();
    }
    else{
      produceError("Veuillez remplir les champs ci-dessus.");
      exit();
    }
   }
}
catch (ParmsException $e) {
    produceError($e->getMessage());
}
?>

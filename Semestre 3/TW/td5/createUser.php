<?php
spl_autoload_register(function ($className) {
     include ("lib/{$className}.class.php");
 });

try {
  require('lib/initDataLayer.php');
  require('lib/fonctions_parms.php');
  
   $login = checkConnexion("login");
   $password = checkConnexion("password");
   $nom = checkConnexion("nom");
   $prenom = checkConnexion("prenom");
   
   $res = $data->createUser($login, $password, $nom, $prenom);
   if ($res){
     require('views/pageCreateOK.php');
     exit();
   } else {
     $erreurCreation = TRUE;
     require('views/pageRegister.php');
     exit();
   }
 } catch (ParmsException $e) {
   echo $e;
 }

?>

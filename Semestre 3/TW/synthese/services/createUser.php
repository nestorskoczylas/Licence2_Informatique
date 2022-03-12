<?php
set_include_path('..'.PATH_SEPARATOR);
spl_autoload_register(function ($className) {
     include ("lib/{$className}.class.php");
 });
require("etc/dsn_filename.php");
require_once('lib/common_service.php');
require_once('lib/initDataLayer.php');
require_once('lib/fonctions_parms.php');

try {
   $login = checkString("login",NULL,TRUE);
   $password = checkString("password",NULL,TRUE);
   $nom = checkString("nom",NULL,TRUE);
   $prenom = checkString("prenom",NULL,TRUE);
   $data = new DataLayer(DSN_FILENAME);
   $user = $data->createUser($login, $password, $nom, $prenom);
   if (!$user) {
     produceError($user,false);
     exit();
   }
   else {
     produceResult($user);
   }
}
catch (ParmsException $e) {
   produceError($e->getMessage(),true);
}

?>

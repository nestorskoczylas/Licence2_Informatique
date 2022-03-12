<?php
set_include_path('..'.PATH_SEPARATOR);
spl_autoload_register(function ($className) {
     include ("lib/{$className}.class.php");
 });
require_once('lib/common_service.php');
require_once('lib/initDataLayer.php');
require('lib/watchdog.php');


if (alreadyLogged()){
  produceResult($_SESSION['ident']);
  session_destroy();
  exit();
}
else{
  produceError("Vous êtes déconnecté !");
  exit();
}

?>

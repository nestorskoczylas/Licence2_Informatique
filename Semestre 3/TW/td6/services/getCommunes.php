<?php
set_include_path('..'.PATH_SEPARATOR);
require_once('lib/common_service.php');
require_once('lib/initDataLayer.php');
require_once('lib/fonctions_parms.php');

try {
    $comms = checkUnsignedInt('territoire', NULL, false);

    $communes = $data->getCommunes($comms);
  
    produceResult($communes);
}
catch (ParmsException $e) {
    produceError($e->getMessage());
}


?>

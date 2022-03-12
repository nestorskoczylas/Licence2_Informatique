<?php
set_include_path('..'.PATH_SEPARATOR);
require_once('lib/common_service.php');
require_once('lib/initDataLayer.php');
require_once('lib/fonctions_parms.php');

try {
    $detail = checkString('insee', NULL, true);

    $details = $data->getDetails($detail);
  
    produceResult($details);
}
catch (ParmsException $e) {
    produceError($e->getMessage());
}


?>

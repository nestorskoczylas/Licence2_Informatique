<?php
set_include_path('..'.PATH_SEPARATOR);
require_once('lib/common_service.php');
require_once('lib/initDataLayer.php');
require_once('lib/fonctions_parms.php');

try {
    $territoires = checkUnsignedInt('territoire', NULL, false);
    $villes = checkString('nom', NULL, false);
    $surfaces = checkUnsignedFloat('surface_min', NULL, false);
    $insees = checkUnsignedInt('insee', NULL, false);
    
    $communes = $data->getCommunes($territoires, $villes, $surfaces, $insees);

    produceResult($communes);
}
catch (ParmsException $e) {
    produceError($e->getMessage());
}


?>

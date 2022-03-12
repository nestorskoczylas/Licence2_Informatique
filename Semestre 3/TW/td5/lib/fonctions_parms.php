<?php
function checkConnexion(string $name, ?str $defaultValue = NULL, bool $mandatory = TRUE) : ?string {
    if ((! isset($_POST[$name]) || $_POST[$name] == "" ) && $defaultValue == NULL && $mandatory == TRUE){
      throw new ParmsException("$name incorrect");
    }
    if ((! isset($_POST[$name]) || $_POST[$name] == "" ) && $defaultValue == NULL && $mandatory == FALSE){
      return NULL;
    }
      $val = $_POST[$name];
      return $val;
}

 ?>

<?php
// faut que ça soit dans lib/color_defs.php
// "Pour vérifier qu’une couleur $truc est correct il suffira de vérifier que l’élément COLOR_KEYWORDS[$truc] est défini"
 /**
  *  prend en compte le paramètre $name passé en mode GET
  *   qui doit représenter un entier sans signe
  *  @return : valeur retenue, convertie en int.
  *   - si le paramètre est absent ou vide, renvoie  $defaultValue
  *   - si le paramètre est incorrect, déclenche une exception ParmsException
  *
  */
  function checkUnsignedInt(string $name, ?int $defaultValue=NULL, bool $mandatory = TRUE) : ?int {
     if ( !isset($_GET[$name]) || $_GET[$name]=="" ){
      if ($defaultValue !== NULL)
        return $defaultValue;
      else if ($mandatory)
        throw new ParmsException("$name absent");
      else
        return NULL;
     }
     $val = $_GET[$name];
     if (!ctype_digit($val))
       throw new ParmsException("$name incorrect");
     return (int) $val;
  }

 ?>

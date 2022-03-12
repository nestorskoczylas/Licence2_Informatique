<?php
 require(__DIR__."/color_defs.php"); // definit la constante COLOR_KEYWORDS

 /**
  *  prend en compte le paramètre $name passé en mode GET
  *   qui doit représenter une couleur CSS
  *  @return : valeur retenue
  *   - si le paramètre est absent ou vide, renvoie  $defaultValue
  *   - si le paramètre est incorrect, déclenche une exception ParmsException
  *
  */

  function checkColor(string $name, string $defaultValue) : string {
    if (!isset($_GET[$name]) || $_GET[$name]=="" )
      return $defaultValue;
    $val = $_GET[$name];
    if (!ctype_alpha($val))
      if (!preg_match(COLOR_REGEXP,$val))
        throw new ParmsException("$name incorrect");
      else {
        return (string) $val;
      }
    if (array_key_exists($val, COLOR_KEYWORDS))
      return (string) $val;
    else {
      throw new ParmsException("$name incorrect");
    }
  }

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
 function checkUnsignedInt(string $name, int $defaultValue) : int {
   if (!isset($_GET[$name]) || $_GET[$name]=="" )
      return $defaultValue;
    $val = $_GET[$name];
    if (!ctype_digit($val))
      throw new ParmsException("$name incorrect");
    return (int) $val;
  }

 ?>

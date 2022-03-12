<?php
class FileBookReader implements BookReader{
	
	private $file; // file resource
	
	function __construct(string $fileName){
		$this->file = fopen($fileName,'r');
	}
	
	/*
	function readBook() : ?array {
		$line = fgets($this->file);
        $result = array();
        while ($line !== FALSE && trim($line) != ""){
            $pos = strpos($line,":");
            if ($pos === FALSE){
                throw new exception("Absence de : ");
            }
            $name = trim(substr($line,0,$pos));
            $value = trim(substr($line, $pos+1));
            $result[$name] = $value;
            $line = fgets($this->file);
        }
        return $result;
	}*/

	function readBook() : ?array {

        //Ligne suivante si ligne vide
        while(($line !== FALSE) && (trim($line) == "")){
            $line = fgets($this->file);
        }

       //Si ligne
        if($line !== FALSE){
            $res = array();

            while (($ligne !== FALSE) && (trim($line) != "")){

                $pos = strpos($line, ':');
                if($pos === FALSE) {
                    throw new Exception(" Erreur de lecture de la ligne ");
                }

                $cle = trim(substr($line, 0, $pos));
                $valeur = trim(substr($line, $pos+1));
                $res[$cle] = $valeur;

                $line = fgets($this->file);

            }

        } else {
            $res = NULL;
        }

        return $res;

    }
	
	
}

?>

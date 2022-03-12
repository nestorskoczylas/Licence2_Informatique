<?php
class DataLayer {
	// private ?PDO $conn = NULL; // le typage des attributs est valide uniquement pour PHP>=7.4

	private  $conn = NULL; // connexion de type PDO   compat PHP<=7.3
	
		/**
		 * @param $DSNFileName : file containing DSN 
		 */
	function __construct(string $DSNFileName){
		$dsn = "uri:$DSNFileName";
		$this->connexion = new PDO($dsn);
		// paramètres de fonctionnement de PDO :
		$this->connexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION); // déclenchement d'exception en cas d'erreur
		$this->connexion->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE,PDO::FETCH_ASSOC); // fetch renvoie une table associative
		// réglage d'un schéma par défaut :
		$this->connexion->query('set search_path=authent');
	}
    

    function authentificationProvisoire(string $login, string $password) : ?Identite{
        $sql = <<<EOD
        select
        login, nom, prenom
        from users
        where login = :login and password = :password
EOD;

        $stmt = $this->connexion->prepare($sql);
        $stmt->bindValue(':login', $login);
        $stmt->bindValue(':password', $password);
        $stmt->execute();
        $info = $stmt->fetch();
        if ($info)
            return new Identite($info['login'], $info['nom'], $info['prenom']);
        else
            return NULL;
    }
    
    	/**
		 * authentification avec mot de passe crypté
		 *  @param $login : pseudo du compte
		 *  @param $password : mot de passe du compte
		 *  @return : Identite du compte se trouvant dans la base de données.
		 *   - NULL sinon
		 *
		 */
    function authentification(string $login, string $password) : ?Identite{ // version password hash
			$sql = <<<EOD
			select *
			from users
			where login = :login
EOD;
			$stmt = $this->connexion->prepare($sql);
			$stmt->bindValue(':login', $login);
			$stmt->execute();
			$info = $stmt->fetch();
			if ($info){
				 if(crypt($password, $info['password']) == $info['password'] ){
					 return new Identite($info['login'], $info['nom'], $info['prenom']);
				 }
				 else {
					 return NULL;
				 }
			}
			else {
				return NULL;
			}
    }

		/**
		 * création d'un nouveau compte
		 *  @param $login : pseudo du compte
		 *  @param $password : mot de passe du compte
		 *  @param $nom :nom du compte
		 *  @param $prénom : prénom du compte
		 *	@return bool indiquant si l'ajout a été réalisé
		 * 	- PDOException si ça ne respecte pas les conditions de la table
		**/
    function createUser(string $login, string $password, string $nom, string $prenom) : bool {
		try { $connexion= new PDO("pgsql:host= webtp.fil.univ-lille1.fr;user=skoczylas ;password=Wk7C1v3JkgQYf1Ia6ITkwNW");
		}
		catch (PDOException $e){
			echo "Erreur de connexion";
			exit();
		}
        $sql = <<<EOD
        insert into "users" (login, password, nom, prenom)
        values (:login, :password, :nom, :prenom)
EOD;
		$stmt = $this->connexion->prepare($sql);
		$stmt->bindValue(':login', $login);
		$stmt->bindValue(':password', password_hash($password,CRYPT_BLOWFISH));
		$stmt->bindValue(':nom', $nom);
		$stmt->bindValue(':prenom', $prenom);
		$stmt->execute();

		return TRUE;
	}
	
}
?>

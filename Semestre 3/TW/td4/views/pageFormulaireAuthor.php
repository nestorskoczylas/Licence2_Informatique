<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Formulaire de recherche de livres</title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <header>
            <h1>Formulaire de recherche de livres</h1>
        </header>

       <form action="bib_par_auteur.php" method="get">
        <label>Choix de l'auteur :
            <select name="authorId">
                <option value="">(tous)</option>
                <?= $optionsAuteurs ?>
            </select>
            <br />
        </label>
        <!-- � compl�ter -->
        <button type="submit" name="valid" value="1">Rechercher</button>
       </form>
        <form action="bib_par_annee.php" method="get">
        <label>Choix de l'auteur :
            <select name="year">
                <option value="">(tous)</option>
                <?= $optionsYears ?>
            </select>
            <br />
        </label>
        <!-- � compl�ter -->
        <button type="submit" name="valid" value="1">Rechercher</button>

    </body>

</html>

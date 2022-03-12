<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Premier exercice PHP</title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="iniPHP.css" />
    </head>
    <body>
        <header>
            <h1>Premier exercice PHP</h1>
            <h2>Réalisé par <span class="nom">Nestor SKOCZYLAS</span></h2>
        </header>

        <!-- section résultat. Créer une section pour chaque question -->

        <section>
            <h2>Question <?= $num_quest++ ?></h2>
            <p>Nous sommes le <?= date('d / m / Y') ?></p>
        </section>

        <section>
            <h2>Question <?= $num_quest++ ?></h2>
            <p><?= afficheVar(59,"c'est le phalempin")?></p>
        </section>

        <section>
            <h2>Question <?= $num_quest++ ?></h2>
            <p><?= n_parag("blabla",3) ?></p>
        </section>

        <section>
            <h2>Question <?= $num_quest++ ?></h2>
            <p><?= paragrapheTronque("abcdefg", 6) ?></p>
            <p><?= diminue("abcdefg") ?></p>
        </section>
        <section>
            <h2>Question <?= $num_quest++ ?></h2>
            <ul>
                <?= diminue2("abcdefg")?>
            </ul>
        </section>
        <section>
            <h2>Question <?= $num_quest++ ?></h2>
            <?= tableMultiplication(2)?>
        </section>
    </body>
    
</html>
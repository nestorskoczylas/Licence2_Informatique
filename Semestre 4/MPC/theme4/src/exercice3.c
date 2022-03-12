#include <stdio.h>
#include <stdlib.h>

/*Question 1*/
int main (int argc, char *argv[]) {
    int i; 

    for(i = 1; i < argc ; i++) {
        printf("%s ", argv[i]); 
    } 
    putchar('\n');

    exit(EXIT_SUCCESS); 
}


/*Question 2
- Pour % mecho "Hello world !" : 
un tableau d'une case contenant "Hello world !"
[Hello world !]

- Pour % mecho Hello world !
un tableau de trois case contenant chacun un mot de la phrase :
[Hello]
[world]
[!]

- Pour chaque paramètres (ou mot) passé à cette fonction, elle l'imprime sur la sortie standard
*/

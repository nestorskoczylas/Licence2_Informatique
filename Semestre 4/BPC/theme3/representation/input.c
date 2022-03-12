/* ------------------------------
   input.c
   Lecture de données
   ------------------------------------------------------------
*/

#include <stdio.h>
#include <stdlib.h>

#include "commun.h"

int main(void) {
    
    int i;
    union bloc_u bloc;

    for(i = 0; i < sizeof(struct etudiant_s[NB_ETU]); i++){
        bloc.data[i] = getchar();
    }

    for(i = 0; i < NB_ETU; i++){
        if (bloc.etu[i].in_use){
            printf("%d\n", bloc.etu[i].numero);
            printf("%f\n", bloc.etu[i].moyenne);
            printf("%s\n", bloc.etu[i].nom);
            printf("%s\n", bloc.etu[i].prenom);
        }
    }
    return 0;
}

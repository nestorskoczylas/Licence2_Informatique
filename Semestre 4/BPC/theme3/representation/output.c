/* ------------------------------
   output.c
   Écriture de données
   ------------------------------------------------------------
*/
#define ETU_INSCRIT 10

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "commun.h"


int main(void) {
    
    int i;
    union bloc_u bloc;

    for(i = 0; i < NB_ETU; i++){
        
        struct etudiant_s etudiant;
        if(i < ETU_INSCRIT){
            etudiant.moyenne = rand()%20;
            etudiant.numero = i + 1;
            strcpy(etudiant.nom, "Zidane");
            strcpy(etudiant.prenom, "Zinedine");
            etudiant.in_use = 1;
        }
        else {
            etudiant.in_use = 0;
        }
        bloc.etu[i] = etudiant;  
    }

    for(i = 0; i < sizeof(struct etudiant_s[NB_ETU]); i++){
        putchar(bloc.data[i]);
    }
    return 0;
}

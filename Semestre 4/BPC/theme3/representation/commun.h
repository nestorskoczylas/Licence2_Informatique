/* ------------------------------
   commun.h
   Définition des types
   ------------------------------------------------------------
*/
#define NB_ETU 30

struct etudiant_s {
    unsigned int numero;
    float moyenne;
    char nom[40];
    char prenom[40];
    int in_use;
};

union bloc_u {
    struct etudiant_s etu[NB_ETU];
    char data[sizeof(struct etudiant_s[NB_ETU])];
};

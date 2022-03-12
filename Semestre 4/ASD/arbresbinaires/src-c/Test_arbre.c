#include <stdio.h>
#include <stdlib.h>

#include "ArbreBinaire.h"

#define max(a,b) ((a)>(b)?(a):(b))

#define DEBUT_ARBRE_MYSTERIEUX 12
#define FIN_ARBRE_MYSTERIEUX 24
int cpt = 0;


/* Manipulation d'arbres binaires */

Noeud_t arbre1(void){
   Noeud_t arbre,sous_arbre_gauche,sous_arbre_droit;

  arbre = CreerNoeud(12);
  sous_arbre_gauche = CreerNoeud(9);
  AjouterGauche(arbre,sous_arbre_gauche);
  sous_arbre_droit = CreerNoeud(8);
  AjouterDroite(arbre,sous_arbre_droit);

  return arbre;
}

Noeud_t arbre2(void){
   Noeud_t arbre,sous_arbre_gauche,sous_arbre_droit,sous_sous_arbre_gauche;

  arbre = CreerNoeud(12);
  sous_arbre_gauche = CreerNoeud(9);
  AjouterGauche(arbre,sous_arbre_gauche);
  sous_arbre_droit = CreerNoeud(5);
  AjouterDroite(sous_arbre_gauche,sous_arbre_droit);
  sous_sous_arbre_gauche = CreerNoeud(7);
  AjouterGauche(sous_arbre_droit, sous_sous_arbre_gauche);

  return arbre;
}

Noeud_t arbre3(void){
   Noeud_t arbre,sous_arbre_gauche,
    sous_arbre_droit,sous1,sous2,sous3,sous4,sous5;

  arbre = CreerNoeud(12);
  sous_arbre_gauche = CreerNoeud(9);
  AjouterGauche(arbre,sous_arbre_gauche);
  sous_arbre_droit = CreerNoeud(5);
  AjouterDroite(sous_arbre_gauche,sous_arbre_droit);
  sous1 = CreerNoeud(1);
  AjouterGauche(sous_arbre_gauche,sous1);
  sous2 = CreerNoeud(8);
  AjouterDroite(arbre, sous2);
  sous3 = CreerNoeud(4);
  AjouterDroite(sous2, sous3);
  sous4 = CreerNoeud(7);
  AjouterGauche(sous3,sous4);
  sous5 = CreerNoeud(6);
  AjouterDroite(sous3, sous5);

   return arbre;

}

void imprimer(Noeud_t a){
   if(!EstVide(a)){
      imprimer(Gauche(a));
      printf("%ld\n", ValeurDuNoeud(a));
      imprimer(Droite(a));
   }
}

int taille(Noeud_t a){
   
   if(!EstVide(a)){
      cpt++;
      cpt = taille(Gauche(a));
      cpt = taille(Droite(a)); 
   }
   return cpt;
}

int hauteur(Noeud_t a){

  if(EstVide(a)){
     return -1;
  }
  return 1 + max(hauteur(Gauche(a)),hauteur(Droite(a)));
}

int nbFeuilles(Noeud_t a){
   if(!EstVide(a)){
      if(EstFeuille(a)){
         cpt++;
      }
      cpt = nbFeuilles(Gauche(a));
      cpt = nbFeuilles(Droite(a)); 
   }
   return cpt;
}


/* Comptage d'arbres */

int nbArbres(int n){
   int res = 0;
   int k;
   if(n == 0){
      res =  1;
   } 
   for(k = 0; k < n; k++){
      res += nbArbres(k)*nbArbres(n-k-1);
   }
   return res;
}

int nbArbresEfficace(int n) {
   long int i;
   long int res[256];
   res[0]=1;
   for(i=1;i<n;i++){
      res[i]=res[i-1]*2*(2*i+1)/(i+2);
   }
   return res[n-1];
}
    
/* Manipulation d'arbres binaires de recherche */

Noeud_t abr1(void){
  Noeud_t arbre,sous_arbre_gauche,
    sous_arbre_droit,sous1,sous2,sous3;

  arbre = CreerNoeud(6);
  sous_arbre_gauche = CreerNoeud(4);
  AjouterGauche(arbre,sous_arbre_gauche);
  sous_arbre_droit = CreerNoeud(5);
  AjouterDroite(sous_arbre_gauche,sous_arbre_droit);
  sous1 = CreerNoeud(2);
  AjouterGauche(sous_arbre_gauche,sous1);
  sous2 = CreerNoeud(7);
  AjouterDroite(arbre, sous2);
  sous3 = CreerNoeud(1);
  AjouterGauche(sous1,sous3);

   return arbre;
}

Noeud_t ajouter(value_t v, Noeud_t a){
   Noeud_t sous_arbre_droit,sous_arbre_gauche;
      if(EstVide(a)){
         a = CreerNoeud(v);
         return a;
      }
      else {

         if(v <= ValeurDuNoeud(a)){
         sous_arbre_gauche = ajouter(v, Gauche(a));
         RemplacerGauche(a, sous_arbre_gauche);
         }
         else{
            sous_arbre_droit = ajouter(v, Droite(a));
            RemplacerDroite(a, sous_arbre_droit);
         }
      }
      return a;
   }
   

Noeud_t abr2(void){
   Noeud_t arbre;
   int i;
   int tab[6] = {5,4,2,7,6,1};
   arbre = CreerArbreVide();
   for(i = 0; i < 6; i++){
      arbre = ajouter(tab[i], arbre);
   }
   return arbre;
}

Noeud_t abr3(void){
   Noeud_t arbre;
   int i;
   int tab[6] = {7,1,4,5,6,2};
   arbre = CreerArbreVide();
   for(i = 0; i < 6; i++){
      arbre = ajouter(tab[i], arbre);
   }
   return arbre;
}

int appartient(value_t v, Noeud_t a){
   if(EstVide(a)){
      return 0;
   }
   cpt++;
   if(v == ValeurDuNoeud(a)){
      return 1;
   }
   else if(EstFeuille(a)){
      return 0;
   }
   else{
      cpt++;
      if(v <= ValeurDuNoeud(a)){
         return appartient(v, Gauche(a));
      }
      else{
         return appartient(v, Droite(a));
      }
   }
}

int valeur_minimale(Noeud_t abr){
   if(!EstVide(abr)){
      if(EstVide(Gauche(abr))){
      return ValeurDuNoeud(abr);
   }
   return valeur_minimale(Gauche(abr));
   }
   return -1;
}

int valeur_maximale(Noeud_t abr){
   if(!EstVide(abr)){
      if(EstVide(Droite(abr))){
      return ValeurDuNoeud(abr);
   }
   return valeur_maximale(Droite(abr));
   }
   return -1;
}

/* Entier mysterieux */

Noeud_t construitArbreEntierMysterieux (value_t i, value_t j) { 
   if ( i == j ) {
      return CreerNoeud(i);
   }
   if ( i > j ) {
      return CreerArbreVide();
   }
   else {
      Noeud_t arbre = CreerNoeud((i+j) / 2);

      AjouterDroite(arbre, construitArbreEntierMysterieux((i + j) / 2 + 1, j));
      AjouterGauche(arbre, construitArbreEntierMysterieux(i, (i + j) / 2 - 1));

      return arbre;
   }
}

void jouer (int i, int j) {
   int nb;
   Noeud_t arbre = construitArbreEntierMysterieux(i, j);

   nb = 0;

   printf("Chiffre à deviner\n");
   scanf("%d", &nb);

   do {
      printf("Est-ce %ld ?\n", ValeurDuNoeud(arbre));
      if (nb < ValeurDuNoeud(arbre)) {
         printf("Trop grand\n");
         arbre = Gauche(arbre);
      }
      else {
         printf("Trop petit\n");
         arbre = Droite(arbre);
      }
      
   } while (nb != ValeurDuNoeud(arbre));

   printf("Est-ce %ld ?\n", ValeurDuNoeud(arbre));
   printf("OUI BRAVO !\n");
}

/* Tests sur les arbres binaires */

void testArbreBinaire(Noeud_t a){
   imprimer(a); printf("\n");
   cpt = 0;
   printf("Taille     = %d\n",(taille(a)));
   cpt = 0;
   printf("Hauteur    = %d\n",(hauteur(a)));
   cpt = 0;
   printf("nbFeuilles = %d\n",(nbFeuilles(a)));
   cpt = 0;
}

/* Tests sur les arbres binaires de recherche */
void testABR(Noeud_t a){
   int i;
   imprimer(a); printf("\n");
   cpt = 0;
   printf("Taille     = %d\n",(taille(a)));
   cpt = 0;
   printf("Hauteur    = %d\n",(hauteur(a)));
   cpt = 0;
   printf("nbFeuilles = %d\n",(nbFeuilles(a)));
   cpt = 0;
   printf("Valeurs présentes dans l'arbre : ");
   for (i = 0; i <= 10; i++){
      if (appartient(i,a)){
         printf("%d ",i);
      }
   }
   printf("\n");
   printf("Nombre de comparaison");
   for (i = 0; i <= 10; i++){
      cpt = 0;
      appartient(i,a);
      printf(" %d : %d ",i,cpt);
   }
   printf("\n");
   printf("min : %d, ", valeur_minimale(a));
   printf("max : %d\n", valeur_maximale(a));
   
}
  
/* Programme principal */
int main(int argc, char **argv){

   int i;

   Noeud_t a1 = arbre1();
   Noeud_t a2 = arbre2();
   Noeud_t a3 = arbre3();
   
   testArbreBinaire(a1);
   testArbreBinaire(a2);
   testArbreBinaire(a3);

   DetruireArbre(a1);
   DetruireArbre(a2);
   DetruireArbre(a3);

   for (i = 0; i <= 19; i++){
      printf("Le nombre d'arbres à %d noeuds est %d\n",
         i,(nbArbresEfficace(i)));
   }
   
   a1 = abr1();
   a2 = abr2();
   a3 = abr3();
   
   testABR(a1);
   testABR(a2);
   testABR(a3);

   DetruireArbre(a1);
   DetruireArbre(a2);
   DetruireArbre(a3);

   printf("Arbre mysterieux entre %d et %d:\n", DEBUT_ARBRE_MYSTERIEUX, FIN_ARBRE_MYSTERIEUX);
   imprimer(construitArbreEntierMysterieux(DEBUT_ARBRE_MYSTERIEUX, FIN_ARBRE_MYSTERIEUX));
   printf("\n");
  
   jouer(DEBUT_ARBRE_MYSTERIEUX, FIN_ARBRE_MYSTERIEUX);

   
   return 0;
   
}

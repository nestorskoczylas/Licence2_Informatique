#include "files_entier.h"

/* QUESTION 3 :

La file vide est représentée par ififo_s avec comme pointeur NULL suivant.

*/

/* QUESTION 4 : */

ififo_s *ififo_new(){

    ififo_node_s *newnoeud = NULL;
    ififo_s *files = malloc(sizeof(*files));

    if(files == NULL){
        return NULL;
    }

    files -> suivant = newnoeud;
    files -> dernier = newnoeud;

    return files;
}

/* QUESTION 5 : */

int ififo_is_empty(ififo_s *f){

    return ((f -> suivant == NULL) && (f -> dernier == NULL));
}

/* QUESTION 6 : */

int ififo_enqueue(ififo_s *f, int nb){

    ififo_node_s *new = malloc(sizeof(*new));

    if (f == NULL || new == NULL){
        return -1;
    }

    new->nombre = nb;

    if (ififo_is_empty(f)){
        f -> suivant = new;
        f -> dernier = new;
    }
    else{
        f -> dernier -> noeud = new;
        f -> dernier = new;
    }

    new -> noeud = NULL;
    return 0;
}

/* QUESTION 7 : */

int ififo_dequeue(ififo_s *f, int *nb){

    if (ififo_is_empty(f)){
        return -1;
    }

    ififo_node_s *new = f -> suivant;

    if (f -> suivant == f -> dernier){
        ififo_node_s *new2 = NULL;
        
        *nb = f -> suivant -> nombre;
        f -> suivant = f -> dernier = new2;
    }
    else {
        *nb = new -> nombre;
        f -> suivant = new -> noeud;
    }

    free(new);
    
    return 0;
}

/* QUESTION 8 : */

int ififo_head(const struct ififo_s *f){

    return f -> suivant -> nombre;
}

/* QUESTION 9 : */

int ififo_apply(ififo_s *f, func_t *fn){

    ififo_node_s *apply = f -> dernier;

    while (apply != NULL){
        fn(apply -> nombre);
        apply = apply -> noeud;
    }

    return 0;
}

/* QUESTION 10 : */

void ififo_del(ififo_s *f){

    ififo_node_s *new = f -> suivant;
    ififo_node_s *del;


    while(new != NULL){
        del = new;
        new = new -> noeud;
        free(del);
    }
    new = NULL;
    free(f);
}

void print_int(int i){
    printf("%d ← ", i);
}
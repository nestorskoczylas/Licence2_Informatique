#include "gfifo.h"

gfifo_s *gfifo_new(){

    gfifo_s *f = malloc(sizeof(*f));
    if (f == NULL)
        return NULL;

    f -> suivant = NULL;
    f -> dernier = NULL;

    return f;
}

int gfifo_del(gfifo_s *f){

    gfifo_node_s *del = f -> suivant;

    while (del != NULL){
        f -> suivant = f -> suivant -> noeud;
        free(del);
        del = f -> suivant;
    }
    free(f);
    return 0;
}

int gfifo_size(gfifo_s *f){
    
    gfifo_node_s *size = f -> suivant;

    int cpt = 0;

    while (size != NULL){
        cpt ++;
        size = size -> noeud;
    }
    return cpt;
}

int gfifo_enqueue(gfifo_s *f, void *nb){

    gfifo_node_s *enqueue = malloc(sizeof(*enqueue));

    if (enqueue == NULL)
        return -1;

    enqueue -> nombre = nb;
    enqueue -> noeud = NULL;

    if (f -> suivant == NULL && f -> dernier == NULL){
        f -> suivant = enqueue;
    }
    else{
        f -> dernier -> noeud = enqueue;
    }

    f -> dernier = enqueue;
    return 0;
}

int gfifo_dequeue(gfifo_s *f, void **nb){

    if (f -> suivant == NULL && f -> dernier == NULL){
        return -1;
    }

    gfifo_node_s *suivant = f -> suivant;
    *nb = f -> suivant -> nombre;

    if (f -> suivant -> noeud == NULL){
        f -> suivant = NULL;
        f -> dernier = NULL;
    }
    else{
        f -> suivant = f -> suivant -> noeud;
    }
    free(suivant);
    return 0;
}

int gfifo_apply(gfifo_s *f, gfunc_t *fn){
    gfifo_node_s *func = f -> suivant;

    while (func != NULL){
        fn((func -> nombre));
        func = to_func->noeud;
    }
    return 0;
}

void print_int(int i){
    printf("%d ← ", i);
}

void test_gifo_int(){
    struct gfifo_s *fifo;
    int i;

    fifo = gfifo_new();

    gfifo_enqueue(fifo, 12); /* → 12 → */
    gfifo_enqueue(fifo, 13); /* → 13 → 12 → */

    gfifo_apply(fifo, print_int);
    putchar('\n');
    printf("size : %d\n", gfifo_size(fifo));
    gfifo_enqueue(fifo, 14); /* → 14 → 13 → 12 → */
    gfifo_dequeue(fifo, &i); /* 12 & → 14 → 13 → */

    gfifo_apply(fifo, print_int);
    putchar('\n');

    gfifo_dequeue(fifo, &i); /* 13 & → 14 → */
    gfifo_dequeue(fifo, &i); /* 14 & → → */
    gfifo_apply(fifo, print_int);
    putchar('\n');

    gfifo_del(fifo);
}

/*
int main(){
    test_gifo_int();
    return 0;
}
*/
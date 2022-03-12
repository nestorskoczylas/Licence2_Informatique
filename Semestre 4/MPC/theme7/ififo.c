#include "ififo.h"
#include "gfifo.h"

ififo_s *ififo_new(){

    struct ififo_s *f = malloc(sizeof(*f));
    if (f == NULL)
        return NULL;

    f -> suivant = NULL;
    f -> dernier = NULL;

    return f;
}

int ififo_is_empty(ififo_s *f){
    return (f -> suivant == NULL && f -> dernier == NULL);
}

int ififo_enqueue(ififo_s *f, int nb){

    ififo_node_s *new = malloc(sizeof(*new));

    if (new == NULL){
        return -1;
    }

    new -> nombre = nb;
    new -> noeud = NULL;

    if (ififo_is_empty(f)){
        f -> suivant = new;
    }
    else{
        f -> dernier -> noeud = new;
    }

    f -> dernier = new;
    return 0;
}

int ififo_dequeue(ififo_s *f, int *nb){

    if (ififo_is_empty(f)){
        return -1;
    }

    ififo_node_s *suivant = f -> suivant;
    *nb = suivant -> nombre;

    f -> suivant = suivant -> noeud;
    free(suivant);
    return 0;
}

int ififo_head(const struct ififo_s *f){
    return f -> suivant -> nombre;
}

int ififo_apply(ififo_s *f, func_t *fn){
    ififo_node_s *func = f -> suivant;

    while (func != NULL){
        fn(func -> nombre);
        func = func -> noeud;
    }
    return 0;
}

void ififo_del(struct ififo_s *f){

    ififo_node_s *del = f -> suivant;

    while (del != NULL){
        f -> suivant = f -> suivant -> noeud;
        free(del);
        del = f -> suivant;
    }
    free(f);
}

void test_fifo_int(){
    struct ififo_s *fifo;
    int i;

    fifo = ififo_new();

    ififo_enqueue(fifo, 12); /* → 12 → */
    ififo_enqueue(fifo, 13); /* → 13 → 12 → */

    ififo_apply(fifo, print_int);
    putchar('\n');

    ififo_enqueue(fifo, 14); /* → 14 → 13 → 12 → */
    ififo_dequeue(fifo, &i); /* 12 & → 14 → 13 → */

    printf("%d \n", i);
    ififo_apply(fifo, print_int);
    putchar('\n');

    ififo_dequeue(fifo, &i); /* 13 & → 14 → */
    ififo_dequeue(fifo, &i); /* 14 & → → */
    ififo_apply(fifo, print_int);
    putchar('\n');

    ififo_del(fifo);
}
/*
int main(){
    test_fifo_int();
    return 0;
}
*/

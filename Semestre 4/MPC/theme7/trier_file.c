#include "gfifo.h"
#include "ififo.h"
#include <stdio.h>


ififo_s *ififo_merge(ififo_s *f1, ififo_s *f2){
    int nombre;
    ififo_s *ififo = ififo_new();

    while (f1 -> suivant != NULL || f2 -> suivant != NULL){
        if (f1 -> suivant == NULL){
            ififo_dequeue(f2, &nombre);
            ififo_enqueue(ififo, nombre);
        }
        else if (f2-> suivant == NULL){
            ififo_dequeue(f1, &nombre);
            ififo_enqueue(ififo, nombre);
        }
        else{
            if (f1-> suivant -> nombre > f2 -> suivant -> nombre){
                ififo_dequeue(f2, &nombre);
                ififo_enqueue(ififo, nombre);
            }
            else{
                ififo_dequeue(f1, &nombre);
                ififo_enqueue(ififo, nombre);
            }
        }
    }
    return ififo;
}

void trier(struct gfifo_s *gfifo){
    ififo_s *fifo1, *fifo2;
    ififo_s *sort;

    if (gfifo-> suivant != NULL){
        while (gfifo-> suivant -> noeud != NULL){
            gfifo_dequeue(gfifo, &fifo1);
            gfifo_dequeue(gfifo, &fifo2);
            sort = ififo_merge(fifo1, fifo2);

            gfifo_enqueue(gfifo, sort);
        }
    }
}

void test_merge(){
    printf("test merge \n");
    ififo_s *fifo_test, *fifo1, *fifo2;
    fifo1 = ififo_new();
    fifo2 = ififo_new();

    int i;
    int tab[5] = {1, 2, 3, 4, 5};
    int tab2[5] = {1, 3, 5, 15, 20};
    for (i = 0; i < 5; i++){
        ififo_enqueue(fifo1, tab[i]);
        ififo_enqueue(fifo2, tab2[i]);
    }

    fifo_test = ififo_merge(fifo1, fifo2);
    ififo_apply(fifo_test, print_int);

    ififo_del(fifo_test);
    ififo_del(fifo1);
    ififo_del(fifo2);
}

int main(void){
    test_merge();
    putchar('\n');

    int x = 0;
    int nb;
    gfifo_s *gfifo = gfifo_new();
    ififo_s *fifo;

    printf("Entrez 10 entiers :) \n");

    while (x < 10){
        printf("Entrez un entier : ");
        scanf("%d", &nb);
        fifo = ififo_new();
        ififo_enqueue(fifo, nb);
        gfifo_enqueue(gfifo, fifo);
        x++;
    }
    trier(gfifo);
    ififo_apply(gfifo -> suivant -> nombre, print_int);
    gfifo_del(gfifo);
    ififo_del(fifo);
    return 0;
}

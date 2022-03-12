#include "files_entier.h"
#include "files_generique.h"
#define X 5

ififo_s *ififo_merge(ififo_s *f1, ififo_s *f2){

    ififo_s *ififo;
    int nb;

    ififo = ififo_new();

    while (f1 -> dernier != NULL){
        ififo_dequeue(f1, &nb);
        ififo_enqueue(ififo, nb);
    }

    while (f2 -> dernier != NULL){
        ififo_dequeue(f2, &nb);
        ififo_enqueue(ififo, nb);
    }

    ififo_del(f1);
    ififo_del(f2);

    return ififo;
}

gfifo_s *trier(struct ififo_s *f){
    gfifo_s *gfifo = (struct gfifo_s *)f;

    gfifo_apply(gfifo, printg_int);
    putchar('\n');
    return NULL;
}

int main(void){
    int i;
    struct ififo_s *fifo1, *fifo2, *fifoMerge;
    struct gfifo_s *gfifo;

    fifo1 = ififo_new();
    fifo2 = ififo_new();
    gfifo = gfifo_new();

    for (i = 1; i < X + 1; i++){
        ififo_enqueue(fifo1, i);
        ififo_enqueue(fifo2, i + 5);
    }

    puts("FIFO 1: ");
    ififo_apply(fifo1, print_int);
    putchar('\n');

    puts("FIFO 2: ");
    ififo_apply(fifo2, print_int);
    putchar('\n');

    puts("FIFO MERGE: ");
    fifoMerge = ififo_merge(fifo1, fifo2);
    ififo_apply(fifoMerge, print_int);
    putchar('\n');

    puts("FIFO TRIER: ");
    gfifo = trier(fifoMerge);
    gfifo_apply(gfifo, printg_int);
    putchar('\n');

    return 0;
}
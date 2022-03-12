#include "files_generique.h"
#define X 5

/* make main_files_generique*/

/* QUESTION 2 : */

void test_gfifo(){
    struct gfifo_s *gfifo;
    int tab[X] = {12, 13, 14, 15, 16};
    int i;
    void *deleted;

    gfifo = gfifo_new();

    for (i = 0; i < X; i++){
        gfifo_enqueue(gfifo, &tab[i]);
        gfifo_apply(gfifo, printg_int);
        putchar('\n');
    }

    printf("size : %d\n\n", gfifo_size(gfifo));

    for (i = 0; i < X; i++){
        gfifo_dequeue(gfifo, &deleted);
        printf("delete : %d \n", *(int *)deleted);
        gfifo_apply(gfifo, printg_int);
        putchar('\n');
    }

    gfifo_apply(gfifo, printg_int);
    putchar('\n');
    gfifo_del(gfifo);
}

int main(void){
    test_gfifo();
    return 0;
}

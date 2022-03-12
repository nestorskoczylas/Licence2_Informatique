#include <stdio.h>
#include <stdlib.h>

/*Question 1
 * Le prototype d'une fonction permettant l'échange de valeurs de deux pointeurs
 * de type int* est int ** (pointeur pointant à un pointeur)
 */

/*Question 2*/
void swap_ptr(int **x, int **y){
    int i,*l=&i,**u=&l;
    *u = *x; 
    *x = *y;
    *y = *u;
}

/*Question 3*/
int main(){
    int a, b;
    int *x = &a;
    int *y = &b;

    swap_ptr(&x, &y);
    
    if ((x == &b) && (y == &a)) {
        printf("OK ;)\n");
        exit(EXIT_SUCCESS);
    }
    
    else {
        printf("KO ;(\n");
        exit(EXIT_FAILURE);
    }
}
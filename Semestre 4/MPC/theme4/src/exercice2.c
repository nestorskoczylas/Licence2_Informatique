#include<stdio.h>
#include "mcu_putint.h"

/*Question 1*/
void division(int diviseur, int dividende,int * quotient, int * reste){
    
    *quotient = diviseur/dividende;
    *reste = diviseur%dividende;
}

/*Question 2*/
int main(void){
    int x,y,var1,var2;
    printf("Entrez les valeurs");
    scanf("%d%d", &var1, &var2);
    division(var1, var2, &x, &y);
    putdec(x);
    printf("\n");
    putdec(y);
    printf("\n");
    return 0;
}
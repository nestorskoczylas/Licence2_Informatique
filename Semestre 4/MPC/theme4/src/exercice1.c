#include <stdio.h>

/*Question 1*/
void swap_int(int *a, int *b) {
 int x = *a;
 *a = *b;
 *b = x;
}

/*Question 2*/
int main(void){
    //int var1 = 1;
    //int var2 = 2;

    int var1,var2;
    printf("Entrez les valeurs");
    scanf("%d%d", &var1, &var2);
    swap_int(&var1, &var2);
    printf("var 1 = %d\n",var1);
    printf("var 2 = %d\n",var2);
    return 0;
}
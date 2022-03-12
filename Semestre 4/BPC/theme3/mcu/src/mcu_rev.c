#include <stdio.h>
#include "mcu_fatal.h"
#include "mcu_readl.h"
#include "mcu_macros.h"

void rev(char tab[],int i){

    while(i>= 0){
        putchar(tab[i]);
        i--;
    }
    putchar('\n');
        
    

}

int main(void){

    int i;
    char line[MAXLINE];

    i = readl(line);

    while(i != EOF){

        rev(line, i);
        i = readl(line);
    }

    return 1;

}
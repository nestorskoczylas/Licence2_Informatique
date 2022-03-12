#include <stdio.h>
#include "mcu_putint.h"
#include "mcu_macros.h"
#include "mcu_fatal.h"

int main(void){
    int i;

    i = 0;

    while(getchar() != EOF){

            fatal(i >= MAXLINE -1 , "trop de carac", 1);
            i++;
    }

    putdec(i);
    putchar('\n');
    return 0;
}
#include <stdio.h>
#include "mcu_putint.h"
#include "mcu_macros.h"
#include "mcu_fatal.h"

int main(void){
    
    
    int i;
    int c;
    int a;

    
    i = 0;
    c = getchar();
    a = 1;
    
    if (c != EOF){
        i++;
    }

    while(c != EOF){
        
        fatal(a >= MAXLINE , "trop de carac", 1);
        if(c == '\n'){
            i++;
        }
        c = getchar();
        a++;
    }

    putdec(i);
    putchar('\n');
    return 0;
}
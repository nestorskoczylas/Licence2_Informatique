#include <stdio.h>
#include "mcu_fatal.h"

int readl(char line[]){
    int i;
    int c;

    i = 0;

    while((c = getchar()) != '\n'){
        fatal(i >= MAXLINE - 2 , "trop de carac", 2);
        
        if (c == EOF){
            line[i] = 0;
            return EOF;
        }

        line[i] = c;
        i++;
        
    }

    line[i] = 0;

return i;
}
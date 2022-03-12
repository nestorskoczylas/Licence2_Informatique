#include <stdio.h>
extern char **environ;

void printenv(){
    for (environ; *environ != NULL; ++environ)
        printf ("%s\n", *environ);
}

int main(void){
    printenv();
    return 0;
}
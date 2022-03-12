#include <stdio.h>
extern char **environ;

int nvar(){
   int cpt = 0;
   int i = 0;
   while(*(environ + i) != (char*)0){
       i++;
       cpt++;
   }
   return cpt;
}

int main(void){
    int res = nvar();
    printf("%d\n", res);
    return 0;
}
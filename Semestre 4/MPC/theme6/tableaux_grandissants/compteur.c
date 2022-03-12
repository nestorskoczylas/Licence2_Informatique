#include <stdio.h>

int compteur(){

static int cpt = -1;
cpt ++;
return cpt;
}

int main(){
int i, res;
for(i = 0; i < 10; i++){
     res = compteur();
     printf("%d\n", res);
}
return 0; 
}
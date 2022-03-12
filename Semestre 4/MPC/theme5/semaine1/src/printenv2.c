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

void printenv(int argc, char *argv[]){
    if(argc > 1){
        int nbVar = nvar();
        for(int i = 1; i < argc; i++){
            for(int j = 0; j < nbVar; environ++, j++){
                char * ptr = *environ;
                int k = 0;
                while(*(ptr + k) != '=' && argv[i][k] != '\0' &&
                    *(ptr + k) == argv[i][k]){
                    k++;
                }
                
                if(*(ptr + k) == '='){
                    printf("%s", (ptr + k + 1));
                    putchar('\n');
                }
                
            }
            environ = environ - nbVar;
        }
    }
    else{
        for (environ; *environ != NULL; ++environ){
            printf ("%s\n", *environ);
        }  
    }
}

int main(int argc, char *argv[]){
    printenv(argc, argv);
    return 0;
}
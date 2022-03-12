#include <stdlib.h>
#include <stdio.h>

char *mstrdup(const char *str) {
    int i = 0;
    int cpt = 0;

    while(str[i] != '\0'){
        cpt++;
        i++;
    }

    char * res = malloc((cpt + 1) * sizeof(char));


    if (res == NULL) {
        return NULL;
    }

    for (i=0; i<cpt; i++) {
        res[i] = str[i];
    }

    res[i] = '\0';
    
    return res;
}

int main(int argc, char *argv[]){
    int i;
    char *result;
    if(argc > 1) {
        for (i=1; i<argc; i++){
        result = mstrdup(argv[i]);
        printf("%s\n", result);
        free(result);
        }
    }
    exit(EXIT_SUCCESS);
}


/*
si il y un problème lors de l'allocation de mémoire avec malloc, la fonction renvoie NULL
*/




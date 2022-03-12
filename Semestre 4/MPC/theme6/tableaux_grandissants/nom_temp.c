#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char * nom_temp(){
    static int cpt = 0;
    static char res[] = "FILE";

    res[4] = (cpt++) + '0';

    return res;
}

char *nom_temp2(){
    char *res = malloc(6 * sizeof(char));
    static int cpt = 0;

    if (res == NULL) {return NULL;}
        
    snprintf(res, 6, "FILE%d", cpt++);
    
    return res;
}

void test_nom_temp() {
    char *file1, *file2, *file3;
    printf("\nTest 1\n");

    file1 = nom_temp();
    printf("Fichier 1 : %s\n", file1);

    file2 = nom_temp();
    printf("Fichier 2 : %s\n", file2);
    file3 = nom_temp();
    printf("Fichier 3 : %s\n", file3);
}

void test_nom_temp2(){
    char *file1, *file2, *file3, *file4;
    printf("\nTest 2\n");

    file1 = nom_temp2();
    printf("Fichier 1 : %s\n", file1);
    free(file1);

    file2 = nom_temp2();
    printf("Fichier 2 : %s\n", file2);
    free(file2);

    file3 = nom_temp2();
    printf("Fichier 3 : %s\n", file3);
    free(file3);

    file4 = nom_temp2();
    printf("Fichier 4 : %s\n", file4);

    free(file4);
}

int main(){
    test_nom_temp();
    test_nom_temp2();
    return 0;
}
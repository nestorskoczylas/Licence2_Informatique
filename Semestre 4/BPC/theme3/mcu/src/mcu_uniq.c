#include <stdio.h>
#include "mcu_fatal.h"
#include "mcu_readl.h"
#include "mcu_macros.h"


 
void copie(char cible[], char source[]){

    int i;
    char c;
    
    i = 0;
    c = source[i];


    while(c != '\0'){
        cible[i] = c;
        i++;
        c = source[i];

    }

    return;

}

int compare(char chaine1[], char chaine2[]){
    
    int i;
    i = 0;

    while(chaine1[i] != '\0' && chaine2[i] != '\0'){
        
        if (chaine1[i] != chaine2[i]){
            return 1;
        }
        
        i++;

    }

    return 0;

}

int main(void) {

    char line1[MAXLINE];
    char line2[MAXLINE];
    
    int i;
    int n;

    n = readl(line1);
  

    for (i = 0; i < n; i++){

        putchar(line1[i]);
    }
    
    putchar('\n');

    while ((n != EOF)) {
    
        n = readl(line2);


        if (compare(line1, line2)) {

            for (i = 0; i < n; i++){

                putchar(line2[i]);
            }
           
            putchar('\n');
            copie(line1, line2);
        }   

    }

    return 0;

}

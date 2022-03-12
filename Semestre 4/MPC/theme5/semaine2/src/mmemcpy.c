#include <stdlib.h>             /* pour random() */
#include <string.h>             /* pour memcmp() */
#include <assert.h>             /* pour assert() */

#define SIZE 1021


void mmemcpy(void *to, const void *from, unsigned int size){
    char *cfrom = (char *)from;
    char *cto = (char *)to;

    for (int i = 0; i < size; i++)
        cto[i] = cfrom[i];
}

void test_mmemcpy()
{
    char tc_orig[SIZE], tc_dest[SIZE];
    long int ti_orig[SIZE], ti_dest[SIZE];
    int i;

    /* initialisation */
    for(i=0 ; i<SIZE ; i++) {
        tc_orig[i] = random() % 256;
        tc_dest[i] = random() % 256;
        ti_orig[i] = random(); 
        ti_dest[i] = random();
    }

    /* copie */
    mmemcpy(tc_dest, tc_orig, SIZE);
    mmemcpy(ti_dest, ti_orig, SIZE * sizeof(long int));

    /* vérification */
    assert(memcmp(tc_orig, tc_dest, SIZE) == 0); 
    assert(memcmp(ti_orig, ti_dest, SIZE * sizeof(long int)) == 0);
}


int main(){
    test_mmemcpy();
    return 0;
}


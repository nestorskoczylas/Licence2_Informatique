#include <stdlib.h>             /* pour random() */
#include <string.h>             /* pour memcmp() */
#include <assert.h>             /* pour assert() */
#include <stdio.h>

#define SIZE  1021


void memswap(void *to, const void *from, unsigned int size){
    char *cfrom = (char *)from;
    char *cto = (char *)to;
    char interm;
    char t[size], f[size];
    
    for(int i = 0; i < size; i ++){
        t[i] = cto[i];
        f[i] = cfrom[i];
    }

    for (int i = 0; i < size; i++){
        interm = t[i];
        cto[i] = f[i];
        cfrom[i] = interm;
    }
}

void test_memswap(){

    char tc_orig[SIZE], tc_dest[SIZE], c_orig[SIZE], c_dest[SIZE];
    long int ti_orig[SIZE], ti_dest[SIZE], i_orig[SIZE], i_dest[SIZE];
    int i;

    
    /* initialisation */
    for (i = 0; i < SIZE; i++){
        tc_orig[i] = random() % 256;
        c_orig[i] = tc_orig[i];
    }
    for (i = 0; i < SIZE; i++){
        tc_dest[i] = random() % 256;
        c_dest[i] = tc_dest[i];
    }
    for (i = 0; i < SIZE; i++){
        ti_orig[i] = random();
        i_orig[i] = ti_orig[i];
    }
    for (i = 0; i < SIZE; i++){
        ti_dest[i] = random();
        i_dest[i] = ti_dest[i];
    } 
    

    /* swapie */
    memswap(tc_dest, tc_orig, SIZE);
    memswap(ti_dest, ti_orig, SIZE * sizeof(long int));

    /* vérification */
    assert(memcmp(tc_orig, c_dest, SIZE) == 0); 
    assert(memcmp(tc_dest, c_orig, SIZE) == 0); 
    assert(memcmp(ti_orig, i_dest, SIZE * sizeof(long int)) == 0);
    assert(memcmp(ti_dest, i_orig, SIZE * sizeof(long int)) == 0);
}


int main(){
    test_memswap();
    return 0;
}
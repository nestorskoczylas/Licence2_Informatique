#include "libga.h"
#include <stdlib.h>


int
ga_set(struct ga_s *ga, unsigned int index, int val)
{   
    if (index < ga -> ga_size){
        ga -> ga_elements[index] = val;
    }

    else{
        int i;
        int * new_mem = malloc(sizeof(int) * (index*2));
        if(new_mem == NULL){
        return -1;
        }   
        
        for(i = 0; i < ga -> ga_size; i++){
            new_mem[i] = ga -> ga_elements[i];
        }
        
        free(ga -> ga_elements);
        ga -> ga_elements = new_mem;
        ga -> ga_elements[index] = val;
        ga -> ga_size = index * 2;
    }
    return 1;

}

int
ga_get(struct ga_s *ga, unsigned int index, int *val)
{   
    *val = ga -> ga_elements[index];
    return 1;
}

int 
ga_new(struct ga_s *ga)
{   
    ga -> ga_size = 10;
    ga -> ga_elements = malloc(sizeof(int) * ga -> ga_size);
    if(ga -> ga_elements == NULL){
        return -1;
    }
    return  1;
}

int
ga_del(struct ga_s *ga)
{
    ga -> ga_size = 0;
    free(ga -> ga_elements);
    return 1;
}




#define SIZE 10

#include <stdio.h>

float * search_dicho(float v, float *tab, int size){
    
    float * res = NULL;
    int middle = (size/2);
    if(size < 1){
        res = NULL;
    }
    else if(tab[middle] == v){
        res = &tab[middle];
    }
    else if(tab[middle] > v){
        res = search_dicho(v, &tab[0], middle);
    }
    else if(tab[middle] < v){
        res = search_dicho(v, &tab[middle + 1], size - (middle + 1));
    }
    return res;  
}

int main(void){
    
    float tab[SIZE] = {1,15.53,20.89,27,38,42.2,63,64.9,78,80};
    float * p = &tab[0];
    float * res = NULL;
    float x;
    scanf("%f", &x);
    res = search_dicho(x, p, SIZE);
    if(res == NULL){
        printf("Po lo\n");
    }
    else {
        printf("l'élement %f est là, merci à lui\n", *res);
    }
    return 0;
}




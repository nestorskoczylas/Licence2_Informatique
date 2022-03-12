#include <stdio.h>

float * search_interval(float v, float *tab, float *end){
    float * res = NULL;
    int size = end - tab;
    int middle = (size/2);
    if(size < 1){
        res = NULL;
    }
    else if(tab[middle] == v){
        res = &tab[middle];
    }
    else if(tab[middle] > v){
        res = search_interval(v, tab, (tab+ middle));
    }
    else if(tab[middle] < v){
        res = search_interval(v, (tab + middle + 1), end);
    }
    return res;  
}

int main(void){
    
    float tab[10] = {1, 15.53, 20.89, 27, 38, 42.2 ,63 ,64.9, 78,80};
    float * p = &tab[0];
    float * end = &tab[9];
    float * res = NULL;
    float x;
    scanf("%f", &x);
    res = search_interval(x, p, end);
    if(res == NULL){
        printf("Po lo\n");
    }
    else {
        printf("l'élement %.2f est là, merci à lui\n", *res);
    }
    return 0;
}
#include <stdio.h>

#define SIZE 10

typedef int(func_t)(int);

int filter_int(func_t *f, const int *from, int *to, unsigned int size){
    int i, j;
    for (j = i = 0; i < size; i++){
        if (f(from[i])){
            to[j++] = from[i];
        }
    }
    return j;
}

int even(int nb){
    return (nb % 2 == 0) ? 1 : 0;
}

int main(){
    int from[SIZE] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int to[SIZE];

    int x = filter_int(&even, from, to, SIZE);

    for (int i = 0; i < x; i++){
        printf("%d\n", to[i]);
    }

    return 0;
}
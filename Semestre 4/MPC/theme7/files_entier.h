#include <stdlib.h>
#include <stdio.h>
#ifndef FILES_ENTIER
#define FILES_ENTIER

/* QUESTION 1 : */

typedef struct ififo_node_s ififo_node_s;
struct ififo_node_s
{
    int nombre;
    ififo_node_s *noeud;
};

/* QUESTION 2 : */

typedef struct ififo_s ififo_s;
struct ififo_s
{
    ififo_node_s *suivant;
    ififo_node_s *dernier;
};

ififo_s *ififo_new();
int ififo_is_empty(ififo_s *f);
int ififo_enqueue(ififo_s *f, int nb);
int ififo_dequeue(ififo_s *f, int *nb);
int ififo_head(const ififo_s *f);
typedef void(func_t)(int);
int ififo_apply(ififo_s *f, func_t *fn);
void ififo_del(ififo_s *f);
void print_int(int i);

#endif
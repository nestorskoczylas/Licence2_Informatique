#include <stdio.h>
#include <stdlib.h>
#ifndef FILES_GENERIQUE
#define FILES_GENERIQUE

/* QUESTION 1 : */

typedef struct gfifo_node_s gfifo_node_s;

struct gfifo_node_s{
    void *nombre;
    struct gfifo_node_s *noeud;
};

typedef struct gfifo_s gfifo_s;

struct gfifo_s{
    struct gfifo_node_s *suivant;
    struct gfifo_node_s *dernier;
};

gfifo_s *gfifo_new();
int gfifo_del(gfifo_s *f);

int gfifo_size(gfifo_s *f);

int gfifo_enqueue(gfifo_s *f, void *nb);
int gfifo_dequeue(gfifo_s *f, void **nb);

typedef void(gfunc_t)(void *);
void printg_int(void *i);
int gfifo_apply(gfifo_s *f, gfunc_t *fn);

#endif
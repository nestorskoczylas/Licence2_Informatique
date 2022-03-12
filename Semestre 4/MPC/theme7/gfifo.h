#include <stdlib.h>
#include <stdio.h>
#ifndef GFIFO
#define GFIFO

typedef struct gfifo_node_s gfifo_node_s;

struct gfifo_node_s{
    void *nombre;
    gfifo_node_s *noeud;
};

typedef struct gfifo_s gfifo_s;

struct gfifo_s{
    gfifo_node_s *suivant;
    gfifo_node_s *dernier;
};

struct gfifo_s *gfifo_new();

int gfifo_del(struct gfifo_s *f);

int gfifo_size(struct gfifo_s *f);

int gfifo_enqueue(struct gfifo_s *f, void *p);
int gfifo_dequeue(struct gfifo_s *f, void **p);
void print_int(int i);

typedef void(gfunc_t)(void *);
int gfifo_apply(struct gfifo_s *f, gfunc_t *fn);

#endif
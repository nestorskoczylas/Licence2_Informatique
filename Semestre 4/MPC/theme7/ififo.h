#include <stdlib.h>
#include <stdio.h>
#ifndef IFIFO
#define IFIFO

typedef struct ififo_node_s ififo_node_s;

struct ififo_node_s{
    int nombre;
    ififo_node_s *noeud;
};

typedef struct ififo_s ififo_s;

struct ififo_s{
    ififo_node_s *suivant;
    ififo_node_s *dernier;
};

struct ififo_s *ififo_new();

int ififo_is_empty(struct ififo_s *f);

int ififo_enqueue(struct ififo_s *f, int new_val);

int ififo_dequeue(struct ififo_s *f, int *head);

int ififo_head(const struct ififo_s *f);

typedef void(func_t)(int);

int ififo_apply(struct ififo_s *f, func_t *fn);

void ififo_del(struct ififo_s *f);

#endif

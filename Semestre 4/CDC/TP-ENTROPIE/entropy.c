#include<stdio.h>
#include<stdlib.h>

#include "lib/entropy.h"

int main(int argc, char **argv) {

  if (argc <= 1) {
    fprintf(stderr, "Usage: %s <filename>\n", argv[0]);
    exit(1);
  }
  FILE *file = fopen(argv[1], "r");
  
  int counts[256];
  int i;
  for (i = 0; i < 256; i++) {
    counts[i] = 0;
  }
  count_occurrences(file, counts);
  struct file_stat a = entropy(counts);
  printf("Le fichier fait %d octets et a une entropie de %.2f bits par octet\n",
    a.size,a.entropy);
  
  float improv = (a.entropy*a.size) / 8; // nb d'octet du fichier avec codage opti
  improv = a.size - improv;              //nb d'octet "gagnés" grace au codage
  improv = (improv / a.size) * 100;      // pourcentage de reduction
  printf("Au mieux un codage optimal améliorerait le stockage de ce fichier de %.2f%%\n", improv);
  fclose(file);
  
  exit(0);
}


#include <stdio.h>
#include <math.h>
#include "entropy.h"

void count_occurrences(FILE * file, int counts[]){
  int c;
  while((c = fgetc(file)) != EOF){
    counts[c]++;
  }
}

struct file_stat entropy(int counts[]){

  struct file_stat res;
  int cpt = 0;
  float ent = 0;

  for(int i = 0; i < 256; i++){
    if(counts[i] != 0) {
      cpt += counts[i];
      ent += counts[i] * log2(counts[i]);
    }
  }

  res.size = cpt;
  res.entropy = log2(cpt) - ent / cpt;

  return res;
}


# Compilation modulaire

Faites dans ce dossier votre travail sur la compilation modulaire.

Correction des scénarios
 Scénario 1:

Fichier foo.h
extern void foo ();

Fichier foo.c
void foo () {
}

Fichier main.c
#include ”foo.h”
int main () {
foo ();
}

Fichier Makefile
all : main

main : main.o
    cc −o main main.o

main.o : main.c foo.h
    cc −c main.c

foo.o : foo.c
    cc −c foo.c


Scénario 2 :

Fichier foo.h
extern void foo ();


Fichier foo.c
void foo () {
}

Fichier main.c
# include ” foo.h”
i n t main () {
foo ();
}

Fichier Makefile
all : main

main : main.o
    cc −o main main.o foo.o

main.o : main.c foo.h
    cc −c main.c

foo.o : foo.c
    cc −c foo.c


Scénario 3 :

Fichier foo.h
extern void foo ();

Fichier foo.c
void foo () {
}

Fichier main.c
# include  ”foo.h”

int main () {
foo ( ) ;
}

Fichier Makefile
all : main

main : main.o
    cc −o main main.o foo.o

main.o : main.c foo.h
    cc −c main.c

foo.o : foo.c
    cc −c foo.c

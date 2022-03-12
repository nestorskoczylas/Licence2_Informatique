CC = gcc
CFLAGS = -Wall -O0 -g

all: trier_file

trier_file : trier_file.o ififo.o gfifo.o
	$(CC) $(CFLAGS) -o trier_file trier_file.o ififo.o gfifo.o

trier_file.o: trier_file.c
	$(CC) $(CFLAGS) -c trier_file.c

#ififo: ififo.o
#	$(CC) $(CFLAGS) -o ififo ififo.o gfifo.o


ififo.o: ififo.c
	$(CC) $(CFLAGS) -c ififo.c

#gfifo: gfifo.o
#	$(CC) $(CFLAGS) -o gfifo gfifo.o

gfifo.o: gfifo.c
	$(CC) $(CFLAGS) -c gfifo.c

clean:
	rm -f *.o ififo gfifo trier_file

.PHONY: all clean

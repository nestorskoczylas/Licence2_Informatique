CFLAGS=-ansi -Wall -pedantic

all: input output

input: input.o

output: output.o

input.o: input.c commun.h

output.o: output.c commun.h

test: input output
	./output > data.bin
	./input < data.bin
	hd ./data.bin

clean:
	rm -f *.o output input data.bin

.PHONY: all clean


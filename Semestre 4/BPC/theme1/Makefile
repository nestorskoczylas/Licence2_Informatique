all: test

numbers-test: numbers-test.o
	gcc -o numbers-test numbers-test.o

numbers-test.o: numbers-test.c
	gcc -c numbers-test.c

test: numbers-test
	./numbers-test > out.txt
	diff -s out.txt numbers-out.txt
	rm out.txt

clean:
	rm -f *.o numbers-test tmp

.PHONY: all test clean

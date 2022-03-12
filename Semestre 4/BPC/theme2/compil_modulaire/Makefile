CC = gcc
CFLAGS = -Wall -Werror -ansi -pedantic

all : numbers_test


put_numbers.o : put_numbers.c
	$(CC) $(FLAGS) -c $^ -o $@

numbers_test.o : numbers_test.c put_numbers.h
	$(CC) $(FLAGS) -c numbers_test.c -o $@

numbers_test : put_numbers.o numbers_test.o
	$(CC) $(FLAGS) $^ -o $@

clean :
	rm -f *.o numbers_test

.PHONY : all clean

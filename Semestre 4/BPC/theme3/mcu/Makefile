CFLAGS=-ansi -Wall -pedantic
CC = gcc
SRC = src/
BUILD = build/

all : mcu_test

mcu_fatal.o : $(SRC)mcu_fatal.c
	$(CC) $(CFLAGS) -c $^

mcu_readl.o : $(SRC)mcu_readl.c
	$(CC) $(CFLAGS) -c $^

mcu_putint.o : $(SRC)mcu_putint.c
	$(CC) $(CFLAGS) -c $^

mcu_test.o : $(SRC)mcu_test.c
	$(CC) $(CFLAGS) -c $^

mcu_wc.o : $(SRC)mcu_wc.c
	$(CC) $(CFLAGS) -c $^

mcu_wl.o : $(SRC)mcu_wl.c
	$(CC) $(CFLAGS) -c $^

mcu_rev.o : $(SRC)mcu_rev.c
	$(CC) $(CFLAGS) -c $^

mcu_uniq.o : $(SRC)mcu_uniq.c
	$(CC) $(CFLAGS) -c $^

mcu_test : $(SRC)mcu_test.o $(SRC)mcu_fatal.o $(SRC)mcu_readl.o $(SRC)mcu_putint.o
	$(CC) $(CFLAGS) $^ -o $(BUILD)$@

mcu_wc : $(SRC)mcu_wc.o $(SRC)mcu_putint.o $(SRC)mcu_fatal.o
	$(CC) $(CFLAGS) $^ -o $(BUILD)$@

mcu_wl : $(SRC)mcu_wl.o $(SRC)mcu_putint.o $(SRC)mcu_fatal.o
	$(CC) $(CFLAGS) $^ -o $(BUILD)$@

mcu_rev : $(SRC)mcu_rev.o $(SRC)mcu_fatal.o $(SRC)mcu_readl.o
	$(CC) $(CFLAGS) $^ -o $(BUILD)$@

mcu_uniq : $(SRC)mcu_uniq.o $(SRC)mcu_fatal.o $(SRC)mcu_readl.o
	$(CC) $(CFLAGS) $^ -o $(BUILD)$@




clean:
	rm -f $(SRC)*.o
	rm -f $(BUILD)mcu_*

.PHONY: all clean

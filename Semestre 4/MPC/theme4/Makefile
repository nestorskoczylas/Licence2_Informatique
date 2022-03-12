CC = gcc
SRC = src/
BUILD = build/


exercice2.o : $(SRC)exercice2.c $(SRC)mcu_putint.h
	$(CC) -c $^

mcu_putint.o : $(SRC)mcu_putint.c
	$(CC) -c $^

exercice1 : $(SRC)exercice1.c
	$(CC) -o $(BUILD)$@ $^

exercice2 : $(SRC)exercice2.o $(SRC)mcu_putint.o
	$(CC) -o $(BUILD)$@ $^

exercice3 : $(SRC)exercice3.c
	$(CC) -o $(BUILD)$@ $^

exercice4 : $(SRC)exercice4.c
	$(CC) -o $(BUILD)$@ $^

exercice5 : $(SRC)exercice5.c
	$(CC) -o $(BUILD)$@ $^

exercice6 : $(SRC)exercice6.c
	$(CC) -o $(BUILD)$@ $^

clear :
	rm $(SRC)*.o

.PHONY : clear
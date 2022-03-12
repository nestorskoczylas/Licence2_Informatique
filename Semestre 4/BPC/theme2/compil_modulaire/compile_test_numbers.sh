gcc -c put_numbers.c;
gcc -c numbers_test.c;
gcc -o numbers_test put_numbers.o numbers_test.o;
rm put_numbers.o;
rm numbers_test.o;

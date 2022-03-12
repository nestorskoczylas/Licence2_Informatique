#include <stdio.h>

extern int putchar(int);

static int put_digit(int digit){

  int res = 0;
  
  if ( digit < 0 || digit > 9){
    res = -1;
  }
  
  else {
    
    int b = putchar(digit + 48);

    if (b == EOF){
      res = -1;
    }

  }
  
  return res;
}


static int put_hdigit(int h){

  int res = 0;

  if (h < 0 || h > 15){
    res = -1;

  }

  else if (h < 10){
    res = put_digit(h);
  }

  else {

    int b = putchar(h + 55);

    if (b == EOF){
      res = -1;
    }

  }

  return res;
}


int putdec(int d){

  int res = 0;

  if (d == 0){
    putchar('0');
  }

  if (d < 0){
    putchar('-');
  }

  int index = 1000000000;

  while (index > 0 && ((d / index) % 10 == 0)){
      index = index / 10;
	}

    while (index > 0){
      int chiffre = (d/ index) % 10;
      chiffre = (chiffre < 0) ? -chiffre : chiffre;
      int b = put_digit(chiffre);
      index = index / 10;

      if(b == -1){
	res = -1;
      }
      
    }

    return res;

}


int putbin(unsigned int b){
  int res = 0;
  if (b > 1){
    res = putbin(b >> 1);
  }

  int a = putchar('0' + (b & 1));

  if (a == EOF){
    res = -1;
      }
  
  return res;
  
}

int puthex(unsigned int h){
  int res = 0;
  if (h > 15){
    res = puthex(h >> 4);
  }

  int a = put_hdigit(h & 15);

  if (a == EOF){
    res = -1;
      }
  
  return res;

}

void newline(){
  putchar('\n');
}
  


int put_test_line(int n)
{
    putchar('t');
    putchar('e');
    putchar('s');
    putchar('t');
    putchar(' ');
    putchar('#');
    putdec(n);
    putchar(':');

    return 0;
}
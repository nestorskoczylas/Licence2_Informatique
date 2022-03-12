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

int putdec(int d){

    int res = 0;
    int index = 1000000000;
    int b;

  if (d == 0){
    putchar('0');
  }

  if (d < 0){
    putchar('-');
  }


  while (index > 0 && ((d / index) % 10 == 0)){
      index = index / 10;
	}
    
    
    while (index > 0){
      int chiffre = (d/ index) % 10;
      chiffre = (chiffre < 0) ? -chiffre : chiffre;
      b = put_digit(chiffre);
      index = index / 10;

      if(b == -1){
	res = -1;
      }
      
    }

    return res;

}




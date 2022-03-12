#include <stdio.h>

extern int putchar(int);

int put_digit(int digit){

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


int put_hdigit(int h){

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


int main()
{
 
    int i=-2147483648;
    put_test_line(1); putdec(214); newline();
    put_test_line(2); putdec(-74); newline();
    put_test_line(3); putdec(1); newline();
    put_test_line(4); putdec(-1); newline();
    put_test_line(5); putdec(0); newline();
    put_test_line(6); putdec(2147483647); newline();
    put_test_line(7); putdec(-2147483648); newline();
    put_test_line(8); putdec(-(-2147483648)); newline();
    put_test_line(9); puthex(0); newline();
    put_test_line(10); puthex(10); newline();
    put_test_line(11); puthex(16); newline();
    put_test_line(12); puthex(2147483647); newline();
    put_test_line(13); puthex(-2147483648); newline();
    put_test_line(14); puthex(0xCAFEBABE); newline();
    put_test_line(15); puthex(-1); newline();
    put_test_line(16); putbin(0); newline();
    put_test_line(17); putbin(1); newline();
    put_test_line(18); putbin(-1); newline();
    put_test_line(19); putbin(2147483647); newline();
    put_test_line(20); putbin(-2147483648); newline();



 /* 
  put_digit(8);
  
  put_digit(78);
  put_hdigit(9);
  put_hdigit(12);
  putdec(45685);
  putdec(-2147483648);
  putchar('\n');
  putbin(42);
  putchar('\n');
  putbin(-1);
  putchar('\n');
  putbin(2147483647);
  putchar('\n');
  putbin(-2147483648);
  putchar('\n');
  
  
  int a = puthex(4857662);
  
  return 0;

  */
}


#include<stdio.h>
#include<stdbool.h>

int main)
{
      FILE * test;
      test = fopen"test.txt", "w");
      int n;
      whiletrue){
            printf"input a number1 to quit): ");
            scanf"%d",&n);
            ifn  == 1break;
           
            fprintftest, "%d",n);
            }

      fclosetest);

      FILE * read;
      read = fopen"test.txt", "r");
      
      int finput = 0;
      fscanfread, "%d",&finput);

      fprintfread, "%d",finput);
      fcloseread);

      
}
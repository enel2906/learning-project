#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>


int excercise)
{
      int n1, n2;
      int arr1[100], arr2[100];
      printf"Enter number of first array: "); scanf"%d",&n1);
      printf"Enter first array: "); 
      forint i = 0;i<n1;i++){
            scanf"%d",&arr1[i]);
      }
      printf"Enter number of second array: "); scanf"%d",&n2);
      printf"Enter second array: ");
       forint i = 0;i<n2;i++){
            scanf"%d",&arr2[i]);
      }
      ifn1!=n2return 0;
      else{
            int count1 = 0;
            int count2 = 0;
            forint i = 0;i<n1;i++){
                  ifarr1[i]==arr2[i]count1++;
                  ifarr1[i]==arr2[n11i]count2++;
            }
            ifcount1 == n1return 1;
            else ifcount2 == n2return 1;
      }
      

}


void Question2)
{
      char arcticle[5][10] = {"the","a","one","some","any"};
    char noun[5][10] =  {"boy","girl","dog","town","car"};
    char verb[5][10] = {"drove","jumped","ran","walked","skipped"};
    char prepositions[5][10] = {"to","from","over","under","on"};
    

    int n;
    printf"Enter the number of sentences: ");scanf"%d",&n);
    
   
      
      srandtimeNULL));

      forint i = 0;i<n;i++){
            int random = rand% 5;
            forint i = 0;i<strlenarcticle[random]);i++){
                  ifi==0printf"%c",arcticle[random][i]32);
                  else printf"%c",arcticle[random][i]);
            }
            
            printf" %s %s %s %s %s.\n",noun[rand)%5],verb[rand)%5],prepositions[rand)%5],arcticle[rand)%5],noun[rand)%5]);
      }
}

typedef struct{
      char name[26];
      char first_name[6];
}Struct;

void cat_tenStruct studen)
{
      int a = 0;
      forint i = strlenstuden.name)1;i>=0;i)
      {
            ifstuden.name[i]==' '){
                  a = i;
                  break;
            }
      }
      forint i = a+1;i<strlenstuden.name);i++){
            studen.first_name[ia1] = studen.name[i];
            
      }
      
}

void swap_stringchar s1[], char s2[])
{
      char temp[26];
      strcpytemp,s1);
      strcpys1,s2);
      strcpys2,temp);
     
}



void Question1)
{
      Struct student[10];
      int n;
      printf"Enter thu number of students: ");
      scanf"%d",&n); fflushstdin);
      forint i = 0;i<n;i++
      {
            scanf"%[^\n]s",&student[i].name);
            fflushstdin);
      }
     forint i = 0;i<n;i++){
            cat_tenstudent[i]);
     }

     

      forint i = 0; i < n;i++ ){
            forint j = i+1;j<n;j++){
                  ifstudent[i].first_name[0]>=student[j].first_name[0]{
                        swap_string&student[i].name,&student[j].name);
                        
                        
                  }
                  
            }
      }
      forint i = 0;i<n;i++printf"%s\n",student[i].name);



      



}

int main)
{
      int n=0;
      while1>0){
            printf"Enter the question: "); scanf"%d",&n);
            ifn<1||n>3break;
            else{
                  switchn){
                        case 2: Question1); break;
                        case 3: Question2); break;
                        case 1: printf"%d\n",excercise)); break;
                        default: break;

                  }
            }
      }
}



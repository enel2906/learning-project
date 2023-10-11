#include<stdio.h>
#include<string.h>

/*Pham Nhat Minh 20215225*/

typedef struct{
      char team[20];
      int point;
      int dif;
}Struct;

void Function1Struct doi[], int* x, int* y)
{
      int a, b;
      printf"Nhap so doi cua bang 1: ");
      do{
            scanf"%d",&a);
            ifa<1||a>5printf"Khong hop le\nMoi ban nhap lai: ");
      }whilea<1||a>5);

      forint i = 0;i<a;i++){
            printf"Nhap thong tin doi: ");
            fflushstdin); scanf"%s%d%d",&doi[i].team,&doi[i].point,&doi[i].dif); 
      }

      printf"Nhap so doi cua bang 2: ");
      do{
            scanf"%d",&b);
            ifb<1||b>5printf"Khong hop le\nMoi ban nhap lai: ");
      }whileb<1||b>5);

      forint i = a;i<a+b;i++){
            printf"Nhap thong tin doi: ");
            fflushstdin); scanf"%s%d%d",&doi[i].team,&doi[i].point,&doi[i].dif); \
      }
      *x += a;
      *y += b;


}

void swap_intint *x, int* y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
}

void swap_stringchar s1[], char s2[])
{
    char str[100];
    strcpystr, s1);
    strcpys1, s2);
    strcpys2, str);
}

void Function2Struct doi[], int* x, int* y)
{
      printf"Bang 1\n");
      forint i = 0; i < *x;i++){
            printf"%5s%5d%5d\n",doi[i].team,doi[i].point,doi[i].dif);

      }
      printf"Bang 2\n");
      forint i = *x; i< *y+*x;i++){
            
            printf"%5s%5d%5d\n",doi[i].team,doi[i].point,doi[i].dif);
      }
}

void Function3Struct doi[], int* x, int* y)
{
      forint i = 0; i < *x;i++){
            forint j = i+1; j < *x ;j++){
                  ifdoi[i].point<doi[j].point){
                        swap_int&doi[i].dif,&doi[j].dif);
                        swap_int&doi[i].point,&doi[j].point);
                        swap_stringdoi[i].team,doi[j].team);
                  }
                  ifdoi[i].point==doi[j].point){
                        ifdoi[i].dif<doi[j].dif){
                        swap_int&doi[i].dif,&doi[j].dif);
                        swap_int&doi[i].point,&doi[j].point);
                        swap_stringdoi[i].team,doi[j].team);
                        }
                  }
                  
            }
      }
      forint i = *x; i<*x+*y;i++){
            forint j = i+1; j < *x+*y ;j++){
                  ifdoi[i].point<doi[j].point){
                        swap_int&doi[i].dif,&doi[j].dif);
                        swap_int&doi[i].point,&doi[j].point);
                        swap_stringdoi[i].team,doi[j].team);
                  }
                  ifdoi[i].point==doi[j].point){
                        ifdoi[i].dif<doi[j].dif){
                        swap_int&doi[i].dif,&doi[j].dif);
                        swap_int&doi[i].point,&doi[j].point);
                        swap_stringdoi[i].team,doi[j].team);
                        }
                  }
                  
            }
      }
}

void Function4Struct doi[], int* x, int *y)
{
      int a,b,c,d,e,f;
      printf"Nhap ty so: ");
      do{
            scanf"%d%d%d%d%d%d",&a,&b,&c,&d,&e,&f);
            ifa==b||c==d||e==fprintf"Khong hop le\nMoi nhap lai: ");
      }whilea==b||c==d||e==f);

      forint i = 0;i<2;i++printf"BK%d: %s %s\n\n",i+1,doi[i].team, doi[*x+1i].team);

      ifa>b){
            ifc>d){
                  printf"CK: %s %s\n",doi[0].team,doi[1].team);
                  ife>fprintf"CHAMPION: %s\n",doi[0].team);
                  else printf"CHAMPION: %s",doi[1].team);
            }
            else{
                 printf"CK: %s %s\n",doi[0].team,doi[*x].team); 
                 ife>fprintf"CHAMPION: %s\n",doi[0].team);
                 else printf"CHAMPION: %s\n",doi[*x].team);
            }

      }
      ifa<b){
            ifc>d){
                  printf"CK: %s %s\n",doi[*x+1].team,doi[1].team);
                  ife>fprintf"CHAMPION: %s\n",doi[*x+1].team);
                  else printf"CHAMPION: %s\n",doi[1].team);
            }
            else{
                  printf"CK: %s %s\n",doi[*x+1].team,doi[*x].team);
                  ife>fprintf"CHAMPION: %s\n",doi[*x+1].team);
                  else printf"CHAMPION: %s\n",doi[*x].team);
            }
      }
      

}

int main)
{
      Struct doi[100];
      int x = 0, y = 0;
      int* ptr1 = &x;
      int* ptr2 = &y;
      int n;
      do{
            printf"1.ENTER\n2.PRINT\n3.SORT\n4.CHAMPION\n5.EXIT\n");
            scanf"%d",&n);
            switchn){
                  case 1: Function1doi, ptr1, ptr2); break;
                  case 2: Function2doi, ptr1, ptr2); break;
                  case 3: Function3doi, ptr1, ptr2); break;
                  case 4: Function4doi, ptr1, ptr2); break;
                  

            }
      }whilen!=5);
}

/*Pham Nhat MInh 20215225*/
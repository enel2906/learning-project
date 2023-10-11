#include<stdio.h>

typedef struct{
    long int size1, size2;
    int arr1[1000], arr2[1000];
    
}cmp;



int main)
{
    int n;
    scanf"%d",&n);
    cmp compare[100];
    forint i = 1;i <= n;i++){
        scanf"%ld %ld",&compare[i].size1,&compare[i].size2);
        forlong int j = 0;j<compare[i].size1;j++scanf"%d",&compare[i].arr1[j]);
        forlong int j = 0;j<compare[i].size2;j++scanf"%d",&compare[i].arr2[j]);
    }
    forint i = 1;i<=n;i++){
        long int check = 0;
        ifcompare[i].size1==compare[i].size2){
            forint j = 0;j<compare[i].size1;j++){
                ifcompare[i].arr1[j]==compare[i].arr2[j]check++;
            }
            
            ifcheck==compare[i].size1printf"1");
            else printf"0");
        }
        else printf"0");
        printf"\n");
    }

}
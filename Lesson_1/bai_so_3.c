#include<stdio.h>
#include<string.h>
#define ALPHABET_LEN 26


int checkchar s[], int n){
    int count = 0;
    forint i = 0;i<n;i++){
        ifs[i]==s[n]count++;
    }
    ifcount > 0return 1;
    else return 0;
}

int main)
{
    char s[100];
    printf"Enter the string: ");
    scanf"%[^\n]s",s);
    int count[ALPHABET_LEN] = {0};
    forint i = 0;i<strlens);i++){
        ifs[i]>='a'&&s[i]<='z'++count[s[i]'a'];
        ifs[i]>='A'&&s[i]<='Z'++count[s[i]'A'];

    }
    forint i = 0;i<ALPHABET_LEN;i++){
        ifcount[i]>0){
            printf"%c %d\n", s[i], count[i]);
        }
    }
    

   
}
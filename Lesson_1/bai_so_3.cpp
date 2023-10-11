#include<stdio.h>
#include<string.h>
#define ALPHABET_LEN 26




int main)
{
    char s[100];
    
    scanf"%[^\n]s",s);
    int count[ALPHABET_LEN] = {0};
    forint i = 0;i<strlens);i++){
        ifs[i]>='a'&&s[i]<='z'++count[s[i]'a'];
        ifs[i]>='A'&&s[i]<='Z'++count[s[i]'A'];

    }
    forint i = 0;i<ALPHABET_LEN;i++){
        ifcount[i]>0){
            printf"%c %d\n", 'a'+i, count[i]);
        }
    }
    

   
}
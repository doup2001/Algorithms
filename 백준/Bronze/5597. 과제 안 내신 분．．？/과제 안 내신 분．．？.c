#include <stdio.h>



int main(){
    int list[31];
    int n;

    for (int i = 1; i <= 30; i++)
    {
        list[i] = i;
    }
    

    for (int i = 0; i < 28; i++)
    {
        scanf("%d",&n);

        for (int j = 1; j <= 30; j++)
        {
            if (n == list[j]){
                list[j] = 0;
            } 
        }
    }

    int small = 30;
    int big = 0;
    
    for (int i = 1; i <= 30; i++)
    {

        if (list[i] > 0)
        {
            if (small > list[i])
            {
                small = list[i];
            } 

            if (big < list[i])
            {
                big = list[i];
            }
        }     
        
    }
    
    printf("%d\n",small);
    printf("%d\n",big);
    


    return 0;
}
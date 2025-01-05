#include <stdio.h>

int main() {

    int array[9]; 
    
    for(int i = 1 ; i< 10 ; i++){
        scanf("%d",&array[i]);
    }

    int big = array[1];
    int index = 1;

    for (int i = 1; i < 10; i++)
    {
        if (big < array[i])
        {
            big = array[i];
            index = i;

        } else{
            big = big;
        }
    }
    
    printf("%d\n", big);
    printf("%d\n",index);


    return 0;
}
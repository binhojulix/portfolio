#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(){
    srand(time(0));
    int numerosecreto = rand() % 100;
    printf("numero secreto %d", numerosecreto);
    system("pause");
}
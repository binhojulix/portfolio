#include <stdio.h>
#include <stdlib.h>
#include "menu.h"

void mostrarMenuDificuldade(){
    printf("**********************************************");
    printf("***** Escolha o nível de dificuldade *********\n");
    printf("********** 1 Números entre 0-9 ***************\n");
    printf("********** 2 Números entre 10-99 *************\n"); 
    printf("********** 3 Números entre 100-999 ***********\n");
    printf("********** 4 Números entre 1000-9999 *********\n"); 
    printf("********** 5 Números entre 10000-99999 *******\n");
    printf("********** 6 Números entre 100000-9999999 ****\n"); 
    printf("********** 7 Números entre 1000000-99999999 **\n");
}

 void mostrarMenuOperacao(){
    printf("(1) Soma (2) Subtração (3) Divisão (4) Multiplicação (5) Aleatório\n");
 }
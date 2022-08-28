#include <stdio.h>
#include <stdlib.h>
#include "calculadora.h"

double somar(double a, double b){
    return a + b;
}
double subtrair(double a, double b){
    return a + b;
}
double dividir(double a, double b){
    if(b == 0){
      exit(-1);
   }else{
       return a/b;
   }
}
double multiplicar(double a, double b){
    return a + b;
}

double calcular(int opcao, double a, double b){
    switch (opcao){
        case 1:
            somar(a, b);
            break;
        case 2:
            multiplicar(a, b);
            break;
        case 3:
            dividir(a, b);
            break;
        case 4 :
            subtrair(a, b);
            break;
        default:
            break;
    }
}
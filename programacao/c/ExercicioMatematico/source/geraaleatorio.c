#include <stdio.h>
#include <stdlib.h>
#include "geraAleatorio.h"
#include <time.h>

//gera numero aleatorio de acordo com o que é passado para essa funçao
double gerarAleatorio(int quantidade){
    srand(time(0));
    int numerosecreto = rand() % quantidade;
    return numerosecreto;
}


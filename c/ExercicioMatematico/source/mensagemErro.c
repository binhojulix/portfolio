#include <stdio.h>
#include <stdlib.h>
#include "mensagemErro.h"
#include "geraAleatorio.h"

char* getMensagem(int code){
    int aleatorio;
    if(code==1){
        return mensagemCorreta[aleatorio];
    }else{
        return mensagemErrada[aleatorio];
    }
}
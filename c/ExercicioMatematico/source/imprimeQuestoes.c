#include <stdio.h>
#include <stdlib.h>
#include "imprimeQuestoes.h"
#include <string.h>

void imprimeTabela(Impressao *linhas){
    printf("operacao\t certo\t valoresperado\t resultado\t");
    for(int i=0; i< sizeof(linhas); i++){
        impressao(linhas[i]);
    }

}



void ImprimeResultado(Impressao* impressao){
    printf("%s",impressao->operacao);
    printf("%s", impressao->certo);
    printf("%.1lf", impressao->valorEsperado);
    printf("%.1lf", impressao->resultado);
}
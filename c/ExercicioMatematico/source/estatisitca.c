#include <stdio.h>
#include <stdlib.h>
#include "estatistica.h"
#include <string.h>

void imprimeEstatistica(Estatisca* estatistica){

    estatistica->porcentagemDeAcerto = (estatistica->quantidadeDeAcerto * 100) 
                                            / estatistica->quantidadeDeQuestao;

    printf("porcentagem de acerto, %d\n",estatistica->porcentagemDeAcerto);
    printf("quantidade de acerto, %d\n",estatistica->quantidadeDeAcerto);
    printf("quantidade de erro, %d\n",estatistica->quantidadeDeErro);
    printf("quantidade de questao, %d\n",estatistica->quantidadeDeQuestao);

    if(estatistica->porcentagemDeAcerto > 70){
        strcpy(estatistica->mensagem, "parabéns");
    }else{
        strcpy(estatistica->mensagem, "peça ajuda a seu professor");
    }
    printf("%s", estatistica->mensagem);
}
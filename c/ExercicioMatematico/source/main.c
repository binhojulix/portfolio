#include <stdio.h>
#include <stdlib.h>
#include "calculadora.h"
#include "menu.h"
#include "estatistica.h"
#include "geraAleatorio.h"
#include "imprimeQuestoes.h"
#include "mensagemErro.h"

#define NUMERO_DE_PERGUNTAS 10

int main(){

    while(1){

        int difuldade, operacao;
        Estatisca estatistica;
        estatistica.quantidadeDeAcerto=0;
        estatistica.quantidadeDeErro=0;
        estatistica.quantidadeDeQuestao=NUMERO_DE_PERGUNTAS;
        Impressao impressao[NUMERO_DE_PERGUNTAS];
   
        mostrarMenuDificuldade();

        do{
            scanf("%d", &difuldade);
        }while(difuldade < 1 || difuldade > 7 );

        mostrarMenuOperacao();

        do{
            scanf("%d", &operacao);
        }while(operacao < 1 || operacao > 5 );

        if(operacao>4){
            operacao = gerarAleatorio(operacao);
        }

        for(int i=1; i<=NUMERO_DE_PERGUNTAS; i++){
            double resposta;
            double valor1 = aleatorio(difuldade);
            double valor2 = aleatorio(difuldade);

            double resultado = calcular(operacao, valor1, valor2);
            printf("Quanto é %.1f + %.1f", valor1, valor2);

            scanf("%lf", resposta);
            char* mensagem;

            if(resultado == resposta){
                mensagem = getMensagem(1);
                estatistica.quantidadeDeAcerto+=1;
                strcpy(impressao->certo, "sim");
            }else{
                mensagem = getMensagem(0);
                estatistica.quantidadeDeErro+1;
                strcpy(impressao->certo, "nao");
            }
            impressao->resultado=resposta;
            impressao->valorEsperado=resultado;
            
            printf("%s", mensagem);
        }

        mostrarEspostas(&impressao);
        imprimeEstatistica(&estatistica);
        printf("Fim do questionário!\n");
    }
}
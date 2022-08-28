#ifndef _H_MAIN

struct estatistica {
	int quantidadeDeQuestao;
	int quantidadeDeErro;
	int quantidadeDeAcerto;
    int porcentagemDeAcerto; 
    char mensagem[100];
};
typedef struct estatistica Estatisca;

void imprimeEstatistica(Estatisca* estatistica);


#endif
# Dados daspessoas
idade=c(24,48,32,65,38,56,74,19,29,22)
peso=c(80,67,49,55,89,72,45,88,56,74)
altura=c(180,165,162,175,172,165,168,185,172,168)
sexo=c('M','F','M','F','M','F','M','F','M','F')

sexo[c(3,5)]
length(idade)

tabela	=	data.frame(altura,	sexo,	idade,	peso)
View(tabela)

str(tabela)

names(tabela)

tabela$sexo

write.csv(tabela,	"BaseDados.csv")
rm(tabela)
tabela	=	read.csv("BaseDados.csv")
View(tabela)
tabela	=	tabela[,	-1]
head(tabela)	#	por	default,	mostra	as	6	primeiras	linhas

install.packages("ggplot2")
library(ggplot2)
require(graphics)

tempo=c(96,92,106,100,98,104,110,101,116,106,109,100,112,105,118,108,113,112,127,117) 
idade=c(20,20,20,20,25,25,25,25,30,30,30,30,35,35,35,35,40,40,40,40)

length(tempo)
length(idade)

dados <- data.frame(tempo, idade)
dados


ggplot(dados, aes(x=idade, y=tempo)) + geom_point()

# o ajuste sera armazenado no objeto "modelo"

modelo <-lm(data=dados, formula=tempo ~ idade)

modelo$coefficients

summary(modelo)

ggplot(dados, aes(x=idade, y=tempo)) + geom_point() + geom_smooth(method=lm, se=FALSE)


par(mfrow=c(2,2))
plot(modelo, which=c(1:4),pch=20)
barlett.test(data=dados, tempo~idade)

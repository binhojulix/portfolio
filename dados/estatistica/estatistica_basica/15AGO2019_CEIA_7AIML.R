x1 <- c(-1,1,-1,1,-1,1,-1,1,-1.682,1.682,0,0,0,0,0,0,0,0,0)
x2 <- c(-1,-1,1,1,-1,-1,1,1,0,0,-1.682,1.682,0,0,0,0,0,0,0)
x3 <- c(-1,-1,-1,-1,1,1,1,1,0,0,0,0,-1.682,1.682,0,0,0,0,0)
y <- c	(47.37, 53,	53.64, 54.28	,48.85,	53.73,	55.19,	
          58.31,	51.9,	57.34,	47.62,	57.35,	50.73,	
          57.68,	56.24,	55.74,	57.23,	56.85,	55.42)

reg1 <- (lm (y ~ x1))

summary(reg1)

plot(y~x1)
abline

reg2 <- (lm (y ~ x1 + x2))

summary(reg2)

reg3 <- (lm (y ~ x1 + x2 + x3))

summary(reg3)

vendas <- c(9, 6, 4, 3, 3, 5, 8, 2, 7, 4)
exper <- c(6, 5, 3, 1, 4, 3, 6, 2, 4, 2)
qi <- c (3, 2, 2, 1, 1, 3, 3, 1, 2, 2)

reg4 <- (lm (vendas ~ exper))

summary(reg4)

reg5 <- (lm (vendas ~ qi))

summary(reg5)

reg6 <- (lm (vendas ~ exper + qi))

summary(reg6)


reg_res = resid(reg6)



#################################################
#################################################



prod <- c( 30, 29, 24, 30, 34, 35, 36, 36, 48, 27, 30, 21)
renda <- c( 2200, 1380, 1700, 1430, 790, 260, 2250, 1170,
            430, 300, 770, 1170)
pib <- c( 5.1, 3.2, 6.9, 3, 2.8, 1.4, 3.8, 1, -0.3, 2.5, 4.6, 6.2)
desemprego <- c(9.5, 6.8, 2.7, 4.6, 3.8, 3.8, 5, 8.7, 6.4, 2.3, 
                3.3, 3.8)


reg <- (lm(pib ~ desemprego  + renda + prod))

summary(reg)

reg1 <- (lm(prod ~ pib + desemprego))

summary(reg1)

reg10 <- (lm(pib ~ desemprego + prod))

summary(reg10)


reg11 <- (lm(pib ~ renda + desemprego))

summary(reg11)


##############################################
##############################################

pib <- c(6296811, 6320085, 6346698, 6363505,
         6400268, 6421855, 6448194, 6471174,
         6488753, 6512403, 6537474, 6559940,
         6586990, 6602485, 6616011, 6660461,
         6672307, 6694191, 6734017)

div <- c(4399047, 4450007, 4450007, 4527003,
         4547705, 4633517, 4674599, 4722126,
         4768883, 4789342, 4837222, 4852557,
         4854679, 4904275, 4957219, 4984708,
         5045749, 5133268, 5165403)

dolar <- c(3.197, 3.103, 3.127, 3.14, 3.209,
           3.297, 3.205, 3.153, 3.138, 3.196,
           3.257, 3.297, 3.213, 3.243, 3.277,
           3.409, 3.634, 3.783, 3.823)


#################################################
#################################################


obt <- c(30201, 28852, 26819, 26068, 24762, 24968,
            24412, 23771, 24892, 25620, 25744, 25748,
            26654, 25137)

ten <- c(0.8, 0.7, 0.7, 0.6, 0.6, 0.6, 0.5, 0.5, 0.5,
            0.5, 0.5, 0.5, 0.4, 0.5)

hig <- c(0.8, 0.8, 0.7, 0.6, 0.6, 0.6, 0.6, 0.4, 0.4,
            0.3, 0.2, 0.1, 0.2, 0.2)

agu <- c(2.2, 2.1, 2.2, 1.9, 2, 1.3, 1.5, 1.5, 1.5,
          1, 1, 1.1, 1.2, 1.1)

ins <- c(40.1, 21.5, 27.7, 25.6, 34.7, 45.6,
                 33.2, 53.7, 45.5, 29.7, 34.9, 21.2,
                 37.3, 33.9)

fec <- c(321.9, 287.7, 294.3, 299.4, 246.6, 258.5,
               234.8, 253, 196.8, 184.4, 166, 159.4,
               127.5, 131.2)



reg <- (lm(obt ~ ten))
reg <- (lm(obt ~ hig))
reg <- (lm(obt ~ agu))
reg <- (lm(obt ~ isn))
reg <- (lm(obt ~ fec))

reg <- (lm(obt ~ ten + hig))
reg <- (lm(obt ~ ten + aug))
reg <- (lm(obt ~ ten + isn))
reg <- (lm(obt ~ ten + fec))

reg <- (lm(obt ~ hig + agu))
reg <- (lm(obt ~ hig + isn))
reg <- (lm(obt ~ hig + fec))

reg <- (lm(obt ~ agu + isn))
reg <- (lm(obt ~ agu + fec))
reg <- (lm(obt ~ agu + ten))

reg <- (lm(obt ~ hig + fec))





summary(reg)


##########################################################
##########################################################

txmorte <- c(24.68, 23.39, 22.18, 21.04, 19.98, 18.99,
           18.07, 16.43, 15.69, 15.02, 14.4, 13.82)

fundamental <- c(93.8, 93.8, 94.4, 94.8, 94.6, 94.9, 95.3,
                 95.5, 96.1, 96.1, 96.3, 96.5)

medio <- c(43.1, 44.4, 45.3, 47.1, 48, 50.4, 50.9, 51.6,
           54, 55.1, 56.3, 56.9)

txfec <- c(2.2, 2.14, 2.09, 2.04, 1.99, 1.95, 1.91, 1.83,
           1.8, 1.77, 1.74, 1.56)

nasvivo <- c(2822462, 2818918, 2880877, 2803938, 2755371,
             2798042, 2764642, 2824776, 2830458, 2832590,
             2913121, 2952969)

semsaneamento <- c(2992, 2957, 2861, 2666, 2536, 2276, 2111,
                 1838, 1649, 1588, 1431, 1315)

comsaneamento <- c(47094, 49150, 50512, 52082, 53802, 55905,
                   57142, 60279, 62120, 63542, 65607, 66722)

reg <- (lm(txmorte ~ semsaneamento))#0.9786

summary(reg)

########################################################
########################################################

Y <- c(6.5,5.8,7.8,8.1,10.4,12.3,13.1,17.4,20.1,24.5,25.5,27.1) # Variável resposta
X <- c(1.4,1.5,1.7,1.9,2.1,2.2,2.4,3.2,3.7,4.2,4.8,5.2)       # Variável explicativa
dados <- data.frame(Y,X)
dados

modelo.regressao <- lm(Y ~ X, data= dados)
summary(modelo.regressao)  # Estimativa dos parâmetros, Erro, R2 do modelo

anova(modelo.regressao)    # Tabela de ANOVA

plot (Y ~ X,pch=16 ,data = dados)
abline(modelo.regressao,col="red") # Esta função ajusta a reta do modelo aos dados






library(ggplot2)
ggplot(data=dados,aes(y=Y,x=X))+geom_point()+geom_smooth(method="lm")

plot(resid(modelo.regressao) ~ predict(modelo.regressao),pch=16) # Resíduos vs. Y esperado
abline(0,0,col="red") # Coloca uma reta no Y = 0

par(mfrow=c(2,2))
plot(modelo.regressao) # Diagnóstico completo dos resíduos

coef(modelo.regressao)      # Coeficientes do modelo (intercepto e beta)
predict(modelo.regressao)   # Valores previstos pelo modelo
residuals(modelo.regressao) # Resíduos do modelo


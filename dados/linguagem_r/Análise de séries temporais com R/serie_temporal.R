wwwusage = scan("wwwusage.txt", skip=1)
# x-axis mostra os valores de 0 to 120 enquanto y-axis mostra valorores 80 a 250 de acordo com  min, max valore do dataset
plot(1:100, wwwusage, xlim = c(0, 120), ylim=c(80, 250))
#conecta o datpoint com a linha
lines(1:100, wwwusage, type="l")

acf(wwwusage, lag.max=100)
pacf(wwwusage, lag.max=100)

z = diff(wwwusage, 1, 1)
plot(1:99, z, xlim = c(0, 120), ylim=c(-15, 15))
lines(1:99, z, type="l" )

z = diff(wwwusage, 1, 2)
plot(1:98, z, xlim = c(0, 120), ylim=c(-15, 15))
lines(1:98, z, type="l" )

acf(z, lag.max=100)
pacf(z, lag.max=100)

fit1 = arima(wwwusage, order = c(0,2,2))
tsdiag(fit1)

fit2 = arima(wwwusage, order = c(2,2,0))
tsdiag(fit2)
install.packages("forecast")
library(forecast)
fit3 = auto.arima(wwwusage)
tsdiag(fit3)
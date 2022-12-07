dowfile <- function(url){
  file.url = url
  file.local = file.path('./data', basename(file.url))
  download.file(url = file.url, destfile = file.local , mode='wb')
  return()
}


dowfile("https://storage.googleapis.com/ds-publico/Copas.csv")
dowfile("https://storage.googleapis.com/ds-publico/Copas-Partidas.csv")
dowfile("https://storage.googleapis.com/ds-publico/Copas-Jogadores.csv")



copa<- read.table("data/Copas.csv")
copa_partida<- read.table("data/Copas-Partidas.csv")
copa_jogadores<- read.csv("~/data/Copas-Jogadores.csv")

copa
copa_partida
copa_jogadores


dowfile("https://storage.googleapis.com/ds-publico/cameras.baltimore.xlsx")
library(readxl)
cb <- read_excel("data/cameras.baltimore.xlsx")
cb[which.min(cb$Lat),]




View(BrFlights2)
df_fl<-load("P:/07IA/BrFlights2.RData")


BrFlights2 <- mutate(BrFlights2, 
                Partida.Atraso  = Partida.Prevista-Partida.Real,
                Chegada.Atraso = Chegada.Prevista- Chegada.Real,
                DistnciaEcu =  sqrt((LatOrig-LatDest)*(LatOrig-LatDest) 
                                    + (LongDest-LongOrig)*(LongDest-LongOrig)),
                TempoVIagem.Real = Partida.Real - Chegada.Real)



view(BrFlights2)
  
  




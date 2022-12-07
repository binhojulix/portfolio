View(BrFlights2)
df_fl<-load("P:/07IA/BrFlights2.RData")



BrFlights2<- mutate(BrFlights2,   Partida.Atraso  = Partida.Real-Partida.Real)
              %>% 
mutate(Chegada.Atraso = Chegada.Atraso- Chegada.Real)
%>% 
       mutate(DistnciaEcu =  sqrt((LatOrigem-LatDest)*(LatOrigem-LatDest) 
                                    + (LongDest-LongOrig)*(LongDest-LongOrig)))
              %>% 
              mutate(TempoVIagem.Real = Partida.Real - Chegada.Real)


starwars %>%
  filter(species == "Droid") %>%
  View()
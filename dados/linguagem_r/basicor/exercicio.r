BrFlights2 %>%
  filter(Companhia.Aerea == "AZUL") %>%
  View()


BrFlights2 %>% 
  filter(Codigo.Tipo.Linha == "Regional" | Codigo.Tipo.Linha == "Nacional" ) %>%
  arrange(desc(Chegada.Atraso)) %>% head(100) %>% View()



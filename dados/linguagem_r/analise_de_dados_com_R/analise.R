section_id
attach(aulas)
section_id
options(max.print = 40000)
head(section_id)
sort(section_id)
aulas[33137,3]<-3255
sort(aulas$section_id)
aulas[33137,3]
unique(aulas$section_id)
length(unique(aulas$section_id))
table(aulas$section_id)
sort(table(aulas$section_id))
sort(table(aulas$course_id))
install.packages("plyr")
library("plyr")
auxiliar<-count(aulas, vars="course_id")
write.csv(auxiliar, "popularidade.csv")

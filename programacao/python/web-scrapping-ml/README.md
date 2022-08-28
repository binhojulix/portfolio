# Web scraping ML


## tree

    ├── README.md
    ├── docker-compose.yml
    ├── run.bat
    ├── run.sh
    ├── scrap
    │   ├── requirements.txt
    │   ├── Dockerfile
    │   ├── setup.py
    │   ├── src
    │   │   ├── app.py
    │   │   └── conftest.py
    │   │   └── produto.py
    │   │   ├── app.py
    │   │   └── produtoBuilder.py
    │   │   └── scrap_jupyter.ipynb
    │   │   ├── scrap.py
    │   │   └── textStract.py
    │   ├── test
    │   │   ├── test_scrap.py
    │   │   └── test_textStract.py


## how to use

cloen this repository, type `cd Web-scraping-ML`.

to run on docker `docker-compose up`.

to run on windows `./run`.

to run on  linux `sh run.sh`.

##  Consigna


### Procesos, hilos y corrutinas
#### Un caso en el que usarías procesos para resolver un problema y por qué.

 `mejorar el rendimiento del software o hardware, por ejemplo:`

`guardar datos en múltiples bases de datos`


####	Un caso en el que usarías threads para resolver un problema y por qué.

 `en procesos paralelos o concordantes.`

 `ex: request an api in  main thread of android .`

 `no trabajar el thread principal . `



####    Un caso en el que usarías corrutinas para resolver un problema y por qué.

 `para mejorar el desempeño de tareas que procesan una gran cantidad de E / S` .

###     Optimización de recursos del sistema operativo

####   Si tuvieras 1.000.000 de elementos y tuvieras que consultar para cada uno de ellos información en una API HTTP. ¿Cómo lo harías? Explicar

`limitaría la cantidad de elementos solicitados a través de la paginación mediante consultas` .
 



## Next step
- _Criar uma pipeline com apache beam
- _Disponilizar Kafka 



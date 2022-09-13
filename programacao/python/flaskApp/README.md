# automatizador-service




# To run on Azure AKS
1. terraform init






# To run on kubernets

1. docker build -f Dockerfile -t automatizator:latest .




## to run without docker
requirements tools to run'

1. ./run.bat


## to run on docker-compose
1. docker-compose up


## to run sonar
1. docker run --rm -p 9000:9000 -v sonarqube_extensions:/opt/sonarqube/extensions sonarqube

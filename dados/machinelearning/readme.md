# to run
1. build image
docker build --tag=desenvolvimento:python .
2. run container
docker create -t -i --name python-dev -p 4000:4000 -v /home/usuario/workspace:/home/user desenvolvimento:python
3. activate container
docker start python-dev
#!/bin/shell

echo "-----------------------------------------"
echo "*** Web scrapping ml ***"

DIR="venv"
if [ ! -d "$DIR" ]; then
  # Take action if $DIR exists. #
  echo "criando venv ${DIR}..."
  python3 -m venv venv
fi

env="venv/bin"
folder="scrap"

${env}/pip install -r ${folder}/requirements.txt
${env}/pytest ${folder}
${env}/python ${folder}/src/app.py
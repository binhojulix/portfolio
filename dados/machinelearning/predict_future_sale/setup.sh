#!/bin/shell

echo "-----------------------------------------"
echo "*** numpy training  ***"

DIR="venv"
if [ ! -d "$DIR" ]; then
  # Take action if $DIR exists. #
  echo "criando venv ${DIR}..."
  python3 -m venv venv
fi

env="venv/bin"
folder="scrap"

pip install -r requirements.txt




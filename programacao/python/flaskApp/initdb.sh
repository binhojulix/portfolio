#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "root" --dbname "root" <<-EOSQL
	CREATE USER flask;
	CREATE DATABASE automatizador;
	GRANT ALL PRIVILEGES ON DATABASE automatizador TO flask;
EOSQL
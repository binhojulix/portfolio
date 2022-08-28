@echo off
REM: ml
echo.
echo -----------------------------------------
echo *** estoque ***

if not exist venv\ (
    echo "criando diretorio"
    python -m venv venv
) 


CALL venv\Scripts\pip install -r estoque/requirements.txt
CALL venv\Scripts\pytest estoque
CALL venv\Scripts\python estoque\src\app.py

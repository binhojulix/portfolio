@echo off
REM: ml
echo.
echo -----------------------------------------
echo *** automatizador ***

if not exist venv\ (
    echo "criando diretorio"
    python -m venv app/venv
) 


setx FLASK_ENV development /m

CALL venv\Scripts\python -m pip  install -r app/requirements.txt
CALL venv\Scripts\pytest app
CALL venv\Scripts\python app\src\run.py

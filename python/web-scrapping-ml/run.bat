@echo off
REM: ml
echo.
echo -----------------------------------------
echo *** Web scrapping ml ***

if not exist venv\ (
    echo "criando diretorio"
    python3 -m venv venv
) 


CALL venv\Scripts\pip install -r scrap/requirements.txt
CALL venv\Scripts\pytest scrap
CALL venv\Scripts\python scrap\src\app.py


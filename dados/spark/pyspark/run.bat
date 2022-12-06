@echo off
REM: ml
echo.
echo -----------------------------------------
echo *** Web scrapping ml ***

if not exist venv\ (
    echo "criando diretorio"
    python -m venv venv
) 


CALL venv\Scripts\pip install -r requirements.txt


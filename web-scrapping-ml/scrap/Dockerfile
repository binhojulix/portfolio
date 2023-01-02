FROM python:3.8-slim-buster
COPY . /scrap
WORKDIR /scrap
RUN pip install --upgrade pip
RUN pip install --no-cache-dir -r requirements.txt
ENV scrap 1

CMD ["python", "src/app.py"]


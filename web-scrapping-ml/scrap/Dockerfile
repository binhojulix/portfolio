FROM python:3.8-slim-buster
RUN mkdir -p /data 
COPY . /scrap
WORKDIR /scrap

RUN pip install --upgrade pip 
RUN pip install --no-cache-dir -r requirements.txt
ENV scrap 1
RUN mkdir -p /data
CMD ["python", "src/app.py"]


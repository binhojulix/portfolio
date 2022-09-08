FROM nginx:alpine
RUN rm /etc/nginx/conf.d/default.conf
ADD sites-enabled/app.conf /etc/nginx/conf.d/default.conf
ADD sites-enabled/index.html /etc/nginx/html/index.html
ADD sites-enabled/erro.html /etc/nginx/html/erro.html

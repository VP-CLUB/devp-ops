FROM nginx

ENV TZ=Asia/Shanghai

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY ./work/conf/nginx.conf /etc/nginx/nginx.conf

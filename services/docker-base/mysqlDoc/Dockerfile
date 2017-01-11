FROM mysql:latest

ENV TZ=Asia/Shanghai

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
#COPY mysql/my.cnf:/etc/mysql/conf.d/
RUN chown -hR root:root /var/lib/mysql

# default dir for app


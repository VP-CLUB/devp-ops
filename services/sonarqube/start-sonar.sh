#!/bin/bash
sudo docker run -d --name sonarqube \
    -p 9000:9000 -p 9092:9092 \
    -e 'SONARQUBE_JDBC_USERNAME=root' \
    -e 'SONARQUBE_JDBC_PASSWORD=@vpclubdev' \
    -e 'SONARQUBE_JDBC_URL=jdbc:mysql://172.16.45.3:3306/sonar?useUnicode=true&characterEncoding=utf8' hub.docker.vpclub.cn/vpclub_containers/sonarqube

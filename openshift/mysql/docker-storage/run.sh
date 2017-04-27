#!/bin/bash

docker run -d --restart=always --privileged=true -p 3306:3306 -v $PWD/mysqlConf:/etc/mysql/conf.d -v $PWD/data/mysql/*:/var/lib/mysql/* -e MYSQL_ROOT_PASSWORD="@vpclubdev" --name=promotion-db openshift/vpclub-mysql:5.7

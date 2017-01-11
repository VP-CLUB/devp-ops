#!/bin/bash
sudo docker build -f ./jdkDoc/Dockerfile  -t vpclub/java .
echo "build java image success"
sudo docker build -f ./mysqlDoc/Dockerfile -t vpclub/mysql .
echo "build mysql image success"
sudo docker build -f ./redisDoc/Dockerfile -t vpclub/redis .
echo "build redis image success"
sudo docker build -f ./mongodbDoc/Dockerfile -t vpclub/mongodb .
echo "build mongodb image success"
sudo docker build -f ./ionic-framework/Dockerfile -t vpclub/ionic .
echo "build ionic image success"
sudo docker build -f ./monitorDoc/Dockerfile -t vpclub/monitor .
echo "build dubbo-monitor image success"


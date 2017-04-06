#!/bin/bash
docker build -t hub.docker.vpclub.cn/vpclub/elasticsearch:1.7.5 .
echo "run success"
docker push hub.docker.vpclub.cn/vpclub/elasticsearch:1.7.5

#!/bin/bash
export JOIN_IP="$(sudo docker inspect -f '{{.NetworkSettings.IPAddress}}' node4)"
#sudo docker run -d --name node1  -h node1 progrium/consul  -server -bootstrap-expect 3


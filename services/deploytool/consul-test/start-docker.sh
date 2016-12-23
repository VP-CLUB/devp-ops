#!/bin/bash
sudo docker run -d --name node1  -h node1 progrium/consul  -server -bootstrap-expect 3
#获取node1的ip地址
export JOIN_IP="$(sudo docker inspect -f '{{.NetworkSettings.IPAddress}}' node1)" 

echo $JOIN_IP
sudo docker run -d --name node2  -h node2 progrium/consul -server -join $JOIN_IP

sudo docker run -d --name node3  -h node3 progrium/consul -server -join $JOIN_IP

sudo docker run -d -p 8400:8400 -p 8500:8500 -p 8600:53/udp --name client  -h client progrium/consul -join $JOIN_IP




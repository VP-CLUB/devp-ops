#!/bin/bash
sudo docker run -d -ti -p 5701:5701 -e 'TZ':'Asia/Shanghai'  --name hazelcast chw717/hazelcast 

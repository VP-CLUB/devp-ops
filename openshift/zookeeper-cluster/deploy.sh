#!/bin/bash
#add service
oc apply -f config/zookeeper-service.yml
oc apply -f config/zookeeper-1-service.yml
oc apply -f config/zookeeper-2-service.yml
oc apply -f config/zookeeper-3-service.yml
#add rc
oc apply -f config/zookeeper-1-rc.yml
oc apply -f config/zookeeper-2-rc.yml
oc apply -f config/zookeeper-3-rc.yml
#add monitor-rc
oc apply -f config/zookeeper-monitor-rc.yml
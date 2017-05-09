#!/bin/bash
#add service
oc apply -f kubernetes/zookeeper-service.yml
oc apply -f kubernetes/zookeeper-1-service.yml
oc apply -f kubernetes/zookeeper-2-service.yml
oc apply -f kubernetes/zookeeper-3-service.yml
#add rc
oc apply -f kubernetes/zookeeper-1-rc.yml
oc apply -f kubernetes/zookeeper-2-rc.yml
oc apply -f kubernetes/zookeeper-3-rc.yml
#add monitor-rc
oc apply -f kubernetes/zookeeper-monitor-rc.yml
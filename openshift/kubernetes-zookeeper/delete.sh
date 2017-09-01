#!/bin/bash
#add service
#oc delete -f kubernetes/zookeeper-service.yml
#oc delete -f kubernetes/zookeeper-1-service.yml
#oc delete -f kubernetes/zookeeper-2-service.yml
#oc delete -f kubernetes/zookeeper-3-service.yml
#add rc
oc delete -f kubernetes/zookeeper-1-rc.yml
oc delete -f kubernetes/zookeeper-2-rc.yml
oc delete -f kubernetes/zookeeper-3-rc.yml
#add monitor-rc
oc delete -f kubernetes/zookeeper-monitor-rc.yml
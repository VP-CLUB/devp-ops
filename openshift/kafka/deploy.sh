#!/bin/bash
oc apply -f kafka-service.yaml

oc apply -f kafka-rc.yaml

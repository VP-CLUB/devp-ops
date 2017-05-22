#!/bin/bash
oc apply -f 30service.yml

oc apply -f 50kafka.yml

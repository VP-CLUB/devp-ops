#!/bin/bash

if [ "" == "$1" ]; then
  echo "project name or names must not be null,do it like ./grant-newpro-cicd-role.sh 'promotion-dev promotion-stage'"
fi

for project in $1
do  
oc policy add-role-to-user edit system:serviceaccount:cicd:jenkins -n $project
oc policy add-role-to-user edit system:serviceaccount:cicd:default -n $project
done 

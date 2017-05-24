#!/bin/bash

if [ "" == "$1" ]; then
  echo "project name or names must not be null,do it like ./grant-project-role-batch.sh pipa-dev 'wangyunfei'"
fi
if [ "" == "$2" ]; then
  echo "user name or names must not be null,do it like ./grant-project-role-batch.sh pipa-dev 'wangyunfei'"
fi
if [ "" == "$3" ]; then
  echo "role must not be null,do it like ./grant-project-role-batch.sh pipa-dev 'wangyunfei'"
fi
for username in $2
do
oadm policy add-role-to-user $3 $username -n $1

done 
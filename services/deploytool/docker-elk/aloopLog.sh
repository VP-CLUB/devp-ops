#!/bin/bash
host="$1"
if [ "$host" == "" ]; then
	host=$(ifconfig eth0|grep 'inet addr'|awk -F'[ :]' '{print $13}') 
echo $host
fi

for i in $(find /home/vpclub/deployment/ -type f  -name "*.log")
do
 echo $i
 nc $host 5000 < $i
done  

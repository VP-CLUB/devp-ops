#!/bin/bash
sudo docker run --name redis-master -p 6379:6379 -d redis
sudo docker run --link redis-master:redis-master -v ./redis.conf:/usr/local/etc/redis/redis.conf --name redis-slave1 -d redis redis-server /usr/local/etc/redis/redis.conf
sudo docker run --link redis-master:redis-master -v ./redis.conf:/usr/local/etc/redis/redis.conf --name redis-slave2 -d redis redis-server /usr/local/etc/redis/redis.conf
sudo docker run --link redis-master:redis-master -v ./redis.conf:/usr/local/etc/redis/redis.conf --name redis-slave3 -d redis redis-server /usr/local/etc/redis/redis.conf
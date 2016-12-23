#!/bin/bash
sudo docker run -it  --name=registrator --net=host  --volume=/var/run/docker.sock:/tmp/docker.sock  gliderlabs/registrator:latest consul://localhost:8500


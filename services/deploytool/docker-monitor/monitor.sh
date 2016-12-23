#!/bin/bash
sudo docker run -d --name sensu-server  -p 3000:3000 -p 4567:4567 -p 5671:5671 -p 15672:15672 -v $PWD/check-docker.json:/etc/sensu/conf.d/check-docker.json  hiroakis/docker-sensu-server                                                        
                                                 
    
    

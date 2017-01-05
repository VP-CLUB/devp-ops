#!/bin/bash
docker exec -it hazelcast java -server -Djava.net.preferIPv4Stack=true -cp /opt/hazelcast/hazelcast-all-3.7.1.jar com.hazelcast.client.console.ClientConsoleApp #/bin/bash

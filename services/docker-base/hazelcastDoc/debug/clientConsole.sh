#!/bin/sh

java -server -Djava.net.preferIPv4Stack=true -cp /opt/hazelcast/hazelcast-all-3.7.jar com.hazelcast.client.console.ClientConsoleApp

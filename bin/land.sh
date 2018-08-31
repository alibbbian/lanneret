#!/bin/sh

cd `dirname $0`

##java -jar ../your.jar shutdown

java -classpath "../lib/lanneret.jar" com.bird.lanneret.head.Command shutdown

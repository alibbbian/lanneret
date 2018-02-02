#!/bin/sh

cd `dirname $0`

##java -jar ../weijiaoyi-1.0-SNAPSHOT.jar shutdown

java -classpath "../lib/lanneret.jar" com.bird.lanneret.head.Command shutdown

#!/bin/sh

cd `dirname $0`
echo `pwd`

#编辑启动命令
CLASS_PATH="../classes"

for file in ../lib/*
do
    if test -f $file
    then
	    CLASS_PATH=$CLASS_PATH":../lib/"`basename $file`
    fi
done

echo "classpath="$CLASS_PATH

########################################################################
####### -XX:PermSize=8m -XX:MaxPermSize=32m 持久代的配置java8已经移除 ######
########################################################################

JAVA_OPTS="-Xms64m -Xmx128m"

java $JAVA_OPTS -classpath $CLASS_PATH com.bird.lanneret.head.Command start

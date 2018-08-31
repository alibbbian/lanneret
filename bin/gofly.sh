#!/bin/sh

####================================================####
#### 命令 ./bin/gofly.sh your.jar
####================================================####


#设置日志文件
cd `dirname $0`

echo '启动路径：'`pwd`
echo '启动 开始...'

if [ ! -d "../logs" ]; then
  mkdir ../logs
fi

if [ ! -f "../logs/battleplane.log" ]; then
  touch ../logs/battleplane.log
fi

if [ "$1" = "" ]
then
  echo "未指定jar包"
else
  if [ -f "../$1" ];
  then
    #解压jar包
    if [ ! -d "../classes" ]; then
       echo '解压'$1'到classes文件夹'
       mkdir ../classes
       cd ../classes
       jar -xf ../$1
       cd ../bin
    fi
  else
    echo "../$1不存在"
  fi
fi

nohup ./fly.sh $1 >> ../logs/battleplane.log 2>&1 &

echo '启动 结束...'

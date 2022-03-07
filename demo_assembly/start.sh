#!/bin/bash

current=`date "+%Y-%m-%d %H:%M:%S"`
timeStamp=`date -d "$current" +%s`
currentTimeStamp=$((timeStamp*1000+`date "+%N"`/1000000))

publishPath="/data/app/test-jar"
appPath="/data/app"

packagename="${1}-20210830-2.2.1.jar"

if [ -z "${1}" ]; then
   echo "server is empty"
   exit 404
fi

if [ -z "${2}" ]
then
#   echo "version is empty"
#   exit 404
    echo "no chiose version.";
else 
    packagename="${1}-${2}.jar"
fi

echo "publish package ${packagename}..."

if [ ! -f "${publishPath}/${packagename}" ]; then
    echo "publish package not found!"
    exit 405
fi


mv "${appPath}/${1}/${packagename}"  "${appPath}/${1}/${packagename}${currentTimeStamp}"
cp "${publishPath}/${packagename}" "${appPath}/${1}/"
# rm -rf "${publishPath}/${packagename}"

echo "shutdown package ${publishPath}/${packagename} ..."

PID=$(ps -ef | grep "${1}-20" | grep -v grep | awk '{ print $2 }')
if [ -z "$PID" ]
then
    echo Application is already stopped
else
    echo kill -9 $PID "..."
    kill  $PID
    sleep 5
    echo "shutdown success!"
fi

# GCLOGOPS="-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/home/logs/dump/${1}/ -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps 
#	-XX:+PrintHeapAtGC -verbosegc -Xloggc:/home/logs/gclogs/gc.${1}.log"
GCLOGOPS="-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/data/logs/analyzeGc/ -XX:+PrintGCDetails -verbosegc -Xloggc:/data/logs/analyzeGc/gc.${1}.log"

echo "start package ${appPath}/${1}/${packagename}..."
sleep 1
nohup java -Xms2g -Xmx2g -Xmn1g ${GCLOGOPS} -jar $appPath/$1/$packagename  --spring.profiles.active=test > $appPath/$1/nohup.out 2>&1 &
# tail -f $appPath/$1/nohup.out


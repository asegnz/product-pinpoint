#!/bin/bash
ROOT=$PWD
PINPOINT_FOLDER="pinpoint_agent"
echo $ROOT

if [ -d "$ROOT/$PINPOINT_FOLDER" ]; then
 echo "$ROOT exists, not downloading..."
else
 echo "Downloading Pinpoint Zip File Now "

 mkdir pinpoint_agent
 cd pinpoint_agent

 wget https://github.com/naver/pinpoint/releases/download/1.8.5/pinpoint-agent-1.8.5.tar.gz
 echo "Downloaded Pinpoint Zip File"

 echo " UNZIP STARTED "
 tar -zxvf pinpoint-agent-1.8.5.tar.gz

 echo " UNZIP DONE "
 rm -r pinpoint-agent-1.8.5.tar.gz
 cd $ROOT
fi

export JAVA_OPTS="$JAVA_OPTS -javaagent:$ROOT/$PINPOINT_FOLDER/pinpoint-bootstrap-1.8.5.jar"
export JAVA_OPTS="$JAVA_OPTS -Dpinpoint.agentId=ProductAgentId"
export JAVA_OPTS="$JAVA_OPTS -Dpinpoint.applicationName=ProductApp"
echo $JAVA_OPTS

cd target
java $JAVA_OPTS -jar product-pinpoint-*.jar
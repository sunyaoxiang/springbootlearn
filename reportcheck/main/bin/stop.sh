#!/bin/bash
if ps aux | grep -v 'grep' | grep 'java' | grep 'reportcheck.jar'
then
	pid=$(ps aux | grep -v 'grep' |grep 'java'|grep 'reportcheck.jar'| awk '{print $2}');
	echo pid
	kill -9 ${pid};
fi
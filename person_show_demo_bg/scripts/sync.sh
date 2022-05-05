#!/bin/bash

# 获取脚本目录
CWD=$(cd $(dirname $0);pwd)
cd $CWD/../

# Pre-synchronization Commands
# project build
gradle clean build

host=192.168.3.41
username=dl
password=zeusight
source_dir=./build/docker/main/layers/
target_dir=/home/dl/testJAVA/person_show_demo_bg/
timeout=10

echo "start sync"
script="
set timeout $timeout
spawn rsync -avzP $source_dir $username@$host:$target_dir
expect {
\"*password*\" {send \"$password\n\"; exp_continue}
}
interact
"

expect -c "$script"
echo "sync success"

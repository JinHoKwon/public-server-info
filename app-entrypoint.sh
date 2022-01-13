#!/bin/sh
echo "run fluent-bit"
nohup /usr/local/fluent-bit/bin/fluent-bit --version 2>&1 &
echo "run java app"
java -Djava.security.egd=file:/dev/./urandom -jar /server-info-v1.0.jar



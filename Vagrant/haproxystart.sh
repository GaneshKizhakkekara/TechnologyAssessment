#!/bin/bash
echo "Inside haproxy start"

service haproxy start

sleep 2

service haproxy status

echo "Started"

exit
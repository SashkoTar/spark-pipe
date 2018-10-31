#!/bin/bash

HOST=`hostname `
CONCATENATED_LINE=""

while read LINE; do
	CONCATENATED_LINE="${CONCATENATED_LINE}${LINE} "
done

echo "Host ${HOST} received data: [ ${CONCATENATED_LINE}]"

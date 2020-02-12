#!/usr/bin/env bash
"$(dirname "$0")/build.sh"
mvn clean package deploy -P release -DskipTests
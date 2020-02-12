#!/usr/bin/env bash
mvn clean verify -DskipTests=true -P build -Dbuilder -Dtag -Dupdate.major
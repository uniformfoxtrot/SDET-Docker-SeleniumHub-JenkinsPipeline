#!/bin/bash
cd /Users/lee/Documents/DockerValidation/
docker-compose -f docker-compose.yaml up --scale chrome=5 >>output.txt
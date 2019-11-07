#!/bin/bash
docker-compose -f docker-compose.yaml up --scale chrome=5 >>output.txt
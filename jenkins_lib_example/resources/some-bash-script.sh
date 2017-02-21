#!/usr/bin/env bash

echo "Starting the script $0"

set -e

echo 'Login to AWS ECR service:'
eval $(aws ecr get-login --region us-east-1 --profile registry-write)

echo 'Build the docker image:'
docker build -t my_image .
docker tag my_image:latest my.docker.hub.example.com/my_image:latest

echo 'Push docker image to registry'
docker push my.docker.hub.example.com/my_image:latest


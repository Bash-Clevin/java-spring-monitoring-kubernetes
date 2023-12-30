## Spring + MySQL + Helm + Kubernetes

This is a simple springboot app deployed to minikube using helm

This app can also be deployed using the included docker compose file.

## Getting started

- create cluster in minikube `minikube start --driver=docker`
- run `eval $(minikube docker-env)` to enable creation of image in minikube docker environment
- build the sppring image `docker build -t spring-mysql-demo:latest .`
- run `minikube image ls` to check the image
- deploy helm chart `helm install <chartname> spring-mysql-demo-chart`
- run `kubectl get all` to see the deployed instances
- to access mysql service run `minikube service <releaseName>-mysql-service --url` in mac and `kubectl port-forward service/mychart1-mysql-service 3306:3306` in linux
- run `minikube tunnel` to expose an ip for the loadbalancer, `run kubectl get service` to check the port that has been exposed by minikube
- test the app using postman

## Cleaning up
- run `helm uninstall <helm_release_name>`
- list minikube profiles `minikube profile list`
- stop minikube profile `minikube stop --profile minikube`
- delete the profile `minikube delete --profile minikube`

## Endpoints

|type| endpoint |  path  |
|----|----------|--------|
|  POST  |add-exchange | 8080/add-exchange|
| GET |get-amount | 8080/get-amount |

**NOTE: The ports can change based on minikube**

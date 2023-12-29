# Springboot +Prometheus +Grafana

This is a simple springboot RESTAPI that demostrates usage of alerting and monitoring

![Grafana dashboard](assets/grafana-dashboard-2023-12-28-19-19-42.png)

## Getting started

Build the spring project in spring-monitoring-demo

```bash
mvn clean package
```

Edit the Dockerfile in `spring-monitoring-demo` to point to the new jar file which will be in `target` folder

Change back to `app-monitoring` and run `docker-compose up` command.

## Endpoints

- Grafana dashboard will be on `localhost:3000`
- prometheus will be on `localhost:9090`
- springboot ap will be on `localhost:8080`

supported paths by springboot ap:
| endpoint |  path  |
|----------|----|
| visit-api | 8080/visit-api|
| get-responsetime | 8080/get-responsetime |
| get-queue-size | 8080/get-queue-size |
| histogram | 8080/histogram |

## Setup Monitoring in Kubernetes 

Minikube was used for this demo

[Helm chart](https://github.com/prometheus-community/helm-charts/tree/main/charts/kube-prometheus-stack) to deploy prometheus and grafana

 - start minikube `minikube start --driver=docker`
 - get helm repo info for prometheus stack
   ```bash
   helm repo add prometheus-community https://prometheus-community.github.io/helm-charts

   helm repo update
   ```
- Install helm chart `helm install [RELEASE_NAME] prometheus-community/kube-prometheus-stack`
- check if the installed components `kubectl get all`
- expose prometheus service:
  ```bash
  kubectlget services
  kubectl port-forward service/prometheus-kube-prometheus-prometheus 9090
  ```
- get grafana password:
  
    ```bash
    kubectl get secret [RELEASE_NAME]-grafana -o jsonpath="{.data.admin-password}" | base64 --decode ; echo
    ```
- Instruct minikube to source images locally `eval $(minikube docker-env)` **This command should be ran in same terminalsession that you would be building the sprin image in.**
- Build docker image for springboot app `docker build -t spring-monitoring-demo .`
- Install your chart to minikube `helm install spring-monitoring-demo spring-monitoring-demo-chart`
- Port forward the springboot app

## Cleanup

- list minikube profiles `minikube profile list`
- stop minikube profile `minikube stop --profile minikube`
- delete the profile `minikube delete --profile minikube`

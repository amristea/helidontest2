# Helidon Example: quickstart-mp

This example implements to check whether the Mysql service is working or not using REST service using MicroProfile

## Prerequisites

1. Maven 3.5 or newer
2. Java SE 8 or newer
3. Docker 17 or newer (if you want to build and run docker images)
4. Kubernetes minikube v0.24 or newer (if you want to deploy to Kubernetes)
   or access to a Kubernetes 1.7.4 or newer cluster
5. Kubectl 1.7.4 or newer for deploying to Kubernetes
6. MySQL server

Verify prerequisites
```
java --version
mvn --version
docker --version
minikube version
kubectl version --short
mysql -V
```

## Build

```
mvn package
```

## Start the application

```
java -jar target/quickstart-mp.jar
```

## Exercise the application

```
curl -X GET http://localhost:8080/students/mysqlstatus
{"message":"true"}

```

## Build the Docker Image

```
docker build -t quickstart-mp target
```

## Start the application with Docker

```
docker run --rm -p 8080:8080 quickstart-mp:latest
```

Exercise the application as described above

## Deploy the application to Kubernetes

```
kubectl cluster-info                         # Verify which cluster
kubectl get pods                             # Verify connectivity to cluster
kubectl create -f target/app.yaml               # Deploy application
kubectl get service quickstart-mp  # Verify deployed service
```

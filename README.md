### Deployment

```
kubectl apply -f springboot-deployment.yaml
kubectl apply -f springboot-service.yaml
kubectl apply -f frontend-deployment.yaml
kubectl apply -f frontend-service.yaml
```

## Running

4. Running the Application:
Build the Spring Boot application:

bash
```./gradlew build```
Build the Docker images:

bash
```docker-compose build```
Deploy to Kubernetes:

bash
```kubectl apply -f kubernetes/```
Access the applications:

Spring Boot: http://localhost:8080
React Frontend: http://localhost:3000
Please note that these configurations are simplified, and in a production environment, you may need to enhance them based on your specific requirements. Also, ensure that your local environment supports Docker and Kubernetes for this setup.
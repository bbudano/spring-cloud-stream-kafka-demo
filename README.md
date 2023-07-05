# spring-cloud-stream-kafka-demo

### Start broker and zookeeper

```
docker compose up -d
```

### Start all services
Run following command from each modules directory
```
mvn spring-boot:run
```
Starting services will create topics on kafka brokers

### Kafka UI

Navigate to http://localhost:9080 from your browser



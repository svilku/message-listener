# message-listener
This service has two message consumers waiting for message from two different queues

## Prerequisites to run in local
1. Download Windows zip : https://activemq.apache.org/components/classic/download/
2. In 'pathToTheAbvDownload\apache-activemq-5.18.3\bin' run:
```shell script
activemq start
````

## Running the application in dev mode
Run your quarkus application in dev mode:
```shell script
mvn compile quarkus:dev
```
## Publishing your message in ActiveMq
1. Click http://localhost:8161/ -> Queues tab
2. You will be able to see the number of queues created and the connections to it
3. Click on the 'live-q' and type&send a message
4. Check your quarkus application logs


## Quarkus Doc
https://quarkus.io/guides/jms
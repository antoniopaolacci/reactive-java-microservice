
### Asynchronous communication and JSR340 spec

JSR340 specification enable asynchronous approach to fecth some data by threads.

When data are ready there is a callback to the requested thread which is going in charge to return the data. 

More http requests are possible at the same time.

 - Less CPU
 - Less Memory 
 - Less Time
 - Less Instances
 - Less Money

![image](https://github.com/antoniopaolacci/reactive-java-microservice/blob/master/img/synchronous.jpg)

![image](https://github.com/antoniopaolacci/reactive-java-microservice/blob/master/img/sync-no-blocking.jpg)

![image](https://github.com/antoniopaolacci/reactive-java-microservice/blob/master/img/asynchronous.jpg)

![image](https://github.com/antoniopaolacci/reactive-java-microservice/blob/master/img/JSR340.jpg)

### Jetty embedded reactive server

Jetty embedded on each microservice support non-blocking I/O connector. 

![image](https://github.com/antoniopaolacci/reactive-java-microservice/blob/master/img/pod.jpg)

package com.quicktutorialz.nio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mawashi.nio.jetty.ReactiveJ;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) throws Exception {
    	
    	// Spring Boot App
    	SpringApplication.run(MainApplication.class, args);
    	
    	// We will start our Jetty embedded server through our ReactiveJ library
        new ReactiveJ().port(8383)
                       .endpoints(new com.quicktutorialz.nio.endpoints.v1.ToDoEndpoints())
                       .endpoints(new com.quicktutorialz.nio.endpoints.v2.ToDoEndpoints())
                       .start();
    }
    
}//end class
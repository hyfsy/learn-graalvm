package com.hyf.graalvm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * set JAVA_HOME=C:\Program Files\Java\jdk-17.0.6
 * mvn clean compile spring-boot:process-aot
 *
 * @author baB_hyf
 * @date 2023/03/25
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

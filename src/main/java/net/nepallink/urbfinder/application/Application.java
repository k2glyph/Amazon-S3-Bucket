package net.nepallink.urbfinder.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author medineshkatwal 
 */
@EnableAutoConfiguration
@ComponentScan("net.nepallink.urbfinder")
@SpringBootApplication
@ComponentScan(basePackages={"controller"})
public class Application {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

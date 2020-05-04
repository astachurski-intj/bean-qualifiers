package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


// Explain that we can inject dependencies using interfaces!
//sometimes, Spring just can't decide WHICH implementation to INJECT where we need it.
//0 - try to start application having 2 implementations (beans) of the same interface
//1 - show effects of @Primary - mark one implementation with @Primary to get rid of error
//2 - show effects of @Qualifier - students should use "slow" implementation


@SpringBootApplication // this is ALSO @Component - look inside!
public class DemoApplication {

    @Autowired
    @Qualifier("add") //comment out this or the one below
    //@Qualifier("slow")
    private CalculationService calculationService;

    public void hello() {
        System.out.println("hello!");
        System.out.println(calculationService.calculate(3, 4));
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        DemoApplication app = ctx.getBean(DemoApplication.class);
        app.hello();
    }

}

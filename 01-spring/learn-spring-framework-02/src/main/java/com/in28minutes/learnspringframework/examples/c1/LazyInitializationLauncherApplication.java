package com.in28minutes.learnspringframework.examples.c1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}

@Component
@Lazy
class ClassB {

    private ClassA classA;

    public ClassB(ClassA classA){
        //Logic
        System.out.println("Some initialize");

        this.classA = classA;
    }

    public void doSomething(){
        System.out.println("do something");
    }
}


@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)){
            //#1. "Some initialize" 실행됨. 자동 초기화

            //#2. @Lazy 붙이면 "Some initialize" 실해오디지 않음. 즉 초기화 되지 않음.
            System.out.println("Initialization of context is complete!!");

            //#4. doSomething 을 만들고, 이를 실행하는 순간
            // Some initialize => 초기화가 됨.
            // do something
            context.getBean(ClassB.class).doSomething();

        }

    }
}
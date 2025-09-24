package com.in28minutes.learnspringframework.examples.e1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency){
        this.someDependency = someDependency;
        System.out.println("All Dependency are ready!!");
    }

    //#1. 빈이 준비되는 대로 연결하는 초기화를 설정하고 싶다
    @PostConstruct  // 다른빈이 이 빈을 사용하기 전에 무언가를 초기화 하고싶을때.
    public void initialize(){
        someDependency.getReady();
    }

    //#2. 종료되기전에 무언가를 하고싶아
    @PreDestroy // 컨테이너에서 인스턴스를 삭제하는 과정중에 있음을 알려주는 콜백
    public void cleanUp(){
        System.out.println("CleanUP!!");
    }

}

@Component
class SomeDependency {

    public void getReady(){
        System.out.println("Some logic using SomeDependency..!!");
    }

}

@Configuration
@ComponentScan
public class PrePostAnnotationLauncherApplication {
    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationLauncherApplication.class)){
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

//            All Dependency are ready!!            => 의존성 주입됨
//            Some logic using SomeDependency..!!   => 그후 바로 빈 초기화메서드 실행
            
//            org.springframework.context.annotation.internalConfigurationAnnotationProcessor
//            org.springframework.context.annotation.internalAutowiredAnnotationProcessor
//            org.springframework.context.annotation.internalCommonAnnotationProcessor
//            org.springframework.context.event.internalEventListenerProcessor
//            org.springframework.context.event.internalEventListenerFactory
            
//            prePostAnnotationLauncherApplication
//            someClass
//            someDependency
//            CleanUP!!     => 프로그램 종료시점에 빈 종료콜백
        }

    }
}
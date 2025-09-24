package com.in28minutes.learnspringframework.helloworld;

import com.in28minutes.learnspringframework.helloworld.Address;
import com.in28minutes.learnspringframework.helloworld.HelloWorldConfiguration;
import com.in28minutes.learnspringframework.helloworld.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        // 1: 스프링 컨텍스트 실행
        try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){
            // 2: 스프링이 관리할 것 지정 => @Configuration
            // HelloWorldConfiguration 클래스에 설정
            // @Bean 으로 String name 생성

            // 3: 스프링에서 관리되고있는 bean 가져옴
            System.out.println(context.getBean("name")); //빈 네임으로 가져옴
            System.out.println(context.getBean("age"));

            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2"));
            System.out.println(context.getBean("person2Parameter"));

//        System.out.println(context.getBean("address"));
            System.out.println(context.getBean("address2"));

            System.out.println(context.getBean(Person.class));
            System.out.println(context.getBean(Address.class)); //클래스. 빈 유형으로 가져옴
            // Address 유형이 두개이상이면? 에러발생. 그럼 어떻게 해야할까? => @Primary 어노테이션 사용으로 기본형 정해줌

            System.out.println(context.getBean("person4Qualifier"));


            //스프링 프레임워크가 관리하는 Bean 확인
            String[] beans = context.getBeanDefinitionNames();
            Arrays.stream(beans).forEach(bean -> {
                System.out.println(bean);
            });
//        Arrays.stream(beans).forEach(System.out::println);

        }

    }
}

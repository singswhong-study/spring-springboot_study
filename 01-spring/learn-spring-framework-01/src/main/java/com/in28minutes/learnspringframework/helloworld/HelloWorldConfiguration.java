package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// 1. POJOs : Plain Old Java Object. 특정 프레임워크, 기술, 환경에 의존하지 않고 만들어진 자바 객체
record Person (String name, int age, Address address) {};
record Address (String firstLine, String city){};

// 2. Config
@Configuration //설정파일 명시
public class HelloWorldConfiguration {
    //스프링에서 관리하는 것들 = Spring Bean

    @Bean
    public String name() {
        return "swhong";
    }

    @Bean
    public int age(){
        return 25;
    }

    @Bean
    public Person person(){
        return new Person("sw", 40,  new Address("대전시", "아무동"));
    }

    //Bean 을 재사용해서 다른 Bean으로 만들 수 있다.
    @Bean
    public Person person2(){
        return new Person(name(), age(), address());
    }

    //매개변수를 직접 설정가능하다
    @Bean
    public Person person2Parameter(String name, int age, Address address3){
        return new Person(name, age, address3);
    }

    @Bean
    @Primary    //#3. Bean이 여러개이므로 Person.class로 확인하면 에러발생 => 기본형, 즉 우선도 선언으로 이걸 쓰라고 가이드
    public Person person3Parameter(String name, int age, Address address){ //#1. address 기본형이 존재하지 않으므로 에러 발생
        return new Person(name, age, address);
    }

    //Qualifier 를 사용한 Bean
    @Bean
    public Person person4Qualifier(String name, int age,  @Qualifier("addressQualifier") Address address3){
        return new Person(name, age, address3);
    }

    //Bean 명이 기본 메소드 명. name 옵션으로 변경가능
    @Bean(name = "address2")
    @Primary    //#2. 이게 없다면, 바로 위의 인자값 address 는 없다고 하기때문에 => 기본형으로 사용한다고 정의.
    public Address address(){
        return new Address("서울특별시", "봉천동");
    }

    //Bean 명이 기본 메소드 명. name 옵션으로 변경가능
    @Bean(name = "address3")
    @Qualifier("addressQualifier")  //#4. 한정자를 추가하여 이것들 사용하게 만들수도 있다.
    public Address address3(){
        return new Address("서울특별시", "봉천동3");
    }

}

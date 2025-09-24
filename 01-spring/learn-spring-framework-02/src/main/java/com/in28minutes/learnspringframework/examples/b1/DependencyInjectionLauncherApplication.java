package com.in28minutes.learnspringframework.examples.b1;

        import org.springframework.context.annotation.AnnotationConfigApplicationContext;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.stereotype.Component;

        import java.util.Arrays;

@Component
class MyBusinessClass {

//#1. Field Injection ================================
//    @Autowired
//    Dependency1 dependency1;
//
//    @Autowired
//    Dependency2 dependency2;

    //#2. Setter Injection ================================
//    Dependency1 dependency1;
//    Dependency2 dependency2;
//
//    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        System.out.println("Setter Injection - setDependency1");
//        this.dependency1 = dependency1;
//    }
//
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        System.out.println("Setter Injection - setDependency2");
//        this.dependency2 = dependency2;
//    }

    //#3. Constructor Injection // spring팀이 추천. 하나의 메서드에서 진행되기 때문
    Dependency1 dependency1;
    Dependency2 dependency2;

//    @Autowired 의무가 아님.
    public MyBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
//        super(); //없어도 됨
        System.out.println("Constructor Injection");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public String toString(){
        return "Using " + dependency1 + " and " + dependency2;
    }
}
@Component
class Dependency1 {

}
@Component
class Dependency2 {

}

@Configuration
@ComponentScan //scan 패키지가 특정되지 않으면 선언된 해당패키지+하위패키지
public class DependencyInjectionLauncherApplication {
    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplication.class)){
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            //여기는 MyBusinessClass#toString의 return이 나옴

            System.out.println(context.getBean(MyBusinessClass.class));
            //여기는 MyBusinessClass#toString의 return이 나옴
            //@Autowired가 없다면 "Using null And null"

        }

    }
}


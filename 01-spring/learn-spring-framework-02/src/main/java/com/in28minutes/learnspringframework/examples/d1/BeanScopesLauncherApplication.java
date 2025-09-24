package com.in28minutes.learnspringframework.examples.d1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class NormalClass {

}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) // protoType, singleTon
@Component
class PrototypeClass {

}


@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {
    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)){


            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
//            com.in28minutes.learnspringframework.examples.d1.NormalClass@6025e1b6
//            com.in28minutes.learnspringframework.examples.d1.NormalClass@6025e1b6
            // #1. 호출할때마다 해시코드가 같다.

            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
//            com.in28minutes.learnspringframework.examples.d1.PrototypeClass@22ff4249
//            com.in28minutes.learnspringframework.examples.d1.PrototypeClass@2d1ef81a
//            com.in28minutes.learnspringframework.examples.d1.PrototypeClass@4c402120
            // #2. 호출할때마다 해시코드가 다르다

        }

    }
}
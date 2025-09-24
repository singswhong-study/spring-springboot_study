package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class GamingAppLauncherApplication {
//    @Bean
//    public GamingConsole game() {
//        return new PackmanGame();
//    }
// #1. PackMan에 @Component 를 설정하고, @ComponentScan으로 패키지를 지정해줬을 때 정상적으로 bean생성되어 autowried 된다.

//    @Bean
//    public GameRunner gameRunner(GamingConsole game){
//        System.out.println(game);
//        return new GameRunner(game);
//    }
// #2. gammingConsole 에도 @Component 설정하고 주석처리해도 정상 동작한다.
// => 코드의 양이 줄었다.

// #3. 현재상태에서 marioGame을 @Componet 설정하게 되면 GamingConsole 인터페이스가 구현된게 2개가 되어(mario, packman) 오류발생
// 이는 @Primary 로 우선권을 부여. 혹은 @Qualifier

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)){

            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();

        }

    }
}

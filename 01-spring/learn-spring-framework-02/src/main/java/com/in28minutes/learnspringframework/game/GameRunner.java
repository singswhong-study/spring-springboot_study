package com.in28minutes.learnspringframework.game;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    //MarioGame game;
    private GamingConsole game;

    //이대로 하면Mario 가 @Primary라서 자동주입
//    public GameRunner(GamingConsole game) {
//        this.game = game;
//    }
    //Qualifier 를 설정해주어서 SuperContra 가 주입됨.
    public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game : " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}

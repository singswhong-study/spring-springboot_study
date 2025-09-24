package com.in28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole{

    public void up() {
        System.out.println("UP");
    }

    public void down() {
        System.out.println("Sit DOWN");
    }

    public void left() {
        System.out.println("Go back");
    }
    public void right() {
        System.out.println("shoot a bullet");
    }
}

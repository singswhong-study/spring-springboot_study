package com.in28minutes.springboot.webapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("/say-hello")
    @ResponseBody   //문자열을 그대로 리턴하기 위해
    public String sayHello(){
        return "Hello! what are you today?";
    }

    @RequestMapping("/say-hello-html")
    @ResponseBody
    public String sayHelloHtml(){
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>First Web Html</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append(" My First Web Html Page With Body");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    @RequestMapping("/say-hello-jsp")
    public String sayHelloJsp(){
        return "sayhello";
    }
}

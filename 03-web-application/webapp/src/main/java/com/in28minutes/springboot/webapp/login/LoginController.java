package com.in28minutes.springboot.webapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }
    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @RequestMapping("/login")
//    public String login(@RequestParam String name, ModelMap model){
//        //ModelMap => view 에 값을 전달하고자 할때
//        logger.debug("Request Params is [{}]", name);
//
//        model.put("name", name);
//        return "login";
//    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginAction(@RequestParam String name, @RequestParam String password, ModelMap model){

        if(authenticationService.authenticate(name, password)){
            model.put("name", name);
            return "welcome";
        }

        model.put("message", "Invalid Credentials! please try again.");
        return "login";
    }

}

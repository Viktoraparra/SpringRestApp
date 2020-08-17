package com.victoraparra.springrestapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// Spring to manage this bean and create a instance of this
@Component
public class WelcomeService {

    @Value("${welcome.message}")
    private String welcomeMessage;
    public String retrieveWelcomeMessage(){
        // Complex
        return welcomeMessage;
    }
}

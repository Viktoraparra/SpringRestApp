package com.victoraparra.springrestapp.service;

import org.springframework.stereotype.Component;

// Spring to manage this bean and create a instance of this
@Component
public class WelcomeService {
    public String retrieveWelcomeMessage(){
        // Complex
        return "Good morning updated!";
    }
}

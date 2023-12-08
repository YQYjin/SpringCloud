package com.example.springcloud_provider.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testService {
    @GetMapping("/springcloud_test")
    public String springcloud_test(){
        String testResponse="this is a spring cloud test";
        return testResponse;
    }
}

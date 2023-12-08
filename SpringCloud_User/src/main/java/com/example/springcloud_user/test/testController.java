package com.example.springcloud_user.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class testController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/springcloud_test")
    public String yourServiceMethod() {
        String providerUrl = "http://SPRINGCLOUDPROVIDER/springcloud_test";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(providerUrl, String.class);
        // 处理响应
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            // 处理错误情况
            return "Error calling springcloud_test!";
        }
    }
}

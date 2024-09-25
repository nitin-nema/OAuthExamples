package com.example.OAuthExamples;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, authenticated user!";
    }
}

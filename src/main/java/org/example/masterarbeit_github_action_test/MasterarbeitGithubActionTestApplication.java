package org.example.masterarbeit_github_action_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MasterarbeitGithubActionTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasterarbeitGithubActionTestApplication.class, args);
    }


    @RequestMapping("/")
    public String home() {return "Hello World Performance test 10 cloud GitHub";}

    //change
}

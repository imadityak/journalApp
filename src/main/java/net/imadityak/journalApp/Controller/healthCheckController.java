package net.imadityak.journalApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthCheckController {

    //This string value will be converted to JSON and returned to the client
    @GetMapping("/health")
    public String healthCheck() {
        return "Journal App is up and running!";
    }
}

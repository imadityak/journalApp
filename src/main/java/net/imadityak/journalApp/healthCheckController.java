package net.imadityak.journalApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthCheckController {

    @GetMapping("/health")
    public String healthCheck() {
        return "Journal App is up and running!";
    }
}

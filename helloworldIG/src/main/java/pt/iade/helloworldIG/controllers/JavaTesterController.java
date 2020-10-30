package pt.iade.helloworldIG.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/java/tester/”") 
public class JavaTesterController {
    private Logger logger = LoggerFactory.getLogger(JavaTesterController.class); 
    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getGreeting() {
        logger.info("Saying Hello to the world");
        return "Hello World";
    }
}

package pt.iade.helloworldIG.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/java/tester/”") 
public class JavaTesterController {
    private Logger logger = LoggerFactory.getLogger(JavaTesterController.class); 
    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getAuthor() {
        logger.info("Get Information");
        String name = "André Carvalho";
        int number = 50033627;
        double height = 1.80;
        boolean isFan = true;
        String club = "Porto";

        if (isFan) {
            return "Done by " + name + " with number " + number + ".\n" + "I am " + height + " tall and I am a fan of footbal." + "\n" + "My favourite club is " + club+".";
        } else if (!isFan) {
            return "Done by " + name + " with number " + number + ".\n" + "I am " + height + " tall and not a fan of football.";
        } else{
            return "No information gathered";
        }
    }
    @GetMapping(path ="/access/{student}/{covid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean getGreeting(@PathVariable("student") boolean isStudent, @PathVariable("covid") boolean hasCovid) {
        if (isStudent && (!hasCovid)) {
            return true;
        } else {
            return false;
        }
    }
    @GetMapping(path ="/required/{student}/{temperature}/{classType}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean getRequired(@PathVariable("student") boolean isStudent, @PathVariable("temperature") double hasCovid, @PathVariable("classType") String type) {
        if (isStudent && type.equals("presential") && (hasCovid < 37.5 && hasCovid > 34.5)) {
            return true;
        } else {
            return false;
        }
    }
    @GetMapping(path = "/evacuation/{fire}/{numberOfCovids}/{powerShutdown}/{comeBackTime}",produces = MediaType.APPLICATION_JSON_VALUE) 
    public boolean getEvacuation(@PathVariable("fire") boolean isBurning, @PathVariable("numberOfCovids") int numberOfCovids,
    @PathVariable("powerShutdown") boolean isPower, @PathVariable("comeBackTime") int time) {
        if (isBurning) {
            return true;
        }
        else if(numberOfCovids > 5) {
            return true;
        }
        else if(isPower || time > 15) {
            return true;
        }
        else {
            return false;
        }
    }
    private double grades[] = { 10.5, 12, 14.5 };
    @GetMapping(path = "/average", produces= MediaType.APPLICATION_JSON_VALUE)
    public double average() {
        double total = 0; //talvez float
        for (int x = 0;  x < grades.length;x= x+x){
            total = total + grades[x];
        }           
        double average = total / grades.length;
        return average;
    }

}

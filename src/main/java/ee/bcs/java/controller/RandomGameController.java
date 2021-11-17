package ee.bcs.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.Scanner;

@RestController
public class RandomGameController {
    Random random = new Random();
    int randomNumber = random.nextInt(100);
    int count = 0;


    // http://localhost:8080/randomGame?n=40
    @GetMapping("randomGame")
    public String guess(@RequestParam("n") int insertedNumber) {
        count++;
        if (insertedNumber > randomNumber) {
            return "sisestatud number oli liiga suur";
        } else if (insertedNumber < randomNumber) {
            return "sisestatud number oli liiga väike";
        } else {
            return "Tubli, arvasid ära!. Sul läks " + count + "korda";
        }
    }
}

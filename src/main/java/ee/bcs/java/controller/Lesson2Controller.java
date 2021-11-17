package ee.bcs.java.controller;

import ee.bcs.java.tasks.Lesson2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lesson2Controller {

    // http://localhost:8080/lesson2/generateArray/5
    @GetMapping("lesson2/generateArray/{n}")
    public int[] generateArray(@PathVariable("n") int arrayLength) {
        return Lesson2.generateArray(arrayLength);
    }

    // http://localhost:8080/lesson2/decreasingArray/5
    @GetMapping("lesson2/decreasingArray/{n}")
    public int[] decreasingArray(@PathVariable("n") int n) {
        return Lesson2.decreasingArray(n);
    }

    // http://localhost:8080/lesson2/yl3/99
    @GetMapping("lesson2/yl3/{n}")
    public int[] yl3(@PathVariable("n") int n) {
        return Lesson2.yl3(n);
    }


// http://localhost:8080/lesson2/sampleArray
    @GetMapping("lesson2/sampleArray")
    public int[] sampleArray() {
        return Lesson2.sampleArray();
}
}

package ee.bcs.java.controller;

import ee.bcs.java.tasks.Lesson1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // http://localhost:8080/hello-world?name=Maria
    @GetMapping("hello-world")
    public String helloWorld(@RequestParam("name") String firstName) {
        return "Hello " + firstName;
    }

    // http://localhost:8080/lesson1/min?a=234&b=931
    @GetMapping("lesson1/min")
    public int min(@RequestParam("a") int a, @RequestParam("b") int b) {
        return Lesson1.min(a, b);
    }

    // http://localhost:8080/lesson1/max?a=234&b=931
    @GetMapping("lesson1/max")
    public int max(@RequestParam("a") int a, @RequestParam("b") int b) {
        return Lesson1.max(a, b);
    }

    // http://localhost:8080/lesson1/abs?a=99
    @GetMapping("lesson1/abs")
    public int abs(@RequestParam("a") int a) {
        return Lesson1.abs(a);
    }

    // http://localhost:8080/lesson1/isEven?a=99
    @GetMapping("lesson1/isEven")
    public boolean isEven(@RequestParam("a") int a) {
        return Lesson1.isEven(a);
    }

    // http://localhost:8080/lesson1/min?a=234&b=931&c=969
    @GetMapping("lesson1/min3")
    public int min3(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("c") int c) {
        return Lesson1.min3(a, b, c);
    }

    // http://localhost:8080/lesson1/max?a=234&b=931&c=969
    @GetMapping("lesson1/max3")
    public int max3(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("c") int c) {
        return Lesson1.max3(a, b, c);
    }

    // http://localhost:8080/lesson1/someString
    @GetMapping("lesson1/someString")
    public String someString (){
        return Lesson1.someString();
    }
}


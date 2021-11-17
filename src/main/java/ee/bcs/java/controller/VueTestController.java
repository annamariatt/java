package ee.bcs.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VueTestController {


    @PostMapping("test/register")
    public void register(@RequestBody VueTestDto request) {
        System.out.println(request.getName());
        System.out.println(request.getAadress());
        System.out.println(request.getAmet());
        System.out.println(request.getPassword());
    }

    @GetMapping("test/data")
    public VueTestDto getData() {
        VueTestDto data = new VueTestDto();
        data.setName("Iiris Dahlia");
        data.setAadress("Tallinn");
        data.setAmet("Tiim");
        data.setPassword("parool");
        return data;
    }
}
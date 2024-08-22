package Farm.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/user")
public class UserController {


    @GetMapping("Resister")
    public String Resister() {
        return "Resister";
    }



}

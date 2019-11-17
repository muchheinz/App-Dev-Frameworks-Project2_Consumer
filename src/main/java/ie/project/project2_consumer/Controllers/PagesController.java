package ie.project.project2_consumer.Controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class PagesController {

    @GetMapping(value = {"", "/", "/index", "/home"})
    public String home() {
        return "index";
    }
}

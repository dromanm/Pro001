package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by IEvgen Boldyr on 04.03.17.
 */

@Controller
public class HelloController {

    @RequestMapping(value = "/",
            method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    private String auth() {
        return "dashboard";
    }
}

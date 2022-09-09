package com.kob.backend.controller.pk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wei
 * @version 1.0
 * @Description TODO
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "pk/index.html";
    }
}

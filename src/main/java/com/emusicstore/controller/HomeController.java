package com.emusicstore.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by pchapman on 1/24/2017.
 */

@Controller
public class HomeController {

	Logger log = Logger.getLogger(HomeController.class);
	
    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login() {
    	log.debug(">>>>>>>>>>>>>>>> Logging in................................................");
    	return "login";
    }
}

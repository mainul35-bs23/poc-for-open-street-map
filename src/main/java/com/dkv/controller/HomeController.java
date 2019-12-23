package com.dkv.controller;

import com.dkv.configuration.log4j2.LoggerType;
import com.dkv.model.TripDetails;
import com.dkv.service.UserEntityService;
import com.dkv.utils.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    Logger logger = LogManager.getLogger(LoggerType.DEBUG.getValue());

    @Autowired
    private UserEntityService userEntityService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index (Model model) {
        model.addAttribute("contentTitle", "Trip Details");
        logger.debug("Debug Log");
        logger.error("Error Log");
        logger.info("Info Log");
        logger.warn("Performance Log");
        userEntityService.getUser();
        return "home";
    }

    @PostMapping(value = "/trip-details")
    public @ResponseBody Response<TripDetails> tripDetails (@RequestBody TripDetails tripDetails) {
        Response<TripDetails> response = new Response<TripDetails>(tripDetails);
        response.setCode(200);
        response.setResponseMessage("Success");
        return response;
    }

    @GetMapping(value = "/trip-details-markup")
    public String testMapping (Model model) {
        model.addAttribute("contentTitle", "Trip Details");
        return "_trip_details";
    }

}

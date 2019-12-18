package com.brainstation.controller;

import com.brainstation.model.TripDetails;
import com.brainstation.utils.response.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index (Model model) {
        model.addAttribute("contentTitle", "Trip Details");
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

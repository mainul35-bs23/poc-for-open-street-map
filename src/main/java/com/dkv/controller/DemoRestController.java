package com.dkv.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Persons.")
public class DemoRestController {

    @GetMapping("/info")
    @ApiOperation("Returns Person Info.")
    public Map<String, Object> getInfo() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Mainul Hasan");
        map.put("email", "mainul.hasan@bS-23.net");
        map.put("phone", "01634440004");
        return map;
    }

}

package com.heroku.test.heroku.controllers;

import org.apache.commons.codec.binary.Hex;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    @RequestMapping("/message")
    public String test(@RequestBody byte[] body, HttpServletRequest httpServletRequest, @RequestHeader HttpHeaders httpHeaders) {

        System.out.println(httpServletRequest.getMethod() + " " + httpServletRequest.getRequestURI());
        System.out.println(Hex.encodeHexString(body));
        System.out.println(httpHeaders);

        return "ok";
    }

}

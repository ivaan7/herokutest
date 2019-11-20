package com.heroku.test.heroku.controllers;

import com.heroku.test.heroku.model.TestRequestBody;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping("/herokutest")
    public String test(@RequestBody TestRequestBody body, @RequestHeader HttpHeaders httpHeaders) {

        System.out.println(httpHeaders);
        System.out.println(body);
        return "ok";
    }

}

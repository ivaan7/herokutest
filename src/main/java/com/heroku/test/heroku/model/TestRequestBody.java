package com.heroku.test.heroku.model;

import java.io.Serializable;

public class TestRequestBody {

    public TestRequestBody() {
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TestRequestBody{" +
                "message='" + message + '\'' +
                '}';
    }
}

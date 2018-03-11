package com.luanbin.demo.service;

public class TestService {

    private String name;

    public String say(){
        return "hello world___" + name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

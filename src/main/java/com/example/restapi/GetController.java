package com.example.restapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class GetController {

    private boolean isSlow;

    @GetMapping("/slowStore")
    @ResponseBody
    public void switchOnSlowStore(){
        isSlow = true;
    }

    @GetMapping("/tesco")
    @ResponseBody
    public Map<String, String> getTesco() throws InterruptedException {
        if(isSlow){
            TimeUnit.SECONDS.sleep(10);
            isSlow = false;
        }
        HashMap<String, String> products = new HashMap<>();
        for(int i = 0; i < 100000; i++) {
            products.put(Integer.toString(i), "25");
        }

        return products;
    }

    @GetMapping("/sainsburys")
    @ResponseBody
    public Map<String, String> getSainsburys(){
        HashMap<String, String> products = new HashMap<>();
        for(int i = 0; i < 100000; i++) {
            products.put(Integer.toString(i), "27");
        }

        return products;
    }

    @GetMapping("/morrisons")
    @ResponseBody
    public Map<String, String> getMorrisons(){
        HashMap<String, String> products = new HashMap<>();
        for(int i = 0; i < 100000; i++) {
            products.put(Integer.toString(i), "25");
        }

        return products;
    }

    @GetMapping("/aldi")
    @ResponseBody
    public Map<String, String> getAldi(){
        HashMap<String, String> products = new HashMap<>();
        for(int i = 0; i < 100000; i++) {
            products.put(Integer.toString(i), "0");
        }

        return products;
    }

    @GetMapping("/lidl")
    @ResponseBody
    public Map<String, String> getLidl(){
        HashMap<String, String> products = new HashMap<>();
        for(int i = 0; i < 100000; i++) {
            products.put(Integer.toString(i), "22");
        }

        return products;
    }

}

package com.krishan.SecurityPO0.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {

    @GetMapping("/")  // <-- blank string (same as no path)
     // security not req
    public String hello(){
        return "hello krishan🙏";
    } @GetMapping("/admin")  // <-- blank string (same as no path)
     // security req FOR  ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(){
        return "only admin can access it .....";
    }
    //security not req
    @GetMapping("/contactUs")
    public String contactUs(){
        return "india number 1 bank:9354344862 ";
    }
    @GetMapping("/transfer")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String transfer(){
        return "your transfer 10k done";
    }
    @GetMapping("/amount")
    public String amount(){
        return "15k";
    }
}

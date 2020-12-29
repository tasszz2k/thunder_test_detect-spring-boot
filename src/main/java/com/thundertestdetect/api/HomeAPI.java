package com.thundertestdetect.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeAPI {

    @GetMapping("/")
    public ResponseEntity<String> sayHello() {

        System.err.println("HELLO");
        return ResponseEntity.ok("Success");
    }
}

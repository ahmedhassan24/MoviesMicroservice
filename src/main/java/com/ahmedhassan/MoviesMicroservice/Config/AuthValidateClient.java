package com.ahmedhassan.MoviesMicroservice.Config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name ="authenticationService", url = "http://localhost:8080/api/auth")
public interface AuthValidateClient {

    @GetMapping("/validate")
    ResponseEntity<Void> auth(@RequestParam("token") String token, @RequestParam("url") String url);
}

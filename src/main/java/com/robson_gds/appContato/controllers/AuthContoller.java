package com.robson_gds.appContato.controllers;

import com.robson_gds.appContato.configuration.JwtTokenUtil;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthContoller {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Operation(summary = "Cria um token para acesso ao APP")
    @GetMapping("/token")
    public ResponseEntity<?> createToken(@RequestParam String username){
        String token = jwtTokenUtil.createToken(username);
        return ResponseEntity.ok(token);
    }
}
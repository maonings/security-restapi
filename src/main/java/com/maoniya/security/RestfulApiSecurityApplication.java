package com.maoniya.security;

import com.maoniya.security.support.ResponseModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class RestfulApiSecurityApplication {

    @GetMapping("/hello")
    @ResponseBody
    public ResponseModel<String> hello() {
        return ResponseModel.ok("Hello SpringSecurity!");
    }

	public static void main(String[] args) {
		SpringApplication.run(RestfulApiSecurityApplication.class, args);
	}
}

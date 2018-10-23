package security;

import security.support.ResponseModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author maoniya.com
 * @date 2018/10/22
 */
@SpringBootApplication
@Controller
public class RestApiSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiSecurityApplication.class, args);
    }

    @GetMapping("/hello")
    @ResponseBody
    public ResponseModel<String> hello() {
        return ResponseModel.ok("hello spring security!");
    }
}

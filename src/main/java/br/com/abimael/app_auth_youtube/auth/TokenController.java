package br.com.abimael.app_auth_youtube.auth;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/token")
public class TokenController {
    
    @PostMapping("/")
    public ResponseEntity<String> token(@RequestBody User user) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); 
        
        String requestBody = "grant_type=password&client_id=" + user.clientId + "&username=" + user.username + "&password=" + user.password;

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        RestTemplate rt = new RestTemplate();
        var result = rt.postForEntity("http://localhost:8080/realms/youtube/protocol/openid-connect/token", entity, String.class);
        return result;
    }

    public record User(String password, String clientId, String grantType, String username){}
}

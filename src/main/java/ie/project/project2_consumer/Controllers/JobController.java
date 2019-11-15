package ie.project.project2_consumer.Controllers;

import ie.project.project2_consumer.Model.Job;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class JobController {
    @GetMapping(value = "/jobs")
    public String jobs(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String bidResourceUrl = "http://localhost:8080/api/jobs";
        String email = "k@k.com";
        String password = "kevin123";
        HttpHeaders headers = createHeaders(email, password);

        ResponseEntity<List<Job>> responseEntity = restTemplate.exchange(
                bidResourceUrl,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                new ParameterizedTypeReference<List<Job>>() {}
        );

        List<Job> jobs = responseEntity.getBody();

        model.addAttribute("jobs", jobs);
        return "All-Jobs";
    }

    private HttpHeaders createHeaders(String email, String password) {
        return new HttpHeaders() {
            {
                String auth = email + ":" + password;
                byte[] encodeStringIntoBytes = auth.getBytes(StandardCharsets.UTF_8);
                byte[] encodedAuth = Base64.encodeBase64(encodeStringIntoBytes);
                String authHeader = "Basic " + new String(encodedAuth);
                set(HttpHeaders.AUTHORIZATION, authHeader);

            }};

    }
}

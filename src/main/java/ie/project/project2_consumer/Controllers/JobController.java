package ie.project.project2_consumer.Controllers;

import ie.project.project2_consumer.Model.Job;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class JobController extends BaseController {

    /**
     * GET mapping for displaying all the jobs. Gets these jobs from the REST API
     *
     * @param model The model for the view
     * @return The view
     */
    @GetMapping(value = "/jobs")
    public String jobs(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String bidResourceUrl = REST_API_ENDPOINT + "/jobs";

        ResponseEntity<List<Job>> responseEntity = restTemplate.exchange(
                bidResourceUrl,
                HttpMethod.GET,
                new HttpEntity<>(createAuthenticationHeaders()),
                new ParameterizedTypeReference<List<Job>>() {
                }
        );

        List<Job> jobs = responseEntity.getBody();

        model.addAttribute("jobs", jobs);
        return "all_jobs";
    }


}

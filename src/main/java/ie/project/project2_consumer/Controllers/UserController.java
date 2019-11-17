package ie.project.project2_consumer.Controllers;

import ie.project.project2_consumer.Model.Bid;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class UserController extends BaseController {

    /**
     * GET mapping for displaying the view with all the user bids. Gets these bids from the REST API
     *
     * @param userId The ID of the user to get the bids for
     * @param model  The model of the view
     * @return The view
     */
    @GetMapping(value = "/user/{user_id}/bids")
    public String bids(@PathVariable(name = "user_id") int userId, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String bidResourceUrl = REST_API_ENDPOINT + "/user/{userId}/bids";

        ResponseEntity<List<Bid>> responseEntity = restTemplate.exchange(
                bidResourceUrl,
                HttpMethod.GET,
                new HttpEntity<>(createAuthenticationHeaders()),
                new ParameterizedTypeReference<List<Bid>>() {
                },
                userId
        );

        List<Bid> bids = responseEntity.getBody();

        model.addAttribute("bids", bids);
        return "user_bids";
    }

}

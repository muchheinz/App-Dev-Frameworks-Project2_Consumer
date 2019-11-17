package ie.project.project2_consumer.Controllers;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;

import java.nio.charset.StandardCharsets;

/**
 * Base class for the controllers, gives the ability to easily add authentication headers for every request that needs it.
 */
public class BaseController {

    private static final String EMAIL = "account1@gmail.com";
    private static final String PASSWORD = "password";
    protected final String REST_API_ENDPOINT = "http://localhost:8080/api";

    /**
     * Creates an basic-authorization header with the specified Email and Password.
     *
     * @return The headers.
     */
    protected static HttpHeaders createAuthenticationHeaders() {
        return new HttpHeaders() {
            {
                String auth = EMAIL + ":" + PASSWORD;
                byte[] encodeStringIntoBytes = auth.getBytes(StandardCharsets.UTF_8);
                byte[] encodedAuth = Base64.encodeBase64(encodeStringIntoBytes);
                String authHeader = "Basic " + new String(encodedAuth);
                set(HttpHeaders.AUTHORIZATION, authHeader);

            }
        };

    }
}

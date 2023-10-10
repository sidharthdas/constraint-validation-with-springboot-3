package in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ADemo {

    private final RestTemplate restTemplate;
    public ADemo(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void testADemo() {
        System.out.println("in testADemo method");
    }
}

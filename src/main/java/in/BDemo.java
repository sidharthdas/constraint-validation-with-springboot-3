package in;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BDemo {

    private final RestTemplate restTemplate;
    public BDemo(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void testBDemo() {
        System.out.println("in testBDemo method");
    }
}


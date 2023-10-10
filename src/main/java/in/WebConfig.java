package in;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@AutoConfiguration
public class WebConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();

    }

    @Bean
    public ADemo aDemo(RestTemplate restTemplate) {
        return new ADemo(restTemplate);

    }

    @Bean
    public BDemo bDemo(RestTemplate restTemplate) {
        return new BDemo(restTemplate);

    }
}

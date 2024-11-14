package sarc.cloud.chronomesh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for application-wide beans.
 * This class provides beans for common components used throughout the
 * application.
 *
 * @author marco.mangan@gmail.com
 */
@Configuration
public class AppConfig {

    /**
     * Creates and configures a {@link RestTemplate} bean.
     * This bean can be injected and used across the application for making HTTP
     * requests to external services.
     *
     * @return a configured {@link RestTemplate} instance
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

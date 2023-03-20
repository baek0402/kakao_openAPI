package openAPI.TmiBoard.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigure implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000", "https://tmiboard.swygbro.com")
                .allowedMethods("GET", "POST", "DELETE", "PATCH", "OPTIONS", "PUT")
                .allowedHeaders("Content-Type", "Authorization", "X-Requested-With", "Origin", "Accept", "x-access-token")
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Methods", "Access-Control-Allow-Headers")
                .allowCredentials(true)
                .maxAge(3600);
    }

}

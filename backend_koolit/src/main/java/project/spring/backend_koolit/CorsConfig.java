package project.spring.backend_koolit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");  // Autoriser toutes les origines, à ajuster en fonction de vos besoins de sécurité
        config.addAllowedMethod("*");  // Autoriser toutes les méthodes
        config.addAllowedHeader("*");  // Autoriser tous les en-têtes
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}

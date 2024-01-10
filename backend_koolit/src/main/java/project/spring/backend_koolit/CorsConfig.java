package project.spring.backend_koolit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

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
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // Remplacez par le domaine d'origine de votre application Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}

package PrubaXolitTecnica.PrubaXolitTecnica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Se puede agregar más rutas si es necesario
        registry.addMapping("/api/**")  // Configura CORS para todas las rutas de la API
                .allowedOrigins("http://localhost:4200")  // Permite solicitudes solo desde localhost:8080
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Métodos permitidos
                .allowedHeaders("*")  // Permitir todas las cabeceras
                .allowCredentials(true);  // Permitir credenciales si es necesario
    }
}

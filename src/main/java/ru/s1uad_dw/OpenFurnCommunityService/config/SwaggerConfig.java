package ru.s1uad_dw.OpenFurnCommunityService.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("open-furn-community-service")
                                .version("v 1.0")
                                .contact(
                                        new Contact()
                                                .email("s1uad.dw@gmail.com")
                                                .url("https://t.me/s1uad_dw")
                                )
                );
    }
}

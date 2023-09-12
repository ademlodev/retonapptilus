package com.ademlo.retonapptilus.core.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${application-description}")
                                 String appDesciption,
                                 @Value("${application-version}")
                                 String appVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title("Reto Napptilus")
                        .version(appVersion)
                        .description(appDesciption)
                        .contact(new Contact()
                                .name("Ademlo")
                                .email("javier.garcia.olmeda@gmail.com")
                                .url("https://www.ademlo.com/")
                        )
                );
    }
}

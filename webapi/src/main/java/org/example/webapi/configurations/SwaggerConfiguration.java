package org.example.webapi.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI openAPI() {
        License license = new License();
        license.setName("License Apache 2.0");
        license.setUrl("https://www.apache.org/licenses/LICENSE-2.0.html");

        Info info = new Info()
                .title("WEB API")
                .version("1.0")
                .description("This API exposes all the endpoints for our application.")
                .termsOfService("")
                .license(license);

        return new OpenAPI().info(info);
    }
}

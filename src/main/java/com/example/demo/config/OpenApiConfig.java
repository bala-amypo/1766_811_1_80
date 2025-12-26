@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(List.of(
                        new Server().url("http://localhost:8080"), // local dev
                        new Server().url("https://9340.pro604cr.amypo.ai/") // production
                ))
                .components(new Components()
                        .addSecuritySchemes("BearerAuth", 
                            new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                        )
                )
                .addSecurityItem(new SecurityRequirement().addList("BearerAuth"))
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Demo JWT API")
                        .version("1.0")
                        .description("Spring Boot 3 + JWT Authentication API"));
    }
}

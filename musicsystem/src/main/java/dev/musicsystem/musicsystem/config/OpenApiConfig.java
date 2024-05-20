package dev.musicsystem.musicsystem.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Music System",
                        email = "mreviewscontact@gmail.com",
                        url = "https://karpiuk.dev/"
                ),
                description = "OpenApi Documentation for Music System",
                title = "Music System API Specification",
                version = "1.0.0",
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local server",
                        url = "http://localhost:8080/api/v1"
                ),
                @Server(
                        description = "Production server",
                        url = "https://musicreviews.karpiuk.dev/api/v1"
                )

        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT Auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}

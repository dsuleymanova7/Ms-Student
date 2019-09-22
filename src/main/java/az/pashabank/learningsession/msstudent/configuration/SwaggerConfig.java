package az.pashabank.learningsession.msstudent.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/student/**"))
                .build().apiInfo(customApiInfo());
    }

    private ApiInfo customApiInfo() {
        return new ApiInfo("Student Service API",
                "Pasha Bank Learning Session  Microservice Task"
                , "1.0",
                "https://www.pashabank.az",
                new Contact("Durna Suleymanova", "https://www.pashabank.az", "durna.suleymanova@pashabank.az"),
                "API Lisence",
                "https://www.pashabank.az",
                Collections.emptyList());
    }

}

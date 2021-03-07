package midianet.carros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class Swagger {

    @Bean
    public Docket detalheApi() {
        var docket = new Docket(DocumentationType.SWAGGER_2);
        docket.select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(this.informacoesApi().build());
        return docket;
    }

    private ApiInfoBuilder informacoesApi() {
        var apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("Carros API");
        apiInfoBuilder.description("Api de Carros.");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: .");
        apiInfoBuilder.license("Licença - ");
        apiInfoBuilder.licenseUrl("http://www.carros.com.brr");
        apiInfoBuilder.contact(this.contato());
        return apiInfoBuilder;
    }

    private Contact contato() {
        return new Contact(
                "Informática",
                "http://www.carros.com.br",
                "informatica@carros.com.br");
    }

}

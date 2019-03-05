package me.seungwoo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2
public class SwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            userRepository.save(new User("seungwoo", "test0000", "test@test.com"));
            List<User> userList = userRepository.findAll();
            System.out.println(userList);
        };

    }

    @Bean
    public Docket newsApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("spring-swagger")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/*.*"))
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("spring with Swagger")
                .description("spring-swagger")
                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open") //
                .contact("spring-swagger")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Cloud/news-aggregator/blob/master/LICENSE")
                .version("1.0")
                .build();

    }
}

package ir.reza.studyplanner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ir.reza.studyplanner")
public class AppConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {

        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();

        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        return resolver;
    }
}
/*
Explanation of Annotations

1. @Configuration
Tells Spring that this class contains application settings.

2. @EnableWebMvc
Enables Spring MVC features; such as:
- Handling HTTP requests
- Mapping requests to Controller
- Model support
- View management

3. @ComponentScan(basePackages = "ir.reza.studyplanner")
Makes Spring search the main package and its subpackages to find Beans.

As a result, these classes are identified:
- @Controller
- @RestController
- @Service
- @Repository

4. @Bean and ViewResolver
This part specifies what path Spring should use to find JSPs.

For example, if the Controller writes:
return "session-list";

Spring will find the following path:
/WEB-INF/views/session-list.jsp
*/
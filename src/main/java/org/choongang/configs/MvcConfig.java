package org.choongang.configs;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableJpaAuditing
public class MvcConfig implements WebMvcConfigurer {

    HiddenHttpMethodFilter httpMethodFilter(){
        return new HiddenHttpMethodFilter();
    }

}

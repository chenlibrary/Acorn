package com.www.acorn.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig  implements WebMvcConfigurer {

//    @Autowired
//   private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      //  registry.addInterceptor(tokenInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
    }
}

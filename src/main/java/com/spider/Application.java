package com.spider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.MultipartConfigElement;
import java.util.concurrent.TimeUnit;

@Configuration
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    /**
     * 文件上传配置
     *
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        factory.setMaxFileSize("10240KB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("102400KB");
//        factory.setLocation("./src/main/resources/upload/");
        return factory.createMultipartConfig();
    }


    //    // 缓存一小时 - "Cache-Control: max-age=3600"
//    CacheControl ccCacheOneHour = CacheControl.maxAge(1, TimeUnit.HOURS);
//
//    // 禁止缓存 - "Cache-Control: no-store"
//    CacheControl ccNoStore = CacheControl.noStore();
//
//    // 缓存十天，对所有公共缓存和私有缓存生效
//    // 响应不能被公共缓存改变
//    // "Cache-Control: max-age=864000, public, no-transform"
//    CacheControl ccCustom = CacheControl.maxAge(10, TimeUnit.DAYS)
//            .noTransform().cachePublic();
    @Configuration
    @EnableWebMvc
    public class WebConfig extends WebMvcConfigurerAdapter {

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry
                    .addResourceHandler("/templates/**")
                    .addResourceLocations("classpath:/templates/")
                    .setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());
        }

        //        <mvc:view-controller path="/" view-name="home"/>
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/").setViewName("upload");
//            registry.addViewController("/").setViewName("upload");
        }

//        <mvc:view-resolvers>
//        <mvc:content-negotiation>
//        <mvc:default-views>
//        <service class="org.springframework.web.servlet.view.json.MappingJackson2JsonView"/>
//        </mvc:default-views>
//        </mvc:content-negotiation>
//        <mvc:jsp/>
//        </mvc:view-resolvers>
//        @Override
//        public void configureViewResolvers(ViewResolverRegistry registry) {
//            registry.enableContentNegotiation(new MappingJackson2JsonView());
//            registry.jsp();
//        }


//        @Override
//        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//            configurer.enable("myCustomDefaultServlet");
//        }

        @Override
        public void configurePathMatch(PathMatchConfigurer configurer) {
            configurer
                    .setUseSuffixPatternMatch(true)
                    .setUseTrailingSlashMatch(false)
                    .setUseRegisteredSuffixPatternMatch(true)
//                    .setPathMatcher(antPathMatcher())
//                    .setUrlPathHelper(urlPathHelper())
            ;
        }

//        @Bean
//        public UrlPathHelper urlPathHelper() {
//            //...
//        }
//
//        @Bean
//        public PathMatcher antPathMatcher() {
//            //...
//        }

    }

}
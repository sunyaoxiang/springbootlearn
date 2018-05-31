package com.spider.security.conf;

import com.spider.security.dao.UserAddRoleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by yaoxiang.sun on 2018/5/30.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 在运行页面方法前执行校验
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private AuthenticationProvider provider;
//    @Autowired
//    private UserDetailsService userDetailsService;

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserAddRoleService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(new MyPasswordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
//                .anyRequest().authenticated().
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.authenticationProvider(provider);
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("123456").roles("USER");
//    }
}

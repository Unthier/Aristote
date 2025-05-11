package be.ifapme.sab.config.security;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.SessionCookieConfig;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

//        http.requiresChannel(h -> h.anyRequest().requiresSecure())
//
//                .authorizeHttpRequests((requests) -> requests
//                .anyRequest().authenticated()
//                .requestMatchers("/home").permitAll()
//                .requestMatchers("/api/**").hasAnyRole("USER", "ADMIN")
//                .requestMatchers("/admin/**").hasRole("ADMIN")
//        );
//
//        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
//                .authorizeHttpRequests((authorize)-> authorize.anyRequest().authenticated())
//                .authorizeHttpRequests((authorize)->{
//                    authorize.requestMatchers("/article**").hasAnyRole();
//                    authorize.requestMatchers(("/backet")).hasAuthority("READ_PRIVILEGE");
//                })
//                .cors(cors-> cors.disable())
//                .csrf(csrf-> csrf.disable())
//                .httpBasic(httpBasic-> httpBasic.disable());
//         return http.build();

        return http
        .authorizeHttpRequests(auth -> {
            auth.requestMatchers("/").permitAll();
            auth.anyRequest().authenticated();
        })
        .oauth2Login(oauth2 -> oauth2
                .defaultSuccessUrl("/secure", true)
        )
        .formLogin(form -> form
                .defaultSuccessUrl("/secure", true)
        )
        .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> {
            SessionCookieConfig sessionCookieConfig = servletContext.getSessionCookieConfig();
            sessionCookieConfig.setHttpOnly(true);
            sessionCookieConfig.setSecure(true);
            sessionCookieConfig.setName("JSESSIONID");
            sessionCookieConfig.setPath("/");
        };
    }

    @Bean
    public FilterRegistrationBean<SameSiteCookieFilter> sameSiteCookieFilter() {
        FilterRegistrationBean<SameSiteCookieFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new SameSiteCookieFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}

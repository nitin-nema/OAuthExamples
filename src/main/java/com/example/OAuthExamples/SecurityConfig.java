package com.example.OAuthExamples;

@Configuration

//spring secuirty default configuation os replaced
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() //specify qhich request should be authorized
                .anyRequest().authenticated() //  Not--Error code -401-login page
                .and()
                .oauth2Login(); // enable the OAuth2 login
    }
}

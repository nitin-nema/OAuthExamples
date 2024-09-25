package com.example.OAuthExamples;

@Configuration
@EnableZuulProxy
public class GatewaySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();  // Authenticate users before routing to microservices
    }
}

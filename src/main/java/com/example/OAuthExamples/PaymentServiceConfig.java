package com.example.OAuthExamples;

@Configuration
@EnableResourceServer
public class PaymentServiceConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/payments/**").hasAuthority("SCOPE_payment")
                .anyRequest().authenticated();
    }
}

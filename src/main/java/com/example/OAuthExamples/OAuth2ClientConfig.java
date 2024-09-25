package com.example.OAuthExamples;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

// enable the Spring OAtuh infrastructe
@EnableOAuth2Client
public class OAuth2ClientConfig {

    @Bean
    public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext oauth2ClientContext) {
        return new OAuth2RestTemplate(oauth2Client(), oauth2ClientContext);
    }

    @Bean
    public OAuth2ProtectedResourceDetails oauth2Client() {
        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setAccessTokenUri("https://example.com/oauth/token");
        details.setUserAuthorizationUri("https://example.com/oauth/authorize");
        details.setClientId("client-id");
        details.setClientSecret("client-secret");
        return details;
    }
}

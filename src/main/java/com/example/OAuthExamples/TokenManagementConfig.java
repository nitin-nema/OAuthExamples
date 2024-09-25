package com.example.OAuthExamples;

@Configuration
public class TokenManagementConfig {

    @Bean
    public OAuth2AccessToken customizeToken(OAuth2AccessToken token) {
        ((DefaultOAuth2AccessToken) token).setExpiration(new Date(System.currentTimeMillis() + 3600000)); // 1 hour
        return token;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }
}

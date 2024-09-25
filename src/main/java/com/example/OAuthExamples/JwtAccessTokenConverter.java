package com.example.OAuthExamples;

@Configuration
public class JwtConfig {

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("jwt-signing-key");  // Secret key for signing JWTs
        return converter;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());  // Store tokens as JWTs
    }
}

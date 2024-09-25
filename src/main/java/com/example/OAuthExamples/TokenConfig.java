package com.example.OAuthExamples;

@Configuration
public class TokenConfig {

    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new CustomTokenEnhancer();  // Custom enhancements to the token
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());  // Use JWT to store tokens
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("my-secret-key");  // Signing key for JWT
        return converter;
    }

    @Bean
    public DefaultTokenServices tokenServices(TokenStore tokenStore, ClientDetailsService clientDetailsService) {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore);
        tokenServices.setSupportRefreshToken(true);  // Enable refresh tokens
        tokenServices.setAccessTokenValiditySeconds(60 * 15);  // Access token expires after 15 minutes
        tokenServices.setRefreshTokenValiditySeconds(60 * 60 * 24);  // Refresh token expires after 24 hours
        return tokenServices;
    }
}

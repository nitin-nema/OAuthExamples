package com.example.OAuthExamples;

@Component
public class CustomTokenEnhancer extends JwtAccessTokenConverter {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        OAuth2AccessToken enhancedToken = super.enhance(accessToken, authentication);
        Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("organization", "my-org");  // Custom claim
        ((DefaultOAuth2AccessToken) enhancedToken).setAdditionalInformation(additionalInfo);
        return enhancedToken;
    }
}

package com.example.OAuthExamples;

@RestController
public class TokenRevocationEndpoint {

    @Autowired
    private TokenStore tokenStore;

    @PostMapping("/revoke-token")
    public ResponseEntity<?> revokeToken(@RequestParam String token) {
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token);
        if (oAuth2AccessToken != null) {
            tokenStore.removeAccessToken(oAuth2AccessToken);
            return ResponseEntity.ok("Token revoked successfully");
        }
        return ResponseEntity.badRequest().body("Invalid token");
    }
}

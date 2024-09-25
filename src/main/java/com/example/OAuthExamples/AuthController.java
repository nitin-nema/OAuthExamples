package com.example.OAuthExamples;

@RestController
public class AuthController {

    @Autowired
    private DefaultTokenServices tokenServices;

    @PostMapping("/refresh-token")
    public ResponseEntity<OAuth2AccessToken> refreshToken(@RequestBody String refreshToken) {
        OAuth2AccessToken newAccessToken = tokenServices.refreshAccessToken(refreshToken, null);
        return ResponseEntity.ok(newAccessToken);
    }
}

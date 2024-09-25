package com.example.OAuthExamples;

@RestController
public class TokenController {

    @Autowired
    private DefaultTokenServices tokenServices;

    @PostMapping("/oauth/token")
    public ResponseEntity<OAuth2AccessToken> getAccessToken(@RequestParam("grant_type") String grantType,
                                                            @RequestParam("refresh_token") String refreshToken) {
        if ("refresh_token".equals(grantType)) {
            OAuth2AccessToken newToken = tokenServices.refreshAccessToken(refreshToken, null);
            return ResponseEntity.ok(newToken);
        }
        return ResponseEntity.badRequest().build();
    }
}

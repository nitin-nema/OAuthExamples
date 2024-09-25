package com.example.OAuthExamples;


//Spring configuration class--
@Configuration
//Enable the applciation to act as OAuth2
@EnableAuthorizationServer

public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    //managing authnetication
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                //client.jdbc(dataSource)
                .withClient("client-id")
                .secret("{noop}client-secret")
                .authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes("read", "write");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }
}

//JdbcClientDetailService for production instead of inMemory

//.secret("{bcrypt}$2a$10lgjgkgERttggjgjh")
//pbkdf2
//scrypt
//sha256

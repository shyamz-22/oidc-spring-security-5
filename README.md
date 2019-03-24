# oidc-spring-security-5
A demo application show casing usage of OpenID Connect with Spring security without need of external libraries

# Default redirect uri by spring security is 
http://localhost:8080/login/oauth2/code/<<spring.security.oauth2.client.registration.provider>>

If you have set `spring.security.oauth2.client.registration.provider` this value to `google` then
your redirect url should be `http://localhost:8080/login/oauth2/code/google`

See: `OAuth2LoginAuthenticationFilter`

# Handling unauthenticated request:

When you request an endpoint unauthenticated, then spring security 
redirects to `http://localhost:8080/oauth2/authorization/<<spring.security.oauth2.client.registration.provider>>`

If you have set `spring.security.oauth2.client.registration.provider` this value to `google`, then
the Identity provider config is fetched using a redirect to `http://localhost:8080/oauth2/authorization/google`,
which then form the `/authorize request` according to the configuration and redirects

See: `OAuth2AuthorizationRequestRedirectFilter`

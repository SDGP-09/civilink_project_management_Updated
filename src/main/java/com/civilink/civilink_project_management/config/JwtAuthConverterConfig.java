package com.civilink.civilink_project_management.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class JwtAuthConverterConfig {


    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter defaultConverter = new JwtGrantedAuthoritiesConverter();
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();

        converter.setJwtGrantedAuthoritiesConverter(jwt -> {
            Collection<GrantedAuthority> authorities = defaultConverter.convert(jwt);

            List<String> groups = jwt.getClaimAsStringList("groups");

            if (groups != null) {
                List<GrantedAuthority> groupAuthorities = groups.stream()
                        .map(group -> (GrantedAuthority) () -> "ROLE_" + group.toUpperCase()).collect(Collectors.toList());
                authorities.addAll(groupAuthorities);
            }
            return authorities;
        });
        return converter;

    }
}

package py.com.hercules.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import py.com.hercules.common.constants.ProtectedModule;
import py.com.hercules.seguridad.constantes.Role;


/**
 * Created by mcespedes
 */
@Configuration
@EnableResourceServer

public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "resources";

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/management/**").hasRole(Role.ADMIN.getSecurityName())
                // Organizations related resources
                .antMatchers(HttpMethod.GET, ProtectedModule.ORGANIZATIONS.getUrls()).authenticated()
                .antMatchers(ProtectedModule.ORGANIZATIONS.getUrls()).hasAnyRole(ProtectedModule.ORGANIZATIONS.getWriteRoles())
                // Surveys related resources
                .antMatchers(HttpMethod.GET, ProtectedModule.SURVEYS.getUrls()).authenticated()
                .antMatchers(ProtectedModule.SURVEYS.getUrls()).hasAnyRole(ProtectedModule.SURVEYS.getWriteRoles());
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID);
    }

}
package net.lemniscate.snippy.config.security;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class AuditingConfig {

    @Bean
    public AuditorAware<Integer> createAuditorProvider() {
        return new SecurityAuditor();
    }

    @Bean
    public AuditingEntityListener createAuditingListener() {
        return new AuditingEntityListener();
    }

    public class SecurityAuditor implements AuditorAware<Integer> {

        @Override
        public Optional<Integer> getCurrentAuditor() {
            Integer id = -1;
            try {
                SecurityContext securityContext = SecurityContextHolder.getContext();
                if (securityContext.getAuthentication() instanceof UsernamePasswordAuthenticationToken) {
                    UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) securityContext.getAuthentication();
                    if (authentication.getPrincipal() instanceof UserDetailsImpl) {
                        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
                        id = user.getId();
                    }
                }
            } catch (BeanCreationException beanCreationException) {
                id = -1;
            }
            return Optional.of(id);
        }
    }
}

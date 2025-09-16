package com.prashant.school.schoolapp.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAware")
public class AuditAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor(){
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());
    }

}

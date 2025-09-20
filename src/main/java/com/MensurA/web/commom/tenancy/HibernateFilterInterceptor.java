package com.MensurA.web.commom.tenancy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class HibernateFilterInterceptor extends OncePerRequestFilter {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            Session session = entityManager.unwrap(Session.class);
            String valor = TenantContext.getCurrentTenant();

            if (request.getRequestURI().startsWith("/auth")) {
                filterChain.doFilter(request, response);
                return;
            }

            if (valor != null) {
                session.enableFilter("tenantFilter").setParameter("tenantId", valor);
            }

            filterChain.doFilter(request, response);
        } finally {
            TenantContext.clear();
        }
    }
}
package com.MensurA.web.commom.tenancy;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;

@Aspect
@Configuration
@RequiredArgsConstructor
public class TenantAspect {

    private final EntityManager entityManager;

    @Before("execution(* com.MensurA.web.features.*.*.*.*(..))")
    public void setFiltroTenant() {
        String tenant = TenantContext.getCurrentTenant();

        Session sessao = entityManager.unwrap(Session.class);
        sessao.enableFilter("tenantFilter").setParameter("tenant", tenant);
    }

    @Before("execution(* com.MensurA.web.features.*.*.*.save*(..))")
    public void setTenantOnCreate(JoinPoint joinPoint) throws IllegalAccessException {
        String tenant = TenantContext.getCurrentTenant();
        for (Object arg : joinPoint.getArgs()) {
            Field[] fields = arg.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(TenantField.class)) {
                    field.setAccessible(true);
                    field.set(arg, tenant);
                }
            }
        }
    }
}
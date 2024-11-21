package sabc.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @PostConstruct
    public void logDdlAuto() {
        System.out.println("################ spring.jpa.hibernate.ddl-auto: " + ddlAuto);
    }
}
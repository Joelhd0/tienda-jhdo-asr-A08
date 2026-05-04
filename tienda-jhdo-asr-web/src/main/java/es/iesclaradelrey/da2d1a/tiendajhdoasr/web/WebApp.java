package es.iesclaradelrey.da2d1a.tiendajhdoasr.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Clase principal de la aplicación web de la tienda.
 *
 * @EntityScan le dice a Hibernate dónde buscar las entidades JPA (@Entity).
 * @EnableJpaRepositories le dice a Spring Data dónde buscar los repositorios.
 * Ambas son necesarias porque las entidades y repositorios están en el módulo
 * 'common', que es un JAR separado del módulo 'web' donde arranca Spring Boot.
 */
@SpringBootApplication(
        scanBasePackages = {
                "es.iesclaradelrey.da2d1a.tiendajhdoasr.common",
                "es.iesclaradelrey.da2d1a.tiendajhdoasr.web"
        }
)
@EntityScan(basePackages = "es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities")
@EnableJpaRepositories(basePackages = "es.iesclaradelrey.da2d1a.tiendajhdoasr.common.repositories")
public class WebApp {

    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }
}

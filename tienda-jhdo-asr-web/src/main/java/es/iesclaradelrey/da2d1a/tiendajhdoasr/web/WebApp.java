package es.iesclaradelrey.da2d1a.tiendajhdoasr.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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

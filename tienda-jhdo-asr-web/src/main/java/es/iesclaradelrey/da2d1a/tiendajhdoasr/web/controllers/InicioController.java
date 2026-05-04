package es.iesclaradelrey.da2d1a.tiendajhdoasr.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping({"", "/"})
    public String inicio() {
        return "index";
    }

    /** Página de condiciones de uso */
    @GetMapping("/terms")
    public String terms() {
        return "terms";
    }

    /** Página sobre nosotros */
    @GetMapping("/sobre-nosotros")
    public String sobreNosotros() {
        return "sobre-nosotros";
    }
}

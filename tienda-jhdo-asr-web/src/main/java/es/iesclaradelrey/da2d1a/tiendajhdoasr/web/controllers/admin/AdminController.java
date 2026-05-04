package es.iesclaradelrey.da2d1a.tiendajhdoasr.web.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** Página de inicio del área de administración (actividad 8). */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/")
    public String redirigir() { return "redirect:/admin"; }

    @GetMapping
    public String inicio() { return "admin/index"; }
}

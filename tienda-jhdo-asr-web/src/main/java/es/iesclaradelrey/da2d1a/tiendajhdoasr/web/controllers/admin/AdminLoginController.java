package es.iesclaradelrey.da2d1a.tiendajhdoasr.web.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/login")
public class AdminLoginController {

    @GetMapping
    public String loginPage(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("errorMsg", "Usuario o contraseña incorrectos.");
        }
        return "admin/login";
    }
}

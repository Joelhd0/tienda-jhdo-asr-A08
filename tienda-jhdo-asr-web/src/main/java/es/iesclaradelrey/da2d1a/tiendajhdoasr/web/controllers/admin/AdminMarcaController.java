package es.iesclaradelrey.da2d1a.tiendajhdoasr.web.controllers.admin;

import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.services.MarcaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller("adminMarcaController")
@RequestMapping("/admin/marcas")
public class AdminMarcaController {

    private final MarcaService marcaService;
    public AdminMarcaController(MarcaService marcaService) { this.marcaService = marcaService; }

    @GetMapping("/") public String redir() { return "redirect:/admin/marcas"; }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("marcas", marcaService.findAll());
        return "admin/marcas/list";
    }

    @GetMapping("/new")
    public String nuevaForm(Model model) {
        model.addAttribute("marca", new Marca());
        return "admin/marcas/form";
    }

    @PostMapping("/new")
    public String nuevaGuardar(@ModelAttribute Marca marca, Model model) {
        try { marcaService.save(marca); return "redirect:/admin/marcas"; }
        catch (Exception e) { model.addAttribute("error", e.getMessage()); model.addAttribute("marca", marca); return "admin/marcas/form"; }
    }

    @GetMapping("/{id}/edit")
    public String editarForm(@PathVariable Long id, Model model) {
        Optional<Marca> m = marcaService.findById(id);
        if (m.isEmpty()) return "redirect:/admin/marcas";
        model.addAttribute("marca", m.get()); return "admin/marcas/form";
    }

    @PostMapping("/{id}/edit")
    public String editarGuardar(@PathVariable Long id, @ModelAttribute Marca marca, Model model) {
        marca.setId(id);
        try { marcaService.save(marca); return "redirect:/admin/marcas"; }
        catch (Exception e) { model.addAttribute("error", e.getMessage()); model.addAttribute("marca", marca); return "admin/marcas/form"; }
    }

    @GetMapping("/{id}/delete")
    public String borrarForm(@PathVariable Long id, Model model) {
        Optional<Marca> m = marcaService.findById(id);
        if (m.isEmpty()) return "redirect:/admin/marcas";
        model.addAttribute("marca", m.get()); return "admin/marcas/delete";
    }

    @PostMapping("/{id}/delete")
    public String borrarConfirmar(@PathVariable Long id, Model model) {
        try { marcaService.deleteById(id); return "redirect:/admin/marcas"; }
        catch (Exception e) {
            marcaService.findById(id).ifPresent(m -> model.addAttribute("marca", m));
            model.addAttribute("error", e.getMessage()); return "admin/marcas/delete";
        }
    }
}

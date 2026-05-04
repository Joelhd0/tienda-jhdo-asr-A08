package es.iesclaradelrey.da2d1a.tiendajhdoasr.web.controllers.admin;

import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.services.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller("adminCategoriaController")
@RequestMapping("/admin/categorias")
public class AdminCategoriaController {

    private final CategoriaService categoriaService;
    public AdminCategoriaController(CategoriaService categoriaService) { this.categoriaService = categoriaService; }

    @GetMapping("/") public String redir() { return "redirect:/admin/categorias"; }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", categoriaService.findAll());
        return "admin/categorias/list";
    }

    @GetMapping("/new")
    public String nuevaForm(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "admin/categorias/form";
    }

    @PostMapping("/new")
    public String nuevaGuardar(@ModelAttribute Categoria categoria, Model model) {
        try {
            categoriaService.save(categoria);
            return "redirect:/admin/categorias";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("categoria", categoria);
            return "admin/categorias/form";
        }
    }

    @GetMapping("/{id}/edit")
    public String editarForm(@PathVariable Long id, Model model) {
        Optional<Categoria> cat = categoriaService.findById(id);
        if (cat.isEmpty()) return "redirect:/admin/categorias";
        model.addAttribute("categoria", cat.get());
        return "admin/categorias/form";
    }

    @PostMapping("/{id}/edit")
    public String editarGuardar(@PathVariable Long id, @ModelAttribute Categoria categoria, Model model) {
        categoria.setId(id);
        try {
            categoriaService.save(categoria);
            return "redirect:/admin/categorias";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("categoria", categoria);
            return "admin/categorias/form";
        }
    }

    @GetMapping("/{id}/delete")
    public String borrarForm(@PathVariable Long id, Model model) {
        Optional<Categoria> cat = categoriaService.findById(id);
        if (cat.isEmpty()) return "redirect:/admin/categorias";
        model.addAttribute("categoria", cat.get());
        return "admin/categorias/delete";
    }

    @PostMapping("/{id}/delete")
    public String borrarConfirmar(@PathVariable Long id, Model model) {
        try {
            categoriaService.deleteById(id);
            return "redirect:/admin/categorias";
        } catch (Exception e) {
            Optional<Categoria> cat = categoriaService.findById(id);
            cat.ifPresent(c -> model.addAttribute("categoria", c));
            model.addAttribute("error", e.getMessage());
            return "admin/categorias/delete";
        }
    }
}

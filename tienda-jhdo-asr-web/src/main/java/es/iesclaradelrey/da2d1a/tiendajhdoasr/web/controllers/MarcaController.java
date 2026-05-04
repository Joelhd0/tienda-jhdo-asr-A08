package es.iesclaradelrey.da2d1a.tiendajhdoasr.web.controllers;

import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.services.MarcaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.Optional;

/**
 * Controlador público de marcas (actividad 7).
 * Muestra la marca y sus productos ordenados alfabéticamente.
 */
@Controller
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping("/")
    public String redirigir() { return "redirect:/marcas"; }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("marcas", marcaService.findAll());
        return "marcas/list";
    }

    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        Optional<Marca> marca = marcaService.findById(id);
        if (marca.isEmpty()) return "redirect:/marcas";
        Marca m = marca.get();
        // Ordenar productos de la marca alfabéticamente (expresión funcional, actividad 7)
        m.getProductos().sort(Comparator.comparing(p -> p.getNombre().toLowerCase()));
        model.addAttribute("marca", m);
        return "marcas/detail";
    }
}

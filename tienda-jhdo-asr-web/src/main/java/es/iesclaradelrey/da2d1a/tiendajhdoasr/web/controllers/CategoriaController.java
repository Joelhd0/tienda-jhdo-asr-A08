package es.iesclaradelrey.da2d1a.tiendajhdoasr.web.controllers;

import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.services.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/")
    public String redirigirListado() {
        return "redirect:/categorias";
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", categoriaService.findAll());
        return "categorias/list";
    }

    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        Optional<Categoria> categoria = categoriaService.findById(id);
        if (categoria.isEmpty()) return "redirect:/categorias";

        // Ordenar productos alfabéticamente con expresión funcional
        List<Producto> productosOrdenados = new ArrayList<>(categoria.get().getProductos());
        productosOrdenados.sort(Comparator.comparing(p -> p.getNombre().toLowerCase()));

        model.addAttribute("categoria", categoria.get());
        model.addAttribute("productosOrdenados", productosOrdenados);
        return "categorias/detail";
    }
}

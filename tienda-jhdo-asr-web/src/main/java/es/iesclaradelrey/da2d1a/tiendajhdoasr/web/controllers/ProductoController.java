package es.iesclaradelrey.da2d1a.tiendajhdoasr.web.controllers;

import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.services.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    /** Redirige /productos/ → /productos */
    @GetMapping("/")
    public String redirigirListado() {
        return "redirect:/productos";
    }

    /** Listado de todos los productos (actividad 5). */
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "productos/list";
    }

    @GetMapping("/{id}/**")
    public String detalle(@PathVariable Long id, Model model) {
        Optional<Producto> producto = productoService.findById(id);
        if (producto.isEmpty()) return "redirect:/productos";
        model.addAttribute("producto", producto.get());
        return "productos/detail";
    }
}

package es.iesclaradelrey.da2d1a.tiendajhdoasr.web.controllers;

import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.services.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controlador público de productos (actividades 5 y 7).
 * URL base: /productos
 */
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

    /**
     * Detalle de producto (actividad 5).
     * La URL incluye el slug del nombre por motivos SEO, pero se ignora en el controlador.
     * El motivo: el id es suficiente para identificar el producto; el slug solo sirve
     * a los motores de búsqueda y se puede generar dinámicamente desde la entidad.
     * Se usa ** como comodín para capturar cualquier valor del slug.
     */
    @GetMapping("/{id}/**")
    public String detalle(@PathVariable Long id, Model model) {
        Optional<Producto> producto = productoService.findById(id);
        if (producto.isEmpty()) return "redirect:/productos";
        model.addAttribute("producto", producto.get());
        return "productos/detail";
    }
}

package es.iesclaradelrey.da2d1a.tiendajhdoasr.web.controllers.carrito;

import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.services.ProductoService;
import es.iesclaradelrey.da2d1a.tiendajhdoasr.web.services.CarritoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controlador del carrito de la compra.
 * Todas las operaciones hacen redirect para evitar reenvíos de formulario (POST/Redirect/GET).
 */
@Controller
@RequestMapping("/carrito")
public class CarritoController {

    private final CarritoService carritoService;
    private final ProductoService productoService;

    public CarritoController(CarritoService carritoService, ProductoService productoService) {
        this.carritoService = carritoService;
        this.productoService = productoService;
    }

    /** Redirige /carrito/ → /carrito */
    @GetMapping("/")
    public String redirigir() { return "redirect:/carrito"; }

    /** Vista del carrito */
    @GetMapping
    public String verCarrito(HttpSession session, Model model) {
        model.addAttribute("items", carritoService.getCarrito(session));
        model.addAttribute("total", carritoService.totalImporte(session));
        return "carrito/carrito";
    }

    /** Añadir producto al carrito */
    @PostMapping("/añadir/{id}")
    public String añadir(@PathVariable Long id,
                         @RequestParam(defaultValue = "/carrito") String origen,
                         HttpSession session) {
        Optional<Producto> producto = productoService.findById(id);
        producto.ifPresent(p -> carritoService.añadir(session, p));
        return "redirect:" + origen;
    }

    /** Reducir en 1 una línea */
    @PostMapping("/reducir/{id}")
    public String reducir(@PathVariable Long id, HttpSession session) {
        carritoService.reducir(session, id);
        return "redirect:/carrito";
    }

    /** Eliminar línea completa */
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, HttpSession session) {
        carritoService.eliminar(session, id);
        return "redirect:/carrito";
    }

    /** Vaciar el carrito */
    @PostMapping("/vaciar")
    public String vaciar(HttpSession session) {
        carritoService.vaciar(session);
        return "redirect:/carrito";
    }
}

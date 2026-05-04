package es.iesclaradelrey.da2d1a.tiendajhdoasr.web.controllers.carrito;

import es.iesclaradelrey.da2d1a.tiendajhdoasr.web.services.CarritoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Inyecta el número de unidades del carrito en el modelo de todas las vistas,
 * para que la navbar pueda mostrar el badge sin tocar cada controlador.
 */
@ControllerAdvice
public class CarritoControllerAdvice {

    private final CarritoService carritoService;

    public CarritoControllerAdvice(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @ModelAttribute("carritoUnidades")
    public int carritoUnidades(HttpSession session) {
        try {
            return carritoService.totalUnidades(session);
        } catch (Exception e) {
            // Si la sesión no está disponible (ej: peticiones de recursos estáticos) devolver 0
            return 0;
        }
    }
}

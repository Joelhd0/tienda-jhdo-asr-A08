package es.iesclaradelrey.da2d1a.tiendajhdoasr.web.services;

import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.dto.CarritoItem;
import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities.Producto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Servicio que gestiona el carrito de la compra almacenado en la sesión HTTP.
 * No persiste datos: si el usuario cierra el navegador, el carrito se pierde.
 */
@Service
public class CarritoService {

    private static final String SESSION_KEY = "carrito";

    /** Devuelve el carrito de la sesión (crea uno vacío si no existe). */
    public List<CarritoItem> getCarrito(HttpSession session) {
        List<CarritoItem> carrito = (List<CarritoItem>) session.getAttribute(SESSION_KEY);
        if (carrito == null) {
            carrito = new ArrayList<>();
            session.setAttribute(SESSION_KEY, carrito);
        }
        return carrito;
    }

    /** Añade 1 unidad de un producto. Si ya está, incrementa la cantidad. */
    public void añadir(HttpSession session, Producto producto) {
        List<CarritoItem> carrito = getCarrito(session);
        Optional<CarritoItem> existente = carrito.stream()
                .filter(i -> i.getProductoId().equals(producto.getId()))
                .findFirst();
        if (existente.isPresent()) {
            existente.get().setCantidad(existente.get().getCantidad() + 1);
        } else {
            carrito.add(new CarritoItem(
                    producto.getId(),
                    producto.getNombre(),
                    producto.getImagen(),
                    producto.getPrecioConDescuento(),
                    1
            ));
        }
        session.setAttribute(SESSION_KEY, carrito);
    }

    /** Reduce en 1 la cantidad; elimina la línea si llega a 0. */
    public void reducir(HttpSession session, Long productoId) {
        List<CarritoItem> carrito = getCarrito(session);
        carrito.stream()
                .filter(i -> i.getProductoId().equals(productoId))
                .findFirst()
                .ifPresent(item -> {
                    if (item.getCantidad() <= 1) {
                        carrito.remove(item);
                    } else {
                        item.setCantidad(item.getCantidad() - 1);
                    }
                });
        session.setAttribute(SESSION_KEY, carrito);
    }

    /** Elimina una línea completa del carrito. */
    public void eliminar(HttpSession session, Long productoId) {
        List<CarritoItem> carrito = getCarrito(session);
        carrito.removeIf(i -> i.getProductoId().equals(productoId));
        session.setAttribute(SESSION_KEY, carrito);
    }

    /** Vacía el carrito. */
    public void vaciar(HttpSession session) {
        session.setAttribute(SESSION_KEY, new ArrayList<>());
    }

    /** Total de unidades (para mostrar badge en navbar). */
    public int totalUnidades(HttpSession session) {
        return getCarrito(session).stream()
                .mapToInt(CarritoItem::getCantidad)
                .sum();
    }

    /** Importe total del carrito. */
    public double totalImporte(HttpSession session) {
        return getCarrito(session).stream()
                .mapToDouble(CarritoItem::getSubtotal)
                .sum();
    }
}

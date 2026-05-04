package es.iesclaradelrey.da2d1a.tiendajhdoasr.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO serializable que representa una línea del carrito en sesión HTTP.
 * No es entidad JPA: el carrito se guarda solo en la sesión del usuario.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoItem implements Serializable {

    private Long productoId;
    private String nombre;
    private String imagen;
    private double precioUnitario;  // precio ya con descuento aplicado
    private int cantidad;

    /** Subtotal de esta línea. */
    public double getSubtotal() {
        return precioUnitario * cantidad;
    }
}

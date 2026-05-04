package es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "categorias")
@ToString(exclude = "categorias")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Código EAN-13: siempre 13 dígitos. */
    @NotBlank
    @Size(min = 13, max = 13)
    @Column(nullable = false, unique = true, length = 13)
    private String ean;

    @NotBlank
    @Size(max = 200)
    @Column(nullable = false, length = 200)
    private String nombre;

    @NotBlank
    @Size(max = 4000)
    @Column(nullable = false, length = 4000)
    private String descripcion;

    @Size(max = 500)
    @Column(length = 500)
    private String imagen;

    @NotNull
    @Positive
    private Double precio;

    @NotNull
    @Min(0) @Max(99)
    private Integer descuento;

 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "producto_categoria",
        joinColumns = @JoinColumn(name = "producto_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private Set<Categoria> categorias = new HashSet<>();

    /** Calcula el precio con descuento aplicado. */
    public double getPrecioConDescuento() {
        if (descuento == null || descuento == 0) return precio;
        return precio * (1.0 - descuento / 100.0);
    }

    public String getSlug() {
        if (nombre == null) return "";
        return nombre.toLowerCase()
                .replaceAll("[áàä]", "a")
                .replaceAll("[éèë]", "e")
                .replaceAll("[íìï]", "i")
                .replaceAll("[óòö]", "o")
                .replaceAll("[úùü]", "u")
                .replaceAll("[ñ]", "n")
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("^-|-$", "");
    }
}

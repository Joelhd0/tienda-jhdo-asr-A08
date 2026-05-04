package es.iesclaradelrey.da2d1a.tiendajhdoasr.common.repositories;

import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/** Repositorio Spring Data JPA para Producto (actividad 5). */
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    /**
     * Carga todos los productos junto con sus categorías y marca en una sola consulta,
     * evitando LazyInitializationException al renderizar las plantillas Thymeleaf.
     */
    @Query("SELECT DISTINCT p FROM Producto p " +
           "LEFT JOIN FETCH p.categorias " +
           "LEFT JOIN FETCH p.marca")
    List<Producto> findAllWithCategoriasAndMarca();
}

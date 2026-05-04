package es.iesclaradelrey.da2d1a.tiendajhdoasr.common.repositories;

import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio Spring Data JPA para Categoria (actividad 4).
 * La interfaz CategoriaRepositoryImpl ya no es necesaria.
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

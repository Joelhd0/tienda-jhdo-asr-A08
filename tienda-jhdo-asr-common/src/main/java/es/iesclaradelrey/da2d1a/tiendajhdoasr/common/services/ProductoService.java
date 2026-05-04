package es.iesclaradelrey.da2d1a.tiendajhdoasr.common.services;

import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    Producto save(Producto producto);
    void deleteById(Long id);
}

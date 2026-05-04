package es.iesclaradelrey.da2d1a.tiendajhdoasr.common.services;

import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities.Marca;
import java.util.List;
import java.util.Optional;

public interface MarcaService {
    List<Marca> findAll();
    Optional<Marca> findById(Long id);
    Marca save(Marca marca);
    void deleteById(Long id);
}

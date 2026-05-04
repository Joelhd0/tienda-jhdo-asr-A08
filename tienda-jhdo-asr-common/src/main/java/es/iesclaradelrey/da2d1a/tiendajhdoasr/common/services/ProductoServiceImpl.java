package es.iesclaradelrey.da2d1a.tiendajhdoasr.common.services;

import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.repositories.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    /**
     * Devuelve todos los productos con categorías y marca ya inicializadas,
     * evitando LazyInitializationException en las vistas Thymeleaf.
     */
    @Override
    public List<Producto> findAll() {
        return productoRepository.findAllWithCategoriasAndMarca();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}

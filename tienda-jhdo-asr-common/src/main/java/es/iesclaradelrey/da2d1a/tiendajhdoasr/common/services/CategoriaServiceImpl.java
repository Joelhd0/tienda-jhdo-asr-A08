package es.iesclaradelrey.da2d1a.tiendajhdoasr.common.services;

import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override public List<Categoria> findAll() { return categoriaRepository.findAll(); }
    @Override public Optional<Categoria> findById(Long id) { return categoriaRepository.findById(id); }
    @Override public Categoria save(Categoria categoria) { return categoriaRepository.save(categoria); }
    @Override public void deleteById(Long id) { categoriaRepository.deleteById(id); }
}

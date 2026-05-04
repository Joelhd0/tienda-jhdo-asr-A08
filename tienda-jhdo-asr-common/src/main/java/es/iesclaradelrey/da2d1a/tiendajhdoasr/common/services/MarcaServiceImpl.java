package es.iesclaradelrey.da2d1a.tiendajhdoasr.common.services;

import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.repositories.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository marcaRepository;
    public MarcaServiceImpl(MarcaRepository marcaRepository) { this.marcaRepository = marcaRepository; }

    @Override public List<Marca> findAll() { return marcaRepository.findAll(); }
    @Override public Optional<Marca> findById(Long id) { return marcaRepository.findById(id); }
    @Override public Marca save(Marca marca) { return marcaRepository.save(marca); }
    @Override public void deleteById(Long id) { marcaRepository.deleteById(id); }
}

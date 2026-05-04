package es.iesclaradelrey.da2d1a.tiendajhdoasr.web.controllers.admin;

import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities.Categoria;
import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities.Marca;
import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.entities.Producto;
import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.services.CategoriaService;
import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.services.MarcaService;
import es.iesclaradelrey.da2d1a.tiendajhdoasr.common.services.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller("adminProductoController")
@RequestMapping("/admin/productos")
public class AdminProductoController {

    private final ProductoService productoService;
    private final MarcaService marcaService;
    private final CategoriaService categoriaService;

    public AdminProductoController(ProductoService productoService, MarcaService marcaService, CategoriaService categoriaService) {
        this.productoService = productoService;
        this.marcaService = marcaService;
        this.categoriaService = categoriaService;
    }

    private void cargarDatos(Model model) {
        model.addAttribute("marcas", marcaService.findAll());
        model.addAttribute("categorias", categoriaService.findAll());
    }

    @GetMapping("/") public String redir() { return "redirect:/admin/productos"; }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "admin/productos/list";
    }

    @GetMapping("/new")
    public String nuevaForm(Model model) {
        model.addAttribute("producto", new Producto());
        cargarDatos(model);
        return "admin/productos/form";
    }

    @PostMapping("/new")
    public String nuevaGuardar(@ModelAttribute Producto producto,
                               @RequestParam(required = false) Long marcaId,
                               @RequestParam(required = false) List<Long> categoriasIds,
                               Model model) {
        try {
            asociarRelaciones(producto, marcaId, categoriasIds);
            productoService.save(producto);
            return "redirect:/admin/productos";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("producto", producto);
            cargarDatos(model);
            return "admin/productos/form";
        }
    }

    @GetMapping("/{id}/edit")
    public String editarForm(@PathVariable Long id, Model model) {
        Optional<Producto> p = productoService.findById(id);
        if (p.isEmpty()) return "redirect:/admin/productos";
        model.addAttribute("producto", p.get());
        cargarDatos(model);
        return "admin/productos/form";
    }

    @PostMapping("/{id}/edit")
    public String editarGuardar(@PathVariable Long id, @ModelAttribute Producto producto,
                                @RequestParam(required = false) Long marcaId,
                                @RequestParam(required = false) List<Long> categoriasIds,
                                Model model) {
        producto.setId(id);
        try {
            asociarRelaciones(producto, marcaId, categoriasIds);
            productoService.save(producto);
            return "redirect:/admin/productos";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("producto", producto);
            cargarDatos(model);
            return "admin/productos/form";
        }
    }

    @GetMapping("/{id}/delete")
    public String borrarForm(@PathVariable Long id, Model model) {
        Optional<Producto> p = productoService.findById(id);
        if (p.isEmpty()) return "redirect:/admin/productos";
        model.addAttribute("producto", p.get());
        return "admin/productos/delete";
    }

    @PostMapping("/{id}/delete")
    public String borrarConfirmar(@PathVariable Long id, Model model) {
        try { productoService.deleteById(id); return "redirect:/admin/productos"; }
        catch (Exception e) {
            productoService.findById(id).ifPresent(p -> model.addAttribute("producto", p));
            model.addAttribute("error", e.getMessage());
            return "admin/productos/delete";
        }
    }

    private void asociarRelaciones(Producto producto, Long marcaId, List<Long> categoriasIds) {
        if (marcaId != null) {
            marcaService.findById(marcaId).ifPresent(producto::setMarca);
        }
        if (categoriasIds != null && !categoriasIds.isEmpty()) {
            Set<Categoria> cats = new HashSet<>();
            for (Long cid : categoriasIds) {
                categoriaService.findById(cid).ifPresent(cats::add);
            }
            producto.setCategorias(cats);
        } else {
            producto.setCategorias(new HashSet<>());
        }
    }
}

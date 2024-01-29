package mx.edu.utez.Examen.controller;

import mx.edu.utez.Examen.model.libro.Libro;
import mx.edu.utez.Examen.service.LibroService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/libro")
@CrossOrigin(origins = {"*"})
public class LibroController {
    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping("/")
    public Libro crearLibro(@RequestBody Libro libro) {
        return libroService.guardarLibro(libro);
    }

    @GetMapping("/{titulo}")
    public Libro buscarPorTitulo(@PathVariable String titulo) {
        return libroService.buscarPorTitulo(titulo);
    }

    @PutMapping("/{id}")
    public void actualizarLibro(@RequestBody Libro libro) {
        libroService.actualizarLibro(libro);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
    }
}

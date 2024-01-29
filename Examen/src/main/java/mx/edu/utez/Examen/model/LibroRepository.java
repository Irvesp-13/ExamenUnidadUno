package mx.edu.utez.Examen.model;

import mx.edu.utez.Examen.model.libro.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    Libro findByFolio(String folio);
    Libro findByTitulo(String titulo);
}


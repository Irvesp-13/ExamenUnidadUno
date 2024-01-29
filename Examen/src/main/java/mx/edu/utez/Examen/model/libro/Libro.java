package mx.edu.utez.Examen.model.libro;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "books")
@NoArgsConstructor
@Getter
@Setter
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String isbn;

    @Column(length = 40, nullable = false)
    private String autor;

    @Column(nullable = false)
    private Integer paginas;

    @Column(length = 40, nullable = false)
    private String categoria;

    @Column(columnDefinition = "DATE", nullable = false)
    private Date publicacion;

    @Column(length = 40, nullable = false)
    private String folio;

    public Libro(Long id, String titulo, String isbn, String autor, Integer paginas, String categoria, Date publicacion, String folio) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.paginas = paginas;
        this.categoria = categoria;
        this.publicacion = publicacion;
        this.folio = folio;
    }
}

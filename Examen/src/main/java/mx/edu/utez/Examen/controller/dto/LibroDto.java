package mx.edu.utez.Examen.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class LibroDto {
    private Long id;
    private String titulo;
    private String isbn;
    private String autor;
    private Integer paginas;
    private String categoria;
    private Date publicacion;
    private String folio;
}

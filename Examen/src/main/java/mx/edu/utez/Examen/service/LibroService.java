package mx.edu.utez.Examen.service;

import mx.edu.utez.Examen.model.LibroRepository;
import mx.edu.utez.Examen.model.libro.Libro;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
@Transactional
public class LibroService {
    private LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public Libro guardarLibro(Libro libro) {
        libro.setFolio(generarFolio(libro));
        return libroRepository.save(libro);
    }

    public Libro buscarPorId(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    public Libro buscarPorTitulo(String titulo) {
        return libroRepository.findByTitulo(titulo);
    }

    public Libro buscarPorFolio(String folio) {
        return libroRepository.findByFolio(folio);
    }

    public void actualizarLibro(Libro libro) {
        libroRepository.save(libro);
    }

    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

    private String generarFolio(Libro libro) {
        String primerasLetrasAutor = obtenerPrimerasLetras(libro.getAutor());
        String fechaPublicacion = formatDate(libro.getPublicacion());
        String primerasLetrasISBN = libro.getIsbn().substring(0, 4);
        String randomPart = generateRandomString(2);
        return primerasLetrasAutor + fechaPublicacion + primerasLetrasISBN + randomPart;
    }

    private String obtenerPrimerasLetras(String autor) {
        String[] partes = autor.split(" ");
        String primerasLetras = "";
        for (String parte : partes) {
            primerasLetras += parte.charAt(0);
        }
        return primerasLetras.substring(0, Math.min(primerasLetras.length(), 3)).toUpperCase();
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(date);
    }

    private String generateRandomString(int length) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }

        return sb.toString();
    }
}

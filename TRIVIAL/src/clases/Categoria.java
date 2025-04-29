package clases;

/**
 * Clase que representa una categoría de preguntas.
 */
public class Categoria {
    private final String nombre;
    private final String descripcion;
    private final int puntos;

    /**
     * Constructor para inicializar una categoría con puntos asociados.
     * @param nombre El nombre de la categoría.
     * @param descripcion La descripción de la categoría.
     * @param puntos Los puntos asignados a las preguntas de esta categoría.
     */
    public Categoria(String nombre, String descripcion, int puntos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntos = puntos;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPuntos() {
        return puntos;
    }

    @Override
    public String toString() {
        return "Nombre de la categoría: " + nombre + ", Descripción: " + descripcion + ", Puntos: " + puntos;
    }
}

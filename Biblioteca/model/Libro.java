package model;

public abstract class Libro {
    protected int id;
    protected String titulo;
    protected String autor;
    protected int anio;
    protected String genero;
    protected boolean disponible;

    public Libro(int id, String titulo, String autor, int anio, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        this.disponible = true;
    }

    public abstract String getTipo();

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void prestar() {
        this.disponible = false;
    }

    public void devolver() {
        this.disponible = true;
    }

    @Override
    public String toString() {
        return "[" + getTipo() + "] " + titulo + " - " + autor + " (" + anio + ")";
    }
}

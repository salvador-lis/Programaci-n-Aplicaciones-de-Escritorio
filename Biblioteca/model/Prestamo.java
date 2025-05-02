package model;

import java.util.Date;

public class Prestamo {
    private int id;
    private Libro libro;
    private Usuario usuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private boolean devuelto;

    public Prestamo(int id, Libro libro, Usuario usuario, Date fechaPrestamo, Date fechaDevolucion) {
        this.id = id;
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = false;
    }

    public int getId() {
        return id;
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void marcarComoDevuelto() {
        this.devuelto = true;
        this.libro.devolver(); // también cambia estado del libro
    }

    public boolean estaAtrasado(Date fechaActual) {
        return !devuelto && fechaActual.after(fechaDevolucion);
    }

    @Override
    public String toString() {
        return "Préstamo #" + id + ": " + libro.getTitulo() + " a " + usuario.getNombre() +
               " - Devolver antes del " + fechaDevolucion;
    }
}

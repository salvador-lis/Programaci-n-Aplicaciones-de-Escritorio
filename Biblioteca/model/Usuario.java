package model;

public abstract class Usuario {
    protected int id;
    protected String nombre;
    protected String email;
    protected String telefono;

    public Usuario(int id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public abstract int getLimitePrestamos();

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + nombre + " (ID: " + id + ")";
    }
}

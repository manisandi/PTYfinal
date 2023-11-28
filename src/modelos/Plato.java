/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author yendri
 */
public class Plato {

    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int categoria; // 1 - Entrada, 2 - Plato Fuerte, 3 - Postre, 4 - Bebida

    public Plato() {}

    public Plato(String codigo, String nombre, String descripcion, double precio, int categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    
    public String obtenerCSV(){ // Se reemplazan los enters del la desripcion por & para evitar problemas al guardar pero se devuelve a su valor original al mostrarse
        return codigo + "|" + nombre + "|" + descripcion.replace("\n", "&") + "|" + String.valueOf(precio) + "|" + String.valueOf(categoria);
    }
}
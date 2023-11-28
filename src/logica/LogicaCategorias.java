/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.LinkedList;
import modelos.Categoria;

/**
 *
 * @author yendri
 */
public class LogicaCategorias {

    LinkedList<Categoria> lista_categorias;

    public LogicaCategorias() {

        lista_categorias = new LinkedList<>();

        lista_categorias.add(new Categoria(1, "Entrada"));
        lista_categorias.add(new Categoria(2, "Plato Fuerte"));
        lista_categorias.add(new Categoria(3, "Postre"));
        lista_categorias.add(new Categoria(4, "Bebida"));
    }

    public LinkedList<Categoria> getListaCategorias() {
        return lista_categorias;
    }
    
    public Categoria buscarPorNombre(String nombre) {
        Categoria categoria = null;

        for (Categoria c : lista_categorias) {
            if (c.getNombre().equals(nombre)) {
                categoria = c;
                break;
            }
        }

        return categoria;
    }
    
    public Categoria buscarPorId(int id){
        Categoria categoria = null;

        for (Categoria c : lista_categorias) {
            if (c.getId() == id) {
                categoria = c;
                break;
            }
        }

        return categoria;
    }
}

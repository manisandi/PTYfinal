/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.LinkedList;
import modelos.Rol;

/**
 *
 * @author yendri
 */
public class LogicaRoles {

    private LinkedList<Rol> lista_roles;

    public LogicaRoles() {
        lista_roles = new LinkedList<Rol>();

        lista_roles.add(new Rol(1, "Administrador"));
        lista_roles.add(new Rol(2, "Mesero"));
    }

    public LinkedList<Rol> getListaRoles() {
        return lista_roles;
    }

    public Rol buscarPorNombre(String nombre) {
        Rol rol = null;

        for (Rol r : lista_roles) {
            if (r.getNombre().equals(nombre)) {
                rol = r;
                break;
            }
        }

        return rol;
    }
    
    public Rol buscarPorId(int id){
        Rol rol = null;

        for (Rol r : lista_roles) {
            if (r.getId() == id) {
                rol = r;
                break;
            }
        }

        return rol;
    }
}

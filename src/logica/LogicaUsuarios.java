/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.LinkedList;
import modelos.Rol;
import modelos.Usuario;

/**
 *
 * @author yendri
 */
public class LogicaUsuarios {
    private Usuario MainAdmin;

    public LogicaUsuarios() {
        MainAdmin = new Usuario(0, "Admin", "Admin", new Rol(1, "Administrator"));
    }

    public Usuario getMainAdmin() {
        return MainAdmin;
    }
    
    public LinkedList<Usuario> getListaUsuarios(){
        LinkedList<Usuario> lista_usuarios = new LinkedList<Usuario>();
        
        lista_usuarios.add(new Usuario(1, "Mesero 1", "Mesero 1", new Rol(2, "Mesero")));
        
        return lista_usuarios;
    }
}

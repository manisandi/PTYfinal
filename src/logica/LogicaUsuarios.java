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
    private LogicaArchivos l_archivos;
    private LogicaRoles l_roles;
    private String separador = ",";

    public LogicaUsuarios() {
        MainAdmin = new Usuario(0, "Admin", "Admin", new Rol(1, "Administrator"));
        l_archivos = new LogicaArchivos();
        l_roles = new LogicaRoles();
    }

    public void guardarUsuario(Usuario usuario) {
        LinkedList<Usuario> lista_usuarios = getListaUsuarios();
        
        // Booleano para verificar si se encuentra el id del usuario a guardar
        boolean existe = false;
        
        // busca el usuario por id, si existe lo actualiza
        for (int i = 0; i < lista_usuarios.size(); i++) {
            if (lista_usuarios.get(i).getId() == usuario.getId()){
                lista_usuarios.set(i, usuario);
                existe = true;
                break;
            }
        }
        
        // si el for anterior termina sin encontrar el ID significa que es un usuario nuevo entonces lo añade
        if (!existe){
            lista_usuarios.add(usuario);
        }
        
        // convierte el linkedlist en un arreglo de Strings para escribirlo en los archivos
        int index = 0;
        String[] lineas = new String[lista_usuarios.size()];
        
        for (Usuario u : lista_usuarios) {
            lineas[index++] = u.obtenerCSV();
        }
        
        // llama al metodo escribir archivo pasandole el archivo correcto y los datos a escribir
        l_archivos.EscribirArchivo(l_archivos.getArchivoUsuarios(), lineas);
    }
    
    public void eliminarUsuario(Usuario usuario){
        LinkedList<Usuario> lista_usuarios = getListaUsuarios();
        
        for (int i = 0; i < lista_usuarios.size(); i++) {
            if (lista_usuarios.get(i).getId() == usuario.getId()){
                lista_usuarios.remove(i);
                break;
            }
        }
        
        int index = 0;
        String[] lineas = new String[lista_usuarios.size()];
        
        for (Usuario u : lista_usuarios) {
            lineas[index++] = u.obtenerCSV();
        }
        

        
        l_archivos.EscribirArchivo(l_archivos.getArchivoUsuarios(), lineas);
    }

    public LinkedList<Usuario> getListaUsuarios() {
        LinkedList<Usuario> lista_usuarios = new LinkedList<Usuario>();

        LinkedList<String> lineas = l_archivos.LeerArchivo(l_archivos.getArchivoUsuarios());

        for (String linea : lineas) {
            String[] split = linea.split(separador);
            Usuario u = new Usuario(Integer.parseInt(split[0]), split[1], split[2], l_roles.buscarPorId(Integer.parseInt(split[3])));
            lista_usuarios.add(u);
        }

        return lista_usuarios;
    }

    public Usuario buscarPorId(int id) {
        LinkedList<Usuario> lista_usuarios = new LinkedList<Usuario>();

        LinkedList<String> lineas = l_archivos.LeerArchivo(l_archivos.getArchivoUsuarios());

        for (String linea : lineas) {
            String[] split = linea.split(separador);
            Usuario u = new Usuario(Integer.parseInt(split[0]), split[1], split[2], l_roles.buscarPorId(Integer.parseInt(split[3])));
            lista_usuarios.add(u);
        }

        Usuario usuario = null;

        for (Usuario u : lista_usuarios) {
            if (u.getId() == id) {
                usuario = u;
                break;
            }
        }
        return usuario;
    }

    public Usuario getMainAdmin() {
        return MainAdmin;
    }
}

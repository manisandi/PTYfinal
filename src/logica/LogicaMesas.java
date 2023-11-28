/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.LinkedList;
import modelos.Mesa;
import modelos.Usuario;

/**
 *
 * @author yendri
 */
public class LogicaMesas {

    private LogicaArchivos l_archivos;
    private String separador = ",";

    public LogicaMesas() {
        l_archivos = new LogicaArchivos();
    }

    public LinkedList<Mesa> getListaMesas() {
        LinkedList<Mesa> lista_mesas = new LinkedList<Mesa>();

        LinkedList<String> lineas = l_archivos.LeerArchivo(l_archivos.getArchivoMesas());

        for (String linea : lineas) {
            String[] split = linea.split(separador);
            Mesa u = new Mesa(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            lista_mesas.add(u);
        }

        return lista_mesas;
    }
    
    public Mesa buscarPorNumero(int numero) {
        LinkedList<Mesa> lista_mesas = new LinkedList<Mesa>();

        LinkedList<String> lineas = l_archivos.LeerArchivo(l_archivos.getArchivoMesas());

        for (String linea : lineas) {
            String[] split = linea.split(separador);
            Mesa u = new Mesa(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            lista_mesas.add(u);
        }

        Mesa mesa = null;

        for (Mesa m : lista_mesas) {
            if (m.getNumero()== numero) {
                mesa = m;
                break;
            }
        }
        return mesa;
    }
    
    public void guardarMesa(Mesa mesa) {
        LinkedList<Mesa> lista_mesas = getListaMesas();
        
        // Booleano para verificar si se encuentra el id del usuario a guardar
        boolean existe = false;
        
        // busca el usuario por id, si existe lo actualiza
        for (int i = 0; i < lista_mesas.size(); i++) {
            if (lista_mesas.get(i).getNumero()== mesa.getNumero()){
                lista_mesas.set(i, mesa);
                existe = true;
                break;
            }
        }
        
        // si el for anterior termina sin encontrar el ID significa que es un usuario nuevo entonces lo añade
        if (!existe){
            lista_mesas.add(mesa);
        }
        
        // convierte el linkedlist en un arreglo de Strings para escribirlo en los archivos
        int index = 0;
        String[] lineas = new String[lista_mesas.size()];
        
        for (Mesa m : lista_mesas) {
            lineas[index++] = m.obtenerCSV();
        }
        
        // llama al metodo escribir archivo pasandole el archivo correcto y los datos a escribir
        l_archivos.EscribirArchivo(l_archivos.getArchivoMesas(), lineas);
    }
    
    public void eliminarMesa(Mesa mesa){
        LinkedList<Mesa> lista_mesas = getListaMesas();
        
        for (int i = 0; i < lista_mesas.size(); i++) {
            if (lista_mesas.get(i).getNumero()== mesa.getNumero()){
                lista_mesas.remove(i);
                break;
            }
        }
        
        int index = 0;
        String[] lineas = new String[lista_mesas.size()];
        
        for (Mesa m : lista_mesas) {
            lineas[index++] = m.obtenerCSV();
        }
        
        l_archivos.EscribirArchivo(l_archivos.getArchivoUsuarios(), lineas);
    }
}

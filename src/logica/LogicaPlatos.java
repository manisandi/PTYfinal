/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.LinkedList;
import modelos.Mesa;
import modelos.Plato;

/**
 *
 * @author yendri
 */
public class LogicaPlatos {

    private LogicaArchivos l_archivos;
    private String separador = "\\|"; // se cambia el tipo de separador de "," a "|" ya que las descripciones o nombres podrian incluir comas

    public LogicaPlatos() {
        l_archivos = new LogicaArchivos();
    }

    public LinkedList<Plato> getListaPlatos() {
        LinkedList<Plato> lista_platos = new LinkedList<Plato>();

        LinkedList<String> lineas = l_archivos.LeerArchivo(l_archivos.getArchivoPlatos());

        for (String linea : lineas) {
            String[] split = linea.split(separador);
            Plato p = new Plato(split[0], split[1], split[2], Double.parseDouble(split[3]), Integer.parseInt(split[4]));
            lista_platos.add(p);
        }

        return lista_platos;
    }
    
    public Plato buscarPorCodigo(String codigo) {
        LinkedList<Plato> lista_platos = new LinkedList<Plato>();

        LinkedList<String> lineas = l_archivos.LeerArchivo(l_archivos.getArchivoPlatos());

        for (String linea : lineas) {
            String[] split = linea.split(separador);
            Plato p = new Plato(split[0], split[1], split[2], Double.parseDouble(split[3]), Integer.parseInt(split[4]));
            lista_platos.add(p);
        }

        Plato plato = null;

        for (Plato p : lista_platos) {
            if (p.getCodigo().equals(codigo)) {
                plato = p;
                break;
            }
        }
        return plato;
    }
    
    public void eliminarPlato(Plato plato){
        LinkedList<Plato> lista_platos = getListaPlatos();
        
        for (int i = 0; i < lista_platos.size(); i++) {
            if (lista_platos.get(i).getCodigo().equals(plato.getCodigo())){
                lista_platos.remove(i);
                break;
            }
        }
        
        int index = 0;
        String[] lineas = new String[lista_platos.size()];
        
        for (Plato p : lista_platos) {
            lineas[index++] = p.obtenerCSV();
        }
        
        l_archivos.EscribirArchivo(l_archivos.getArchivoPlatos(), lineas);
    }
    
    public void guardarPlato(Plato plato) {
        LinkedList<Plato> lista_platos = getListaPlatos();
        
        // Booleano para verificar si se encuentra el id del usuario a guardar
        boolean existe = false;
        
        // busca el usuario por id, si existe lo actualiza
        for (int i = 0; i < lista_platos.size(); i++) {
            if (lista_platos.get(i).getCodigo().equals(plato.getCodigo())){
                lista_platos.set(i, plato);
                existe = true;
                break;
            }
        }
        
        // si el for anterior termina sin encontrar el ID significa que es un usuario nuevo entonces lo añade
        if (!existe){
            lista_platos.add(plato);
        }
        
        // convierte el linkedlist en un arreglo de Strings para escribirlo en los archivos
        int index = 0;
        String[] lineas = new String[lista_platos.size()];
        
        for (Plato p : lista_platos) {
            lineas[index++] = p.obtenerCSV();
        }
        
        // llama al metodo escribir archivo pasandole el archivo correcto y los datos a escribir
        l_archivos.EscribirArchivo(l_archivos.getArchivoPlatos(), lineas);
    }
}

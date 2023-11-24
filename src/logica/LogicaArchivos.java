/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author yendri
 */
public class LogicaArchivos {

    private String ruta;

    private String ArchivoUsuarios = "Usuarios.csv";
    private String ArchivoPlatos = "Platos.csv";
    private String ArchivoPedidos = "Pedidos.csv";
    private String ArchivoMesas = "Mesas.csv";

    public LogicaArchivos() {
        ruta = "src/archivos/";
    }

    public void CrearArchivos() {
        CrearArchivo(ArchivoUsuarios);
        CrearArchivo(ArchivoPlatos);
        CrearArchivo(ArchivoPedidos);
        CrearArchivo(ArchivoMesas);
    }

    public void CrearArchivo(String nombreArchivo) {
        String rutaArchivo = ruta + nombreArchivo;

        // Crear un objeto File con el nombre del archivo
        File archivo = new File(rutaArchivo);

        if (!archivo.exists()) {
            try {
                // Si el archivo no existe, se crea
                if (archivo.createNewFile()) {
                    System.out.println("Se ha creado el archivo '" + nombreArchivo + "' correctamente.");
                } else {
                    System.out.println("No se pudo crear el archivo '" + nombreArchivo + "'.");
                }
            } catch (IOException e) {
                System.err.println("Error al crear el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo '" + nombreArchivo + "' ya existe. No es necesario crearlo.");
        }
    }

    public void EscribirArchivo(String archivo, String[] datos) {
        String rutaArchivo = ruta + archivo;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            // Escribir los datos en el archivo CSV
            for (String dato : datos) {
                writer.write(dato + "\n");
            }

            System.out.println("Se ha escrito en el archivo CSV correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }

    public LinkedList<String> LeerArchivo(String archivo) {
        String rutaArchivo = ruta + archivo;
        LinkedList<String> lineas = new LinkedList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
            System.out.println("Se han leído las líneas del archivo correctamente.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }

        return lineas;
    }

    public String getArchivoUsuarios() {
        return ArchivoUsuarios;
    }

    public String getArchivoPlatos() {
        return ArchivoPlatos;
    }

    public String getArchivoPedidos() {
        return ArchivoPedidos;
    }

    public String getArchivoMesas() {
        return ArchivoMesas;
    }
}

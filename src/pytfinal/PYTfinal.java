/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pytfinal;

import ventanas.FrmLogin;

/**
 *
 * @author yendri
 */
public class PYTfinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instancia del FormLogin
        FrmLogin login = new FrmLogin();
        // Para iniciar la ventana en el centro de la pantalla
        login.setLocationRelativeTo(null);
        // Setear propiedad visible en True para mostrar la ventana
        login.setVisible(true);
    }
}

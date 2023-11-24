/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import java.util.LinkedList;
import javax.swing.JOptionPane;
import logica.LogicaUsuarios;
import logica.LogicaArchivos;
import modelos.Usuario;

/**
 *
 * @author yendri
 */
public class FrmLogin extends javax.swing.JFrame {

    private LogicaUsuarios l_usuarios;
    private LogicaArchivos l_archivos;
    private LinkedList<Usuario> lista_usuarios;

    /**
     * Creates new form login
     */
    public FrmLogin() {
        initComponents();
        // Instancia de la clase con la logica de usuarios
        l_usuarios = new LogicaUsuarios();
        l_archivos = new LogicaArchivos();
        
        // Crea archivos para almacenar datos, si existen no los sobreescribe
        l_archivos.CrearArchivos();
        
        // Se obtiene la lista de usuarios en los archivos
        lista_usuarios = l_usuarios.getListaUsuarios();

        // Usuario seteado por defecto en inputs para acelerar pruebas
        txtUser.setText("Admin");
        jfielPassword.setText("Admin");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblgrupotortillacr = new javax.swing.JLabel();
        lbluser = new javax.swing.JLabel();
        lblpassword = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        jfielPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblgrupotortillacr.setFont(new java.awt.Font("Goudy Old Style", 0, 24)); // NOI18N
        lblgrupotortillacr.setText("Grupo TortillaCR");

        lbluser.setFont(new java.awt.Font("Goudy Old Style", 0, 24)); // NOI18N
        lbluser.setText("User:");

        lblpassword.setFont(new java.awt.Font("Goudy Old Style", 0, 24)); // NOI18N
        lblpassword.setText("Password:");

        btnLogin.setFont(new java.awt.Font("Goudy Old Style", 0, 24)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/tortilla.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(56, 56, 56)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbluser, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblpassword))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jfielPassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblgrupotortillacr)
                        .addGap(48, 48, 48)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblgrupotortillacr)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbluser)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpassword)
                    .addComponent(jfielPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("login");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        // Se obtiene lo digitado en los inputs
        String user = txtUser.getText();
        String password = new String(jfielPassword.getPassword());

        // Se obtiene de la clase de logica el usuario predefinido en sistema
        Usuario admin = l_usuarios.getMainAdmin();

        // Evaluación
        // Si es usuario predefinido
        // Si no, se busca en la lista de usuarios una coincidencia en las credenciales
        // Si si, se muestra la ventana pasando el usuario activo y se carga la ventana de acuerdo al rol.
        // Si no, se muestra mensaje de error
        if (admin.getUsuario().equals(user) && admin.getContrasena().equals(password)) {
            FrmMenuPrincipal ventana = new FrmMenuPrincipal(admin);
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
            this.dispose();
        } else {
            boolean encontrado = false;
            for (Usuario u : lista_usuarios) {
                if (u.getUsuario().equals(user) && u.getContrasena().equals(password)) {
                    encontrado = true;
                    FrmMenuPrincipal ventana = new FrmMenuPrincipal(u);
                    ventana.setLocationRelativeTo(null);
                    ventana.setVisible(true);
                    this.dispose();
                }
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(this, "Datos de inicio de sesion incorrectos, intentelo nuevamente");                
            }
        }
    }//GEN-LAST:event_btnLoginMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jfielPassword;
    private javax.swing.JLabel lblgrupotortillacr;
    private javax.swing.JLabel lblpassword;
    private javax.swing.JLabel lbluser;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}

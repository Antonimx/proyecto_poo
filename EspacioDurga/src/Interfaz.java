
public class Interfaz extends javax.swing.JFrame {
    private final SentenciasSQL sql = new SentenciasSQL();
    
    public Interfaz() {
        sql.conectar();
        sql.conseguirPlanes();
        sql.conseguirAlumnos();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmdAsistencia = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmdContratar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        cmdSalir = new javax.swing.JButton();
        cmdAgregarAlumno = new javax.swing.JButton();
        cmdVerPlanes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jPanel1.setBackground(new java.awt.Color(186, 186, 186));
        jPanel1.setLayout(null);

        cmdAsistencia.setText("Tomar asistencia");
        cmdAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAsistenciaActionPerformed(evt);
            }
        });
        jPanel1.add(cmdAsistencia);
        cmdAsistencia.setBounds(40, 350, 130, 23);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Control de Asistencia \"Espacio Durga\"");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 20, 440, 30);

        cmdContratar.setText("Contratar plan");
        cmdContratar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdContratarActionPerformed(evt);
            }
        });
        jPanel1.add(cmdContratar);
        cmdContratar.setBounds(240, 350, 120, 23);

        jLabel2.setText("Bienvenido al menu, a continuacion elija una opcion:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(150, 300, 290, 16);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(370, 260, 0, 3);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/durga.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(210, 50, 150, 230);

        cmdSalir.setText("Salir");
        cmdSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSalirActionPerformed(evt);
            }
        });
        jPanel1.add(cmdSalir);
        cmdSalir.setBounds(470, 410, 75, 23);

        cmdAgregarAlumno.setText("Agregar Alumno");
        cmdAgregarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAgregarAlumnoActionPerformed(evt);
            }
        });
        jPanel1.add(cmdAgregarAlumno);
        cmdAgregarAlumno.setBounds(430, 350, 120, 23);

        cmdVerPlanes.setText("Ver Historial de Planes contratados");
        jPanel1.add(cmdVerPlanes);
        cmdVerPlanes.setBounds(40, 410, 240, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAsistenciaActionPerformed
        TomarAsistencia T_asis = new TomarAsistencia(sql);
        T_asis.setVisible(true);
                
               
    }//GEN-LAST:event_cmdAsistenciaActionPerformed

    private void cmdSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cmdSalirActionPerformed

    private void cmdContratarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdContratarActionPerformed
        ContratarPlan C_plan = new ContratarPlan(sql);
        C_plan.setVisible(true);
    }//GEN-LAST:event_cmdContratarActionPerformed

    private void cmdAgregarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAgregarAlumnoActionPerformed
        NuevoAlumno N_alum = new NuevoAlumno(sql);
        N_alum.setVisible(true);
    }//GEN-LAST:event_cmdAgregarAlumnoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAgregarAlumno;
    private javax.swing.JButton cmdAsistencia;
    private javax.swing.JButton cmdContratar;
    private javax.swing.JButton cmdSalir;
    private javax.swing.JButton cmdVerPlanes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}

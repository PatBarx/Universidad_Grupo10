
import Vistas.Fri_Alumnos;
import Vistas.Fri_Inscripciones;
import Vistas.Fri_Materias;

/*
 * @author Grupo10
 */
public class FrMain_Universidad extends javax.swing.JFrame {

    /**
     * Creates new form JFmainUni_prueba
     */
    public FrMain_Universidad() {
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

        escritorio1 = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuFormAlum = new javax.swing.JMenuItem();
        jMenuFormMateria = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuCursada = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuNotas = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuListaAlum = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Escudo uniG10-50porciento.png"))); // NOI18N

        escritorio1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorio1Layout = new javax.swing.GroupLayout(escritorio1);
        escritorio1.setLayout(escritorio1Layout);
        escritorio1Layout.setHorizontalGroup(
            escritorio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorio1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        escritorio1Layout.setVerticalGroup(
            escritorio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorio1Layout.createSequentialGroup()
                .addContainerGap(266, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(76, 76, 76))
        );

        jMenuBar1.setPreferredSize(new java.awt.Dimension(500, 40));

        jMenu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N

        jMenuSalir.setText("SALIR");
        jMenu1.add(jMenuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenu2.setText("Alumnos");
        jMenu2.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N

        jMenuFormAlum.setText("Formulario Alumnos");
        jMenuFormAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFormAlumActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuFormAlum);

        jMenuBar1.add(jMenu2);

        jMenuFormMateria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuFormMateria.setText("Materias");
        jMenuFormMateria.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N

        jMenuItem3.setText("Formulario Materias");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuFormMateria.add(jMenuItem3);

        jMenuBar1.add(jMenuFormMateria);

        jMenu4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenu4.setText("Inscripciones");
        jMenu4.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N

        jMenuCursada.setText("Cursadas");
        jMenuCursada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCursadaActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuCursada);

        jMenuBar1.add(jMenu4);

        jMenu5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenu5.setText("Carga de Notas");
        jMenu5.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N

        jMenuNotas.setText("Actualizacion de Notas");
        jMenu5.add(jMenuNotas);

        jMenuBar1.add(jMenu5);

        jMenu6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenu6.setText("Consultas");
        jMenu6.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N

        jMenuListaAlum.setText("Cursada de Alumnos x Materia");
        jMenu6.add(jMenuListaAlum);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(escritorio1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
         Fri_Materias formMater=new Fri_Materias();
        //escritorio1.removeAll();
        escritorio1.repaint();
        escritorio1.add(formMater);
        formMater.setVisible(true);
        escritorio1.moveToFront(formMater);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuFormAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFormAlumActionPerformed
           Fri_Alumnos forAlu=new Fri_Alumnos();
        //escritorio1.removeAll();
        escritorio1.repaint();
        escritorio1.add(forAlu);
        forAlu.setVisible(true);
        escritorio1.moveToFront(forAlu); // TODO// T
    }//GEN-LAST:event_jMenuFormAlumActionPerformed

    private void jMenuCursadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCursadaActionPerformed
            Fri_Inscripciones ins=new Fri_Inscripciones();
        //escritorio1.removeAll();
        escritorio1.repaint();
        escritorio1.add(ins);
        ins.setVisible(true);
        escritorio1.moveToFront(ins); 
    }//GEN-LAST:event_jMenuCursadaActionPerformed

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
            java.util.logging.Logger.getLogger(FrMain_Universidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrMain_Universidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrMain_Universidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrMain_Universidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrMain_Universidad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio1;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCursada;
    private javax.swing.JMenuItem jMenuFormAlum;
    private javax.swing.JMenu jMenuFormMateria;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuListaAlum;
    private javax.swing.JMenuItem jMenuNotas;
    private javax.swing.JMenuItem jMenuSalir;
    // End of variables declaration//GEN-END:variables
}

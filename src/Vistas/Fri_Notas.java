package Vistas;

/**
 *
 * @author Grupo 10
 */
public class Fri_Notas extends javax.swing.JInternalFrame {

    /**
     * Creates new form Jif_Materias
     */
    public Fri_Notas() {
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

        lblTitulo = new javax.swing.JLabel();
        lbl_infoAlumno = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        btGuarda = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        cbxAlumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaNotas = new javax.swing.JTable();

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblTitulo.setText("Actualizacion de Notas");

        lbl_infoAlumno.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_infoAlumno.setText("ALUMNO");

        lblSubtitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblSubtitulo.setText("Listado y Carga de Notas");

        btGuarda.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btGuarda.setText("Guardar");

        btCancelar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btCancelar.setText("Cancelar");

        btSalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btSalir.setText("Salir");

        cbxAlumno.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cbxAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTablaNotas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTablaNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "MATERIA", "NOTA"
            }
        ));
        jScrollPane1.setViewportView(jTablaNotas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(104, 104, 104))
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btGuarda)
                        .addGap(86, 86, 86)
                        .addComponent(btCancelar)
                        .addGap(94, 94, 94)
                        .addComponent(btSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_infoAlumno)
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSubtitulo)
                            .addComponent(cbxAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblTitulo)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_infoAlumno)
                    .addComponent(cbxAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblSubtitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btGuarda)
                    .addComponent(btCancelar)
                    .addComponent(btSalir))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btGuarda;
    private javax.swing.JButton btSalir;
    private javax.swing.JComboBox<String> cbxAlumno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaNotas;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lbl_infoAlumno;
    // End of variables declaration//GEN-END:variables
}
